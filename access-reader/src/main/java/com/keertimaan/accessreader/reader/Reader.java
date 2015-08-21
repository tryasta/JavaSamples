/*
 * $Header: $
 *
 * Copyright (C) 2013.
 * All Rights Reserved.  No use, copying or distribution of this
 * work may be made except in accordance with a valid license
 * agreement.  This notice must be included on all copies,
 * modifications and derivatives of this work.
 */

package com.keertimaan.accessreader.reader;

import java.io.File;
import java.util.Map;
import java.util.Set;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;

/**
 * @author <a href="mailto:sayem64@gmail.com">Sayem Ahmed</a>
 * @author last modified by $Author$
 * @version $Id$
 */

public class Reader {

  public Reader() {
  }

  public void Read() {
    try {
      File file = new File("C:\\Workspace\\IHA_Q311_RB.mdb");

      System.out.println("File existence: " + file.exists());

      Database db = Database.open(file);

      Table table = db.getTable("_IHA");
      for (Map<String, Object> test : table) {
        StringBuilder builder = new StringBuilder();
        Set<String> keys = test.keySet();

        for (String key : keys) {
          Object value = test.get(key);

          if (value != null) {
            builder.append(value);
          }
        }

        String output = builder.toString();
        if (output.startsWith("HD"))
          System.out.println(builder.toString());
      }

      db.close();
    }
    catch (Exception e) {
      System.out.print("Exception occured while trying to close database: ");
      System.out.println(e.getMessage());
    }
  }
}
