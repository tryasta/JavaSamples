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
 * Singly linked list implementation. Null value insertion is not allowed. The insert, count, and empty check take
 * O(1) time. All other operations take O(n) time.
 *
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
public class SinglyLinkedList<T> {
  private Node<T> head;
  private Node<T> tail;
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
   * Revision 3.
   *
   * @param element the element to be inserted.
   * @return true if the element has been successfully inserted, false otherwise (in case of <code>null</code> value.
   */
  public boolean insert(T element) {
    if (element == null) {
      return false;
    }

    if (head == null) {
      head = new Node<>(element);
      tail = head;
    } else {
      tail.next = new Node<>(element);
      tail = tail.next;
    }

    count++;
    return true;
  }

  /**
   * Returns the current values stored in this list. The values are returned in their traversing order.
   *
   * Revision 2.
   *
   * @return a list containing the elements of this list.
   */
  public List<T> asList() {
    List<T> elements = new ArrayList<>(count);
    Node<T> current = head;
    while (current != null) {
      elements.add(current.value);
      current = current.next;
    }
    return elements;
  }

  /**
   * Checks whether or not the given element exists in this list.
   *
   * @param element the element to look for.
   * @return true if the element exists in the list, false otherwise.
   */
  public boolean contains(T element) {
    if (head == null || element == null) {
      return false;
    }

    Node<T> current = head;
    while (current != null) {
      if (element.equals(current.value)) {
        return true;
      }
      current = current.next;
    }

    return false;
  }

  /**
   * Remove the given non-null element from the list. If the element is not in the list, or null is given as the
   * argument, then nothing is removed.
   *
   * Note to self: abar.
   *
   * @param element the element to be removed
   * @return true if the element has been removed successfully, false otherwise.
   */
  public boolean remove(T element) {
    if (head == null) {
      return false;
    } else if (head.value.equals(element)) {
      head = head.next;
      return true;
    }

    Node<T> current = head;
    while (current.next != null && !current.next.value.equals(element)) {
      current = current.next;
    }

    if (current.next != null) {
      current.next = current.next.next;
      return true;
    }

    return false;
  }

  /**
   * Reverses the order of the elements in this list. Uses iterative approach.
   */
  public void reverseIterative() {
    Node<T> current = head;
    Node<T> next;
    Node<T> previous = null;

    while (current != null) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    head = previous;
  }

  /**
   * Reverses the order of the elements in this list. Uses recursive approach.
   *
   * Note to self - abar.
   */
  public void reverseRecursive() {
    if (head == null) {
      return;
    }

    head = reverseRecursive(head);
  }

  private Node<T> reverseRecursive(Node<T> current) {
    if (current.next == null) {
      return current;
    }

    Node<T> runningHead = reverseRecursive(current.next);
    current.next.next = current;
    current.next = null;
    return runningHead;
  }

  /**
   * Reverses a linked list from position begin to end. Does it in-place and in one-pass.
   * For example, given 1->2->3->4->5->NULL, begin = 2 and end = 4, return 1->4->3->2->5->NULL.
   *
   * Note: given begin, end satisfy the following condition: 1 ≤ begin ≤ end ≤ length of list.
   *
   * Revision 1.
   *
   * @param begin the position from where to start the list reverse process.
   * @param end the position where to stop the reversing process.
   */
  public void reverseBetween(int begin, int end) {
    if (begin == end) {
      return;
    }

    Node<T> current = head;
    Node<T> start = head;
    Node<T> next = head;
    Node<T> previous = null;

    for (int i = 1; i <= end; i++) {
      if (i < begin) {
        if ((i + 1) == begin) {
          start = current;
        }
        current = current.next;
      } else {
        next = current.next;
        current.next = previous;
        previous = current;
        current = next;
      }
    }

    if (begin == 1) {
      start.next = next;
      start = previous;
      head = start;
    } else {
      start.next.next = next;
      start.next = previous;
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
