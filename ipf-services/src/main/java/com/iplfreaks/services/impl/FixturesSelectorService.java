package com.iplfreaks.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.iplfreaks.services.api.IFixturesSelectorService;

public class FixturesSelectorService implements IFixturesSelectorService {

	@Override
	public List<String> getFixtures(final DateTime date) {
		return new ArrayList<String>();
	}
}
