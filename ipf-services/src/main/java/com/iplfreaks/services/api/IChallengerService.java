package com.iplfreaks.services.api;

import java.util.Map;

public interface IChallengerService {
	public Map<String, Object> getFixtureChallenges(String leagueName,
			String fixtureId);
}
