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

package com.keertimaan.algorithms.linkedlist;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
public class SinglyLinkedListTest {

  @Test
  public void testCountAfterMultipleInsertInANewList() {
    verifyCountForNInsert(0);
    verifyCountForNInsert(1);
    verifyCountForNInsert(3);
    verifyCountForNInsert(10);
    verifyCountForNInsert(100);
  }

  @Test
  public void testRetrievalInListFromEmptySinglyList() {
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    assertThat(singlyLinkedList.asList()).isEmpty();
  }

  @Test
  public void testRetrievalInListFromPopulatedSinglyList() {
    verifyRetrievalAfterMultiInsert(Collections.singletonList("One"));
    verifyRetrievalAfterMultiInsert(Arrays.asList("One", "Two", "Three", "Four"));
  }

  private void verifyCountForNInsert(int numberOfInsert) {
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    IntStream.range(0, numberOfInsert)
        .forEach(index -> singlyLinkedList.insert(index + ""));
    assertThat(singlyLinkedList.count()).isEqualTo(numberOfInsert);
  }

  private void verifyRetrievalAfterMultiInsert(List<String> elements) {
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    elements.stream()
        .forEach(singlyLinkedList::insert);
    assertThat(singlyLinkedList.asList()).isEqualTo(elements);
  }
}
