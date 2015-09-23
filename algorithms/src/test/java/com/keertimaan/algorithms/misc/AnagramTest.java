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

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
public class AnagramTest {

  @Test
  public void shouldReturnFalseWhenEitherOneArgumentIsNull() {
    assertThat(StringProblems.isAnagram(null, "abcd")).isFalse();
    assertThat(StringProblems.isAnagram("sample", null)).isFalse();
  }

  @Test
  public void shouldReturnFalseWhenBothArgumentsAreNull() {
    assertThat(StringProblems.isAnagram(null, null)).isFalse();
  }

  @Test
  public void shouldReturnFalseWhenArgumentsDoNotHaveSameLength() {
    assertThat(StringProblems.isAnagram("aabc", "aab")).isFalse();
  }

  @Test
  public void shouldReturnTrueWhenInputsAreSame() {
    assertThat(StringProblems.isAnagram("aabb", "aabb")).isTrue();
  }

  @Test
  public void shouldReturnFalseWhenInputsAreSameLengthButNotAnagram() {
    assertThat(StringProblems.isAnagram("aaab", "aabb")).isFalse();
  }

  @Test
  public void shouldReturnTrueWhenInputsAreAnagram() {
    assertThat(StringProblems.isAnagram("aabb", "abab")).isTrue();
  }
}
