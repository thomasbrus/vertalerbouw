package vb.week1.wc;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class WordCountScanner extends WordCount {
    /**
     * Counts the number of characters, words and lines
     * in this WordCount's reader.      
     */
    public void count() throws IOException {
        this.nChars = this.nWords = this.nLines = 0;
        Scanner lines = new Scanner(new BufferedReader(this.reader)).useDelimiter("\n");

        while(lines.hasNext()){
        	this.nLines++; this.nChars++;
        	String line = lines.next();
        	Scanner scline = new Scanner(line);
        	this.nChars += line.length();
        	while(scline.hasNext()){
        		scline.next();
        		this.nWords++;
        	}    		
        }   
    }

    public static void main(String[] args) {
        wcArgs(args, new WordCountScanner());
    }
}
