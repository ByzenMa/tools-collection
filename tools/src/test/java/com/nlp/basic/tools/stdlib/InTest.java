package com.nlp.basic.tools.stdlib;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mabaizhang on 2017/7/3.
 */
public class InTest {
    private In testResource;
    private In testUrl;

    @Before
    public void setUp() {
        String resourceFile = "readFiles.txt";
        testResource = new In(resourceFile);
    }

    @Test
    public void exists() throws Exception {
        assertTrue(testResource.exists());
    }

    @Test
    public void isEmpty() throws Exception {
        assertFalse(testResource.isEmpty());
    }

    @Test
    public void hasNextLine() throws Exception {
        assertTrue(testResource.hasNextLine());
    }

    @Test
    public void hasNextChar() throws Exception {
        assertTrue(testResource.hasNextLine());
    }

    @Test
    public void readLine() throws Exception {
        assertEquals("This is English content.", testResource.readLine());
    }

    @Test
    public void readChar() throws Exception {
        assertEquals('T', testResource.readChar());
    }

    @Test
    public void readAll() throws Exception {
        assertNotNull(testResource.readAll());
    }

    @Test
    public void readString() throws Exception {
        StdOut.println(testResource.readString());
        StdOut.println(testResource.readString());
        StdOut.println(testResource.readString());
        StdOut.println(testResource.readString());
        StdOut.println(testResource.readString());
    }

    @Test
    public void readAllStrings() throws Exception {
        String[] re = testResource.readAllStrings();
        for (String l : re) {
            StdOut.println(l);
        }
    }

    @Test
    public void readAllLines() throws Exception {
        String[] re = testResource.readAllLines();
        for (String l : re) {
            StdOut.println(l);
        }
    }

    @Ignore
    public void main() throws Exception {
        In in;
        String urlName = "http://introcs.cs.princeton.edu/stdlib/InTest.txt";

        // read from a URL
        System.out.println("readAll() from URL " + urlName);
        System.out.println("---------------------------------------------------------------------------");
        try {
            in = new In(urlName);
            System.out.println(in.readAll());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println();

        // read one line at a time from URL
        System.out.println("readLine() from URL " + urlName);
        System.out.println("---------------------------------------------------------------------------");
        try {
            in = new In(urlName);
            while (!in.isEmpty()) {
                String s = in.readLine();
                System.out.println(s);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println();

        // read one string at a time from URL
        System.out.println("readString() from URL " + urlName);
        System.out.println("---------------------------------------------------------------------------");
        try {
            in = new In(urlName);
            while (!in.isEmpty()) {
                String s = in.readString();
                System.out.println(s);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println();


        // read one line at a time from file in current directory
        System.out.println("readLine() from current directory");
        System.out.println("---------------------------------------------------------------------------");
        try {
            in = new In("./InTest.txt");
            while (!in.isEmpty()) {
                String s = in.readLine();
                System.out.println(s);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println();


        // read one line at a time from file using relative path
        System.out.println("readLine() from relative path");
        System.out.println("---------------------------------------------------------------------------");
        try {
            in = new In("../stdlib/InTest.txt");
            while (!in.isEmpty()) {
                String s = in.readLine();
                System.out.println(s);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println();

        // read one char at a time
        System.out.println("readChar() from file");
        System.out.println("---------------------------------------------------------------------------");
        try {
            in = new In("InTest.txt");
            while (!in.isEmpty()) {
                char c = in.readChar();
                System.out.print(c);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println();
        System.out.println();

        // read one line at a time from absolute OS X / Linux path
        System.out.println("readLine() from absolute OS X / Linux path");
        System.out.println("---------------------------------------------------------------------------");
        in = new In("/n/fs/introcs/www/java/stdlib/InTest.txt");
        try {
            while (!in.isEmpty()) {
                String s = in.readLine();
                System.out.println(s);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println();


        // read one line at a time from absolute Windows path
        System.out.println("readLine() from absolute Windows path");
        System.out.println("---------------------------------------------------------------------------");
        try {
            in = new In("G:\\www\\introcs\\stdlib\\InTest.txt");
            while (!in.isEmpty()) {
                String s = in.readLine();
                System.out.println(s);
            }
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println();

    }

}