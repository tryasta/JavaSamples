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
public class StringRecursiveReverseTest {

  @Test
  public void shouldReturnNullWhenSourceIsNull() {
    assertThat(StringProblems.reverse(null)).isNull();
  }

  @Test
  public void shouldReturnEmptyWhenSourceIsEmpty() {
    assertThat(StringProblems.reverse("")).isEmpty();
  }

  @Test
  public void shouldReverseStringsWithOneCharacter() {
    assertThat(StringProblems.reverse("a")).isEqualTo("a");
  }

  @Test
  public void shouldReverseStringsWithMultipleCharacters() {
    assertThat(StringProblems.reverse("abcd")).isEqualTo("dcba");
  }
}
