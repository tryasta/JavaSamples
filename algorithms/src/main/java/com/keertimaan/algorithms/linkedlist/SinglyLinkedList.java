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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Singly linked list implementation.
 *
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
public class SinglyLinkedList<T> {
  private Node<T> head;
  private int count;

  /**
   * Returns the total number of elements currently stored in the list.
   *
   * @return total number of elemnts currently stored in the list
   */
  public int count() {
    return count;
  }

  /**
   * Checks whether or not the list is empty.
   *
   * @return true if the list is empty, false otherwise.
   */
  public boolean isEmpty() {
    return count == 0;
  }

  /**
   * Inserts the given non-null element at the end of the list.
   *
   * @param element the element to be inserted.
   * @return true if the element has been successfully inserted, false otherwise.
   */
  public boolean insert(T element) {
    return Optional.ofNullable(element)
        .map(this::insertElement)
        .isPresent();
  }

  /**
   * Returns the current values stored in this list. The values are returned in their traversing order.
   *
   * @return a list containing the elements of this list.
   */
  public List<T> asList() {
    Node<T> traversingHead = head;
    List<T> elementList = new ArrayList<>();
    while (traversingHead != null) {
      elementList.add(traversingHead.value);
      traversingHead = traversingHead.next;
    }

    return elementList;
  }

  /**
   * Checks whether or not the given element exists in this list.
   *
   * @param element the element to look for.
   * @return true if the element exists in the list, false otherwise.
   */
  public boolean contains(T element) {
    Node<T> traversingHead = head;
    while (traversingHead != null && !traversingHead.value.equals(element)) {
      traversingHead = traversingHead.next;
    }
    return Optional.ofNullable(traversingHead)
        .isPresent();
  }

  /**
   * Remove the given non-null element from the list. If the element is not in the list, or null is given as the
   * argument, then nothing is removed.
   *
   * @param element the element to be removed
   * @return true if the element has been removed successfully, false otherwise.
   */
  public boolean remove(T element) {
    Optional<T> elementToBeRemoved = Optional.of(element);
    if (!elementToBeRemoved.isPresent()) {
      return false;
    } else if (hasBeenRemovedFromHead(element)) {
      return true;
    }

    return removeElement(element);
  }

  private T insertElement(T element) {
    if (isEmpty()) {
      head = new Node<>(element);
    } else {
      Node<T> lastNode = getLastNode();
      lastNode.next = new Node<>(element);
    }
    count++;
    return element;
  }

  private Node<T> getLastNode() {
    Node<T> traversingHead = head;
    while (traversingHead.next != null) {
      traversingHead = traversingHead.next;
    }

    return traversingHead;
  }

  private boolean hasBeenRemovedFromHead(T element) {
    if (head != null && element.equals(head.value)) {
      head = head.next;
      return true;
    }

    return false;
  }

  private boolean removeElement(T element) {
    Node<T> traversingHead = head;
    while (traversingHead != null && traversingHead.next != null && !element.equals(traversingHead.next.value)) {
      traversingHead = traversingHead.next;
    }

    if (traversingHead == null || traversingHead.next == null) {
      return false;
    } else {
      traversingHead.next = traversingHead.next.next;
      return true;
    }
  }

  private static class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
      this.value = value;
    }
  }
}
