package com.al3xable.fibocounter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class FiboCounter {
	private String _outputFile = null;
	private BufferedWriter _writer = null;
	
	private BigInteger _pre = new BigInteger("0");
	private BigInteger _cur = new BigInteger("1");
	private int _line = 1;
	
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
	
	private void _out(String number, int line) {
		if (_writer != null) {
			try {
				_writer.write(number + '\n');
				_writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println(line);
		} else {
			System.out.println(number);
		}
	}
	
	public void start() {
		if (_line == 1) {
			_out("1", 1);
		}
		
		BigInteger sum;
		
		while (true) {
			_line++;
			sum = _pre.add(_cur);
			_pre = _cur;
			_cur = sum;
			_out(sum.toString(), _line);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
