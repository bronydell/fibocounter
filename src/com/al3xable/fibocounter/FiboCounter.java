package com.al3xable.fibocounter;

import java.io.File;
import java.math.BigInteger;

public class FiboCounter {
	public FiboCounter(File outputFile) {
		
	}
	
	public void start() {
		BigInteger pre = new BigInteger("0");
		BigInteger cur = new BigInteger("1");
		BigInteger sum = new BigInteger("1");
		
		while (true) {
			System.out.println(sum);
			sum = pre.add(cur);
			pre = cur;
			cur = sum;
		}
	}
}
