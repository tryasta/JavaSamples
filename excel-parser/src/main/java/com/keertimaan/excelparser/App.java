package com.keertimaan.excelparser;

import com.keertimaan.excelparser.parser.ExcelParser;
import com.keertimaan.excelparser.parser.FileParser;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    System.out.println("Hello World!");

    String path = "C:\\Workspace\\Java\\Enterprise\\data.xlsx";
    FileParser parser = new ExcelParser(new File(path));

    try {
      Map<Integer, String> fieldNames = parser.getFieldNames();
      for (Map.Entry<Integer, String> fieldName: fieldNames.entrySet()) {
        System.out.print(fieldName.getValue() + ", ");
      }

      List<Map<Integer, String>> rows = parser.getFields();
      for (Map<Integer, String> row: rows) {
        for (Map.Entry<Integer, String> entry: row.entrySet()) {
          System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
        }

        System.out.println("");
      }
    }
    catch (Exception ex) {
      System.out.println("Exception occured: " + ex.getMessage());
    }
  }
}
