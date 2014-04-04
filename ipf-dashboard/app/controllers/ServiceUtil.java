/*
 * Copyright (c) 2013 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package controllers;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.node.ObjectNode;

import play.libs.F.Promise;
import play.libs.Json;
import play.libs.WS;
import play.libs.WS.WSRequestHolder;
import play.mvc.Http;

/**
 * 
 * @author 502174223
 */
public class ServiceUtil {
	
	private final static String APPLICATION_JSON = "application/json";
	private final static String CONTENT_TYPE = "Content-Type";
	private final  static long TIMEOUT = 45000;

	private static final String BASE_REQUEST_URL = play.Play.application().configuration().getString("BASE_REQUEST_URL");
    
	
	public static WS.Response callGET(String path,String contentType, Map<String,String> queryParameters) {
        return callGET(path, contentType, queryParameters, TIMEOUT);
    }
	
	public static WS.Response callGET(String path,String contentType, Map<String,String> queryParameters, long timeout) {
        return callGET(BASE_REQUEST_URL, path, contentType, queryParameters, timeout);
    }
	
	 public static WS.Response callGET(String pathPrefix, String path,String contentType, Map<String,String> queryParameters, long timeout) {

	        StringBuilder serviceUrl= new StringBuilder().append(pathPrefix).append(path);
	        WSRequestHolder requestHolder = WS
	                .url(serviceUrl.toString())
	                .setHeader(CONTENT_TYPE, contentType)
	        		.setHeader("Accept", contentType);
	        if (queryParameters != null) {
	            for (Map.Entry<String, String> entry : queryParameters.entrySet()) {
	                requestHolder.setQueryParameter(entry.getKey(), entry.getValue());
	            }
	        }
	        Promise<WS.Response> wsResponse = requestHolder.get();
	        //wsResponse.getWrappedPromise().await(timeout, TimeUnit.MILLISECONDS);
	       // System.out.println(">>ServiceUtil callGET() to " + serviceUrl.toString() + " response.get().getBody()..." + wsResponse.get().getBody());

	        return wsResponse.get(timeout, TimeUnit.MILLISECONDS);
	    }

	public static String callPOST(String path,String jsonRequest, Map<String,String> queryParameters,long promiseTime) {
		String response;
		StringBuilder serviceUrl= new StringBuilder().append(BASE_REQUEST_URL).append(path);
		System.out.println("serviceUrl "+serviceUrl);
		//System.out.println(">>ServiceUtil  serviceUrl ="+serviceUrl );
        //String accessToken = Http.Context.current().session().get(AUTHORIZATION_HEADER_NAME);
		WSRequestHolder requestHolder = WS
				.url(serviceUrl.toString())
				.setHeader(CONTENT_TYPE, "application/x-www-form-urlencoded");
        /*if (accessToken != null && !accessToken.isEmpty()) {
                requestHolder.setHeader(AUTHORIZATION_HEADER_NAME, accessToken);
        }*/
        if (queryParameters != null) {
            for (Map.Entry<String, String> entry : queryParameters.entrySet()) {
                requestHolder.setQueryParameter(entry.getKey(), entry.getValue());
            }
        }

		Promise<WS.Response> wsResponse = null;
		try {
			if(jsonRequest!=null){
				wsResponse = requestHolder.post(jsonRequest);	
			}else{
				wsResponse = requestHolder.post("");
			}
			//wsResponse.getWrappedPromise().await(promiseTime, TimeUnit.MILLISECONDS);
			
			boolean jsonNode = wsResponse.get(50000L, TimeUnit.MILLISECONDS).asJson().asBoolean();
			response = String.valueOf(jsonNode);
			response=wsResponse.get(promiseTime, TimeUnit.MILLISECONDS).getBody();
			System.out.println("The response is "+response);
            //System.out.println(">>ServiceUtil callPOST() to " + serviceUrl.toString() + " response.get().getBody()..." + response);
			if("".equals(response)){
				throw new Exception ("Response body is empty ");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 ObjectNode data = Json.newObject();
			
			 ObjectNode statusMessage = Json.newObject();
			 statusMessage.put("status", "500");
			 statusMessage.put("message",e.getMessage());
			 ObjectNode RestResponse = Json.newObject();
			 
			 RestResponse.put("statusMessage", statusMessage);
			 data.put("RestResponse",RestResponse);
			 
			 response= data.toString();
			 System.out.println("response on error >>"+ response);
		}
		 
		return response;
	}
	
	/**
	* This method Apache's HTTPAsync client to invoke long running REST web services asynchronously.
	* Only supports GET requests
	* Only supports application/json content type.
	*
	* String URL
	*		 URL of the restful webservice to be invoked (GET request only)
	* boolean 	processResponse
	*		As this method processes asyc request, there can be scenario wherein user wants to process the response
	*		In case of QRDA III , we need to process the response and send back the file to the user
	*		In case od QRDA I , we just need to fire the REST web request, output file will be emailed to the user.	
	**/
	/*public static byte[] callHttpGet(String url, boolean processResponse, boolean requireAccessToken)
	{
		String AUTHORIZATION_HEADER_NAME = play.Play.application().configuration().getString("AUTHORIZATION_HEADER_NAME");
		String accessToken = Http.Context.current().session().get(AUTHORIZATION_HEADER_NAME);
        StringBuilder responseContent = new StringBuilder();
        final CloseableHttpAsyncClient httpClient = HttpAsyncClients.createDefault();
        httpClient.start();
        byte[] fileContent=null;
		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("Content-Type", "application/json");
		if(requireAccessToken)
		{
			httpGet.addHeader(AUTHORIZATION_HEADER_NAME,accessToken);
		}
		
		try {
		 final Future<HttpResponse> future = httpClient.execute(httpGet, null);
		 if(processResponse)
		 {
			 	final HttpResponse httpResponse = future.get();
				if(httpResponse.getStatusLine().getStatusCode()!=200)
				{
					play.Logger.debug("Downloading of QRDA failed due to some exception from DSP service");
				}
				else 
				{	
				HttpEntity entity = httpResponse.getEntity();
		
				byte[] buffer = new byte[1024];
				if (entity != null) {
					InputStream inputStream = entity.getContent();
					BufferedInputStream bis =null;
					try {
						int bytesRead = 0;
						bis = new BufferedInputStream(inputStream);
						while ((bytesRead = bis.read(buffer)) != -1) {
							String chunk = new String(buffer, 0, bytesRead);
							responseContent.append(chunk);
						}
	          
						ObjectMapper mapper = new ObjectMapper();
						JsonFactory factory = mapper.getJsonFactory();
						JsonParser parser = factory.createJsonParser(responseContent.toString());
						JsonNode node = mapper.readTree(parser);
			    
				
						play.Logger.debug("node "+node);
						String resFileName = node.findPath("fileName").asText();
						play.Logger.debug("fileName-->"+resFileName);
				
						fileContent = node.findPath("fileContent").getBinaryValue();
						play.Logger.debug("fileContent -->"+fileContent.length);
	          
					} catch (IOException ioException) {
						play.Logger.error("Exception occured while reading json file : ",ioException);
					} catch (RuntimeException runtimeException) {
						httpGet.abort();
						play.Logger.error("Exception occured while reading json file : ",runtimeException);
					} finally {
						try {
							if(bis != null)
							{
								bis.close(); 		
							}
							if(inputStream != null)
							{
								inputStream.close(); 		
							}
						} catch (Exception e) {
							bis = null;
							inputStream = null;
							play.Logger.error("Exception occured while reading json file : ",e);
						}
					}
				}
			}
		 }
	    	} catch (ClientProtocolException e) {
	    		play.Logger.error("Exception occured while hitting DSP webservice : ",e);
	    	} catch (IOException e) {
	    		play.Logger.error("Exception occured while hitting DSP webservice : ",e);
	    	} catch (Exception e) {
	    		play.Logger.error("Exception occured while hitting DSP webservice : ",e);
	    	}finally {
	    		try{
				if(	httpClient != null && httpClient.getConnectionManager() != null){
					httpClient.getConnectionManager().shutdown();
				}
	    		}catch (Exception e) {
					play.Logger.error("Exception occured while closing httpClient : ",e);
				}
	    	}
	    	return fileContent;
		}
*/
}
