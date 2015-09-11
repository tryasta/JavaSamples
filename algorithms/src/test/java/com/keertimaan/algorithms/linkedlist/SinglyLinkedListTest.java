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

import java.util.ArrayList;
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
  public void testNullValueInsertAndFind() {
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    assertThat(singlyLinkedList.insert(null)).isFalse();
    assertThat(singlyLinkedList.contains(null)).isFalse();
  }

  @Test
  public void testNonNullValueInsertAndFind() {
    verifyNonNullValueInsertAndFind(Collections.singletonList("Dummy"));
    verifyNonNullValueInsertAndFind(Arrays.asList("One", "Two"));
    verifyNonNullValueInsertAndFind(Arrays.asList("One", "Two", "Three"));
  }

  @Test
  public void testNonNullValueInsertAndFindForLargeNumberOfData() {
    List<String> longListOfValues = new ArrayList<>();
    for (int i = 1; i <= 1000; i++) {
      longListOfValues.add("Number " + i);
    }
    verifyNonNullValueInsertAndFind(longListOfValues);
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
    verifyRetrievalAfterMultiInsert(Collections.emptyList());
    verifyRetrievalAfterMultiInsert(Arrays.asList("One", "Two", "Three", "Four"));
  }

  @Test
  public void testFindingNonExistentElement() {
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    assertThat(singlyLinkedList.contains("test")).isFalse();
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

  @Test
  public void testConsecutiveInsertAndRemove() {
    SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
    linkedList.insert("first");
    assertThat(linkedList.remove("first")).isTrue();

    linkedList.insert("first");
    linkedList.insert("second");
    assertThat(linkedList.remove("second")).isTrue();

    linkedList.insert("second");
    linkedList.insert("third");
    assertThat(linkedList.remove("second")).isTrue();
    assertThat(linkedList.contains("second")).isFalse();
    assertThat(linkedList.asList()).isEqualTo(Arrays.asList("first", "third"));
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testElementReversalIterative() {
    verifyListReversalIterative(Collections.EMPTY_LIST);
    verifyListReversalIterative(Collections.singletonList("Hello"));
    verifyListReversalIterative(Arrays.asList("First", "Second", "Third"));
    verifyListReversalIterative(Arrays.asList("First", "Second", "Third", "Fourth", "Fifth"));
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testElementReversalRecursive() {
    verifyListReversalRecursive(Collections.EMPTY_LIST);
    verifyListReversalRecursive(Collections.singletonList("Hello"));
    verifyListReversalRecursive(Arrays.asList("First", "Second", "Third"));
    verifyListReversalRecursive(Arrays.asList("First", "Second", "Third", "Fourth", "Fifth"));
  }

  @Test
  public void testReverseInBetweenStartingFromHeadAndPortionOfList() {
    verifyReverseInBetween(Arrays.asList("one", "two", "three", "four"), 1, 3);
    verifyReverseInBetween(Arrays.asList("one", "two", "three", "four"), 1, 4);
    verifyReverseInBetween(Collections.singletonList("One"), 1, 1);
    verifyReverseInBetween(Arrays.asList("1", "2", "3", "4", "5"), 2, 3);
    verifyReverseInBetween(Arrays.asList("1", "2", "3", "4", "5"), 2, 5);
    verifyReverseInBetween(Arrays.asList("1", "2", "3", "4", "5"), 4, 5);
    verifyReverseInBetween(Arrays.asList("1", "2", "3", "4", "5"), 5, 5);
    verifyReverseInBetween(Arrays.asList("1", "2", "3", "4", "5"), 2, 4);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testRemoveAll() {
    verifyRemoveAll(Arrays.asList("1", "2", "3"), "1");
    verifyRemoveAll(Arrays.asList("1", "2", "2", "3"), "2");
    verifyRemoveAll(Arrays.asList("1", "2", "2", "3"), "3");
    verifyRemoveAll(Arrays.asList("1", "2", "2", "3", "2", "5", "4", "2"), "2");
    verifyRemoveAll(Collections.EMPTY_LIST, "2");
    verifyRemoveAll(Collections.singletonList("1"), "1");
    verifyRemoveAll(Collections.singletonList("1"), "2");
  }

  @Test
  public void sortedMergeShouldReturnNonNullListWhenExactlyOneArgumentIsNull() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    assertThat(SinglyLinkedList.sortedMerge(null, list)).isEqualTo(list);
    assertThat(SinglyLinkedList.sortedMerge(list, null)).isEqualTo(list);
  }

  @Test
  public void sortedMergeShouldReturnNullWhenBothArgumentsAreNull() {
    assertThat(SinglyLinkedList.sortedMerge(null, null)).isNull();
  }

  @Test
  public void sortedMergeShouldMergeTwoRandomList() {
    SinglyLinkedList<Integer> first = new SinglyLinkedList<>();
    first.insert(1);
    first.insert(3);
    first.insert(5);
    first.insert(6);

    SinglyLinkedList<Integer> second = new SinglyLinkedList<>();
    second.insert(2);
    second.insert(4);
    second.insert(7);

    assertThat(SinglyLinkedList.sortedMerge(first, second)
        .asList()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
  }

  private void verifyCountForNInsert(int numberOfInsert) {
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    IntStream.range(0, numberOfInsert)
        .forEach(index -> singlyLinkedList.insert(index + ""));
    assertThat(singlyLinkedList.count()).isEqualTo(numberOfInsert);
  }

  private void verifyNonNullValueInsertAndFind(List<String> valuesToBeInserted) {
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    valuesToBeInserted.stream()
        .forEach(value -> assertThat(singlyLinkedList.insert(value)).isTrue());
    valuesToBeInserted.stream()
        .forEach(value -> assertThat(singlyLinkedList.contains(value)).isTrue());
  }

  private void verifyRetrievalAfterMultiInsert(List<String> elements) {
    SinglyLinkedList<String> singlyLinkedList = createSinglyLinkedList(elements);
    assertThat(singlyLinkedList.asList()).isEqualTo(elements);
  }

  private void verifyListReversalIterative(List<String> elements) {
    SinglyLinkedList<String> singlyLinkedList = createSinglyLinkedList(elements);
    singlyLinkedList.reverseIterative();
    Collections.reverse(elements);
    assertThat(singlyLinkedList.asList()).isEqualTo(elements);
  }

  private void verifyListReversalRecursive(List<String> elements) {
    SinglyLinkedList<String> singlyLinkedList = createSinglyLinkedList(elements);
    singlyLinkedList.reverseRecursive();
    Collections.reverse(elements);
    assertThat(singlyLinkedList.asList()).isEqualTo(elements);
  }

  private SinglyLinkedList<String> createSinglyLinkedList(List<String> elements) {
    SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
    elements.stream()
        .forEach(singlyLinkedList::insert);
    return singlyLinkedList;
  }

  private void verifyReverseInBetween(List<String> elements, int begin, int end) {
    SinglyLinkedList<String> linkedList = createSinglyLinkedList(elements);
    linkedList.reverseBetween(begin, end);

    List<String> reversedList = new ArrayList<>();
    for (int i = (begin - 1); i < end; i++) {
      reversedList.add(elements.get(i));
    }
    Collections.reverse(reversedList);

    List<String> finalList = new ArrayList<>();
    for (int i = 0, j = 0; i < elements.size(); i++) {
      if ((i + 1) >= begin && (i + 1) <= end) {
        finalList.add(reversedList.get(j++));
      } else {
        finalList.add(elements.get(i));
      }
    }
    assertThat(linkedList.asList()).isEqualTo(finalList);
  }

  private void verifyRemoveAll(List<String> elements, String toBeRemoved) {
    SinglyLinkedList<String> linkedList = createSinglyLinkedList(elements);
    linkedList.removeAll(toBeRemoved);
    assertThat(linkedList.contains(toBeRemoved)).isFalse();
  }
}
