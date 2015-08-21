package com.keertimaan.accessreader;

import com.keertimaan.accessreader.reader.Reader;

/**
 * Hello world!
 *
 */
public class Main {
  public static void main(String[] args) {
    //org.apache.log4j.BasicConfigurator.configure();
    System.out.println("Hello World!");

    Reader reader = new Reader();
    reader.Read();
  }
}
