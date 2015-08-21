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
  public void testNullValueInsert() {
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    assertThat(singlyLinkedList.insert(null)).isFalse();
    assertThat(singlyLinkedList.contains(null)).isFalse();
  }

  @Test
  public void testNonNullValueInsert() {
    final String dummyValue = "Dummy";
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    assertThat(singlyLinkedList.insert(dummyValue)).isTrue();
    assertThat(singlyLinkedList.contains(dummyValue)).isTrue();
  }

  @Test
  public void testEmptiness() {
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    assertThat(singlyLinkedList.isEmpty()).isTrue();
    singlyLinkedList.insert("Dummy");
    assertThat(singlyLinkedList.isEmpty()).isFalse();
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

  @Test
  public void testFindingNonExistentElement() {
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    assertThat(singlyLinkedList.contains("test")).isFalse();
  }

  @Test
  public void testFindingExistingElement() {
    final String firstString = "One";
    final String secondString = "Two";
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    singlyLinkedList.insert(firstString);
    assertThat(singlyLinkedList.contains(firstString)).isTrue();
    singlyLinkedList.insert(secondString);
    assertThat(singlyLinkedList.contains(secondString)).isTrue();
  }

  @Test
  public void testRemoveFromEmptyList() {
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    assertThat(singlyLinkedList.remove("test")).isFalse();
  }

  @Test
  public void testRemoveFromSingleElementList() {
    final String toBeRemoved = "test";
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    singlyLinkedList.insert(toBeRemoved);
    assertThat(singlyLinkedList.remove(toBeRemoved)).isTrue();
    assertThat(singlyLinkedList.contains(toBeRemoved)).isFalse();
  }

  @Test
  public void testRemoveFirstElement() {
    final String toBeRemoved = "test";
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    singlyLinkedList.insert(toBeRemoved);
    singlyLinkedList.insert("two");
    assertThat(singlyLinkedList.remove(toBeRemoved)).isTrue();
    assertThat(singlyLinkedList.contains(toBeRemoved)).isFalse();
  }

  @Test
  public void testRemovalOfOneOfTheDuplicates() {
    final String toBeRemoved = "test";
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    singlyLinkedList.insert(toBeRemoved);
    singlyLinkedList.insert(toBeRemoved);
    assertThat(singlyLinkedList.remove(toBeRemoved)).isTrue();
    assertThat(singlyLinkedList.contains(toBeRemoved)).isTrue();
  }

  @Test
  public void testRemoveFromMiddleOfList() {
    final String toBeRemoved = "two";
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    singlyLinkedList.insert("one");
    singlyLinkedList.insert(toBeRemoved);
    singlyLinkedList.insert("three");
    assertThat(singlyLinkedList.remove(toBeRemoved)).isTrue();
    assertThat(singlyLinkedList.contains(toBeRemoved)).isFalse();
  }

  @Test
  public void testRemoveFromLast() {
    final String toBeRemoved = "three";
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    singlyLinkedList.insert("one");
    singlyLinkedList.insert("two");
    singlyLinkedList.insert(toBeRemoved);
    assertThat(singlyLinkedList.remove(toBeRemoved)).isTrue();
    assertThat(singlyLinkedList.contains(toBeRemoved)).isFalse();
  }

  @Test
  public void testRemoveForNonexistentelement() {
    final String toBeRemoved = "five";
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    singlyLinkedList.insert("one");
    singlyLinkedList.insert("two");
    singlyLinkedList.insert("three");
    singlyLinkedList.insert("four");
    assertThat(singlyLinkedList.remove(toBeRemoved)).isFalse();
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testElementReversal() {
    verifyListReversal(Collections.EMPTY_LIST);
    verifyListReversal(Collections.singletonList("Hello"));
    verifyListReversal(Arrays.asList("First", "Second", "Third"));
    verifyListReversal(Arrays.asList("First", "Second", "Third", "Fourth", "Fifth"));
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

  private void verifyListReversal(List<String> elements) {
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    elements.stream()
        .forEach(singlyLinkedList::insert);
    singlyLinkedList.reverse();
    Collections.reverse(elements);
    assertThat(singlyLinkedList.asList()).isEqualTo(elements);
  }
}
