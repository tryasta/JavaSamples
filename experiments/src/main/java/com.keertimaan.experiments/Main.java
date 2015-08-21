/**
 * Copyright 2015 Sayem Ahmed
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.keertimaan.experiments;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
public class Main {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    String input = FileUtils.readFileToString(new File("hogehoge.csv"), "UTF-8");
    System.out.println("Input: " + input);

    System.out.println("number: " + input.trim()
        .equals("1234567890"));
    int number = Integer.parseInt(input);
    System.out.println("num num: " + number);
  }
}
