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

import java.io.Serializable;

/**
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
public class SimpleSerializable implements Serializable {
  String firstName;
  String lastName;

  // Case 1: What will be the default value of primitives after deserialization?
  boolean boolPrim;
  char charPrim;
  byte bytePrim;
  short shortPrim;
  int intPrim;
  long longPrim;
  float floatPrim;
  double doublePrim;

  // Case 2: What will be default value of a string after deserialization?
  String strPrim;

  // Case 3: Another random object reference
  Object randomRef;

  // Case 4: Default value for transient variable which was initialized?
  transient int intTransientWithInitialization = 10;

  // Case 5: Default value for final transient variable which was initialzied inline?
  transient final int intFinalTransient = 50;
}
