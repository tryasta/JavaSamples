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

package com.keertimaan.algorithms.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
public class StringProblems {

  /**
   * <p>Checks whether the two inputs are anagram or not. This implementation creates a character historgram of the
   * inputs, and then matches them with one another to see if they match. As far as I know, this is the most
   * efficient approach of determining anagrams (O(n)).</p>
   *
   * @param first the first input string
   * @param second the second input string
   * @return <tt>true</tt> if the inputs are anagram, <tt>false</tt> otherwise.
   */
  public static boolean isAnagram(String first, String second) {
    return !(first == null || second == null) && getCharacterHistogram(first).equals(getCharacterHistogram(second));

  }

  private static Map<Character, Integer> getCharacterHistogram(String source) {
    Map<Character, Integer> histogram = new HashMap<>(source.length());
    for (int i = 0; i < source.length(); i++) {
      final char currentCharacter = source.charAt(i);
      final Integer currentCount = histogram.get(currentCharacter);
      if (currentCount == null) {
        histogram.put(currentCharacter, 1);
      } else {
        histogram.put(currentCharacter, currentCount + 1);
      }
    }

    return histogram;
  }

  /**
   * <p>Checks whether the string contains all unique characters or not. This implementation uses a <tt>HashSet</tt> to
   * check for duplicacy as the <tt>add</tt> method will returns false if you try to add the same character again.</p>
   *
   * <p>Some important points about this implementation -</p>
   *
   * <ul>
   * <li>This implementation runs on O(n) time, but it uses an additional data structure and O(n) extra space.</li>
   * <li> If we do not want to use any additional data structure, then we can sort the original string and then
   * compare the neighbouring characters for match. However, this method destroys the original string.</li>
   * <li>If we do not want to use additional data structure and are not allowed to destroy the string, then the
   * only other option is to check each character against the whole string, whose running time will be O(n^2).</li>
   * </ul>
   *
   * @param source the string to check for.
   * @return <tt>true</tt> if the string contains no duplicated characters, <tt>false</tt> otherwise.
   */
  public static boolean hasAllUniqueCharacters(String source) {
    if (source == null) {
      return false;
    }

    Set<Character> characters = new HashSet<>(source.length());
    for (int i = 0; i < source.length(); i++) {
      if (!characters.add(source.charAt(i))) {
        return false;
      }
    }

    return true;
  }
}
