package com.test.beans13.aop;

import org.springframework.stereotype.Component;

@Component
public class CalcImpl implements ICalc {

	public int add(int i, int j) {
		int result=i+j;
		return result;
	}

	public int sub(int i, int j) {
		int result=i-j;
		return result;
	}

	public int mul(int i, int j) {
		int result=i*j;
		return result;
	}

	public int div(int i, int j) {
		int result=i/j;
		return result;
	}

}
