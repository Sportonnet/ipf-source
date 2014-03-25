package com.iplfreaks.common;

import java.util.Map;

public class RestServiceResponse {

	private String status;
	private String errorMessage;
	private Map<String, Object> result;

	public RestServiceResponse() {
		super();
	}

	/**
	 * 
	 * @param status
	 *            status for the response
	 * @param errorMessage
	 *            error message if any failure
	 * @param result
	 *            result in a map if success
	 */
	public RestServiceResponse(String status, String errorMessage,
			Map<String, Object> result) {
		this.status = status;
		this.errorMessage = errorMessage;
		this.result = result;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the result
	 */
	public Map<String, Object> getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

}
