package vb.week1.wc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * VB prac week1.
 * WordCount in Java.
 * @author  Theo Ruys
 * @version 2006.04.21
 */
public class WordCount {
    protected Reader reader = null;
    protected int nChars = 0;
    protected int nWords = 0;
    protected int nLines = 0;

    public void setReader(Reader r) {
        this.reader = r;
    }

    /**
     * Counts the number of characters, words and lines
     * in this WordCount's reader.
     */
    public void count() throws IOException {
        this.nChars = this.nWords = this.nLines = 0;
        BufferedReader in = new BufferedReader(this.reader);

        int ch;
        boolean inWhiteSpace = true;
        while ((ch = in.read()) != -1) {
            this.nChars++;
            if (Character.isWhitespace((char)ch)) {
                inWhiteSpace = true;
                if (ch == '\n') {
                    this.nLines++;
                }
            } else if (inWhiteSpace) { // previous char was whitespace
                this.nWords++;
                inWhiteSpace = false;
            }
        }
    }

    public int getChars() { return this.nChars; }
    public int getWords() { return this.nWords; }
    public int getLines() { return this.nLines; }

    private static String right(String s, int width) {
        return right(s, width, ' ');
    }

    public static String right(String s, int width, char fillChar) {
        if (s.length() >= width) {
            return s;
        }
        StringBuffer sb = new StringBuffer(width);
        for (int i= width - s.length(); --i >= 0; ) {
            sb.append(fillChar);
        }
        sb.append(s);
        return sb.toString();
    }

    @Override
    public String toString() {
        return right(Integer.toString(this.nLines), 8) +
                right(Integer.toString(this.nWords), 8) +
                right(Integer.toString(this.nChars), 8);
    }

    public static void wcArgs(String[] args, WordCount wc) {
        for (int i = 0; i < args.length; i++) {
            String fname = args[i];
            File f = new File(fname);
            try {
                wc.setReader(new FileReader(f));
                wc.count();
                System.out.println(wc + " " + fname);
            }
            catch (FileNotFoundException e) {
                System.err.println("error opening: " + e.getMessage());
            }
            catch (IOException e) {
                System.err.println("error reading file: " + fname);
            }
        }
    }

    public static void main(String[] args) {
        wcArgs(args, new WordCount());
    }
}
