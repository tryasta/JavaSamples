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

import java.util.ArrayList;
import java.util.List;

/**
 * <p>The composite.</p>
 *
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
public class Directory extends FileItem {
  private List<FileItem> children;

  public Directory(String directoryPath) {
    super(directoryPath);
    children = new ArrayList<>();
  }

  public Directory addItem(FileItem item) {
    children.add(item);
    return this;
  }

  @Override
  public void delete() {
    System.out.println("Starting to delete all the children first......");
    children.stream()
        .forEach(FileItem::delete);
    System.out.println("Deleted all the children. Now deleting this directory.......");
  }
}
