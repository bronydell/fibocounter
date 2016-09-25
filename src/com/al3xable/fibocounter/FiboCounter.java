package com.al3xable.fibocounter;

import java.io.File;
import java.math.BigInteger;

public class FiboCounter {
	File _outputFile = null;
	
	public FiboCounter(File outputFile) {
		_outputFile = outputFile;
	}
	
	private void _out(String str) {
		System.out.println(str);
	}
	
	public void start() {
		BigInteger pre = new BigInteger("0");
		BigInteger cur = new BigInteger("1");
		BigInteger sum = new BigInteger("1");
		
		while (true) {
			_out(sum.toString());
			sum = pre.add(cur);
			pre = cur;
			cur = sum;
		}
	}
}
