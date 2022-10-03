package com.vicky.imooc.testCase;

import com.vicky.imooc.base.DriverBase;

public class CaseBase {
	public DriverBase initDriver(String browserName) {
		return new DriverBase(browserName);
	}
}
