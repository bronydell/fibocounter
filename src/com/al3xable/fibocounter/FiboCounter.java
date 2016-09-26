package com.al3xable.fibocounter;

import java.io.*;
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
            	if (new File(_outputFile).exists()) {
            		_readLastState();
            	}
                _writer = new BufferedWriter(new FileWriter(outputFile, true));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void _readLastState() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(_outputFile));

        String endLine = null;
        String preEndLine = null;
        int lineNumber = 0;
        String sCurrentLine = null;
        
        while ((sCurrentLine = br.readLine()) != null) {
            preEndLine = endLine;
            endLine = sCurrentLine;
            lineNumber++;
        }
        
        if (preEndLine != null && endLine != null) {
            _line = lineNumber;
            System.out.println("Line number: " + lineNumber);
            _pre = new BigInteger(preEndLine);
            System.out.println("Pre-end number: " + preEndLine);
            _cur = new BigInteger(endLine);
            System.out.println("End number: " + endLine);
        }
        
        br.close();
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
