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

package com.keertimaan.algorithms.projecteuler;

/**
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
public class ProjectEuler1To10 {

  /**
   * 1. If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of
   * these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.
   *
   * Revision 1
   */
  public static int multipleOf3And5LessThan(int limit) {
    limit--;
    return getSumFor(3, limit) + getSumFor(5, limit) - getSumFor(15, limit);
  }

  private static int getSumFor(int num, int limit) {
    int lastTerm = limit / num;
    return num * ((lastTerm * (lastTerm + 1)) / 2);
  }
}
