package com.al3xable.fibocounter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class FiboCounter {
	String _outputFile = null;
	BufferedWriter _writer = null;
	
	public FiboCounter(String outputFile) {
		_outputFile = outputFile;
		
		try {
			if (_outputFile != null) {
				_writer = new BufferedWriter(new FileWriter(outputFile));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void _out(String number, int id) {
		if (_writer != null) {
			try {
				_writer.write(number + '\n');
				_writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println(id);
		} else {
			System.out.println(number);
		}
	}
	
	public void start() {
		BigInteger pre = new BigInteger("0");
		BigInteger cur = new BigInteger("1");
		BigInteger sum = new BigInteger("1");
		int id = 1;
		
		while (true) {
			_out(sum.toString(), id);
			sum = pre.add(cur);
			pre = cur;
			cur = sum;
			id++;
		}
	}
}
