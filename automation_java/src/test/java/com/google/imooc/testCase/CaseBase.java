package com.google.imooc.testCase;

import com.google.imooc.base.DriverBase;

public class CaseBase {
	public DriverBase initDriver(String browserName) {
		return new DriverBase(browserName);
	}
}
