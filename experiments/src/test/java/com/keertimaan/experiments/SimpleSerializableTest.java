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

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
public class SimpleSerializableTest {

  @Test
  public void whatIsTheDefaultValueAfterDeserialization() throws IOException, ClassNotFoundException {
    SimpleSerializable in = new SimpleSerializable();
    in.firstName = "Hoge";
    in.lastName = "Fuga";
    String targetFileName = "simple_serializable.ser";
    try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(targetFileName))) {
      outStream.writeObject(in);
    }

    SimpleSerializable out;
    try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(targetFileName))) {
      out = (SimpleSerializable) inStream.readObject();
    }

    // Case 1: Default value for primitives
    System.out.println("Default value for boolean: " + out.boolPrim);
    System.out.println("Default value for character: " + (int) out.charPrim);
    System.out.println("Default value for byte: " + out.bytePrim);
    System.out.println("Default value for short: " + out.shortPrim);
    System.out.println("Default value for int: " + out.intPrim);
    System.out.println("Default value for long: " + out.longPrim);
    System.out.println("Default value for float: " + out.floatPrim);
    System.out.println("Default value for double: " + out.doublePrim);

    // Case 2: Default value for String
    System.out.println("Default value for string: " + out.strPrim);

    // Case 3: Default value for other object reference
    System.out.println("Default value for object in general: " + out.randomRef);

    // Case 4: Default value for transient variable which was initialized?
    System.out
        .println("Default value for transient variable which was initialized: " + out.intTransientWithInitialization);

    // Case 5: Default value for final transient variable which was initialzied inline?
    System.out
        .println("Default value for final transient variable which was initialzied directly: " + out.intFinalTransient);
  }
}
