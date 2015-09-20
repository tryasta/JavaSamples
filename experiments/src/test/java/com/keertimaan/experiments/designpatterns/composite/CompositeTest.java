/**
 * Copyright 2015 Sayem Ahmed
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.keertimaan.experiments.designpatterns.composite;

import org.junit.Test;

/**
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
public class CompositeTest {

  @Test
  public void testPattern() {
    Directory directory = new Directory("C:\\Program Files\\Folder folder");
    System.out.println("Created directory. Path is " + directory.getPath());

    directory.addItem(new File("C:\\Program Files\\Folder folder\\hogehoge.txt"));
    directory.delete();
  }
}
