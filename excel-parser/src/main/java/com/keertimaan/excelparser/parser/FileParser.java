package com.keertimaan.excelparser.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public abstract class FileParser {
  private File file;

  public FileParser() {
    setFile(null);
  }

  public FileParser(File file) {
    setFile(file);
  }

  public void setFile(File file) {
    this.file = file;
  }

  public File getFile() throws FileNotFoundException {
    if (file == null) {
      throw new FileNotFoundException("Missing file. Pass the file " +
          "using setFile method before parsing.");
    }

    return file;
  }

  public abstract Map<Integer, String> getFieldNames() throws Exception;

  public abstract List<Map<Integer, String>> getFields() throws Exception;
}
