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

/**
 * <p>The leaf item.</p>
 *
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
public class File extends FileItem {

  public File(String filePath) {
    super(filePath);
  }

  @Override
  public void delete() {
    System.out.println("Deleting file from " + getPath());
  }
}
