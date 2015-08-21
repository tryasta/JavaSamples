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
   * Inserts the given value at the end of the list.
   *
   * @param value the value to be inserted.
   */
  public void insert(T value) {
    if (head == null) {
      head = new Node<>(value);
    } else {
      Node<T> lastNode = getLastNode();
      lastNode.next = new Node<>(value);
    }

    count++;
  }

  public List<T> asList() {
    Node<T> traversingHead = head;
    List<T> elementList = new ArrayList<>();
    while (traversingHead != null) {
      elementList.add(traversingHead.value);
      traversingHead = traversingHead.next;
    }

    return elementList;
  }

  private Node<T> getLastNode() {
    Node<T> traversingHead = head;
    while (traversingHead.next != null) {
      traversingHead = traversingHead.next;
    }

    return traversingHead;
  }

  private static class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
      this.value = value;
    }
  }
}
