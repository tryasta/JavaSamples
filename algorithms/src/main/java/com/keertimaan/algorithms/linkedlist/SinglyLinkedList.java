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
 * <p>Singly linked list implementation. Null value insertion is not allowed. The insert, count, and empty check take
 * O(1) time. All other operations take O(n) time.</p>
 *
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
public class SinglyLinkedList<T> {
  private Node<T> head;
  private Node<T> tail;
  private int count;

  /**
   * <p>Returns the total number of elements currently stored in the list.</p>
   *
   * @return total number of elemnts currently stored in the list
   */
  public int count() {
    return count;
  }

  /**
   * <p>Checks whether or not the list is empty.</p>
   *
   * @return true if the list is empty, false otherwise.
   */
  public boolean isEmpty() {
    return count == 0;
  }

  /**
   * <p>Returns the current values stored in this list. The values are returned in their traversing order.</p>
   *
   * <p>Revision 3.</p>
   *
   * @return a list containing the elements of this list.
   */
  public List<T> asList() {
    Node<T> current = head;
    List<T> elements = new ArrayList<>(count);
    while (current != null) {
      elements.add(current.value);
      current = current.next;
    }

    return elements;
  }

  /**
   * <p>Checks whether or not the given element exists in this list.</p>
   *
   * <p>Revision 2.</p>
   *
   * @param element the element to look for.
   * @return true if the element exists in the list, false otherwise.
   */
  public boolean contains(T element) {
    Node<T> current = head;
    while (current != null) {
      if (current.value.equals(element)) {
        return true;
      }

      current = current.next;
    }

    return false;
  }

  /**
   * <p>Inserts the given non-null element at the end of the list.</p>
   *
   * <p>Revision 5.</p>
   *
   * @param element the element to be inserted.
   * @return true if the element has been successfully inserted, false otherwise (in case of <code>null</code> value.
   */
  public boolean insert(T element) {
    if (!Optional.ofNullable(element)
        .isPresent()) {
      return false;
    }

    if (Optional.ofNullable(head)
        .isPresent()) {
      tail.next = new Node<>(element);
      tail = tail.next;
    } else {
      head = new Node<>(element);
      tail = head;
    }

    // 1st
    count++;
    return true;
  }

  /**
   * <p>Remove the given non-null element from the list. If the element is not in the list, or null is given as the
   * argument, then nothing is removed.</p>
   *
   * <p>Revision 4.</p>
   *
   * @param element the element to be removed
   * @return true if the element has been removed successfully, false otherwise.
   */
  public boolean remove(T element) {
    // 1st
    if (head == null) {
      return false;
    }

    // 2nd
    if (head.value.equals(element)) {

      // 3rd
      if (head == tail) {
        tail = null;
      }

      head = head.next;
      return true;
    }

    Node<T> current = head;
    while (current.next != null && !current.next.value.equals(element)) {
      current = current.next;
    }

    // 4th
    if (current.next != null) {

      // 5th
      if (current.next == tail) {
        tail = current;
      }

      current.next = current.next.next;
      return true;
    }

    return false;
  }

  /**
   * <p>Reverses the order of the elements in this list. Uses iterative approach.</p>
   *
   * <p>Revision 3.</p>
   */
  public void reverseIterative() {
    if (head == tail) {
      return;
    }

    Node<T> previous = tail.next;
    Node<T> current = head;
    Node<T> next;

    while (current != null) {

      /**
       * a. Save the reference to the next element (so that we can move current)
       */
      // 1st
      next = current.next;

      /**
       * b. Modify current.next pointer to point to the previous element
       */
      // 2nd
      current.next = previous;

      /**
       * c. Make current element the previous element
       */
      // 3rd
      previous = current;

      /**
       * d. Move the current element to next element;
       */
      // 4th
      current = next;
    }

    // 5th
    head = previous;
  }

  /**
   * <p>Reverses the order of the elements in this list. Uses recursive approach.</p>
   *
   * <p>Revision 3.</p>
   */
  public void reverseRecursive() {
    if (head == null) {
      return;
    }

    reverseRecursive(head);
  }

  private void reverseRecursive(Node<T> current) {
    if (current.next == null) {
      head = current;
      return;
    }

    // 1st
    reverseRecursive(current.next);

    // 2nd
    current.next.next = current;

    // 3rd
    current.next = null;
  }

  /**
   * <p>Reverses a linked list from position begin to end. Does it in-place and in one-pass.
   * For example, given 1->2->3->4->5->NULL, begin = 2 and end = 4, return 1->4->3->2->5->NULL.</p>
   *
   * <p>Note: given begin, end satisfy the following condition: 1 ≤ begin ≤ end ≤ length of list.</p>
   *
   * <p>Revision 2.</p>
   *
   * @param begin the position from where to start the list reverse process.
   * @param end   the position where to stop the reversing process.
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

      // 1st
      if (i < begin) {
        if ((i + 1) == begin) {
          start = current;
        }

        // 2nd
        current = current.next;
      }

      // 3rd
      else {
        next = current.next;
        current.next = previous;
        previous = current;
        current = next;
      }
    }

    if (begin == 1) {

      // 4th
      start.next = next;
      head = previous;
    } else {
      start.next.next = next;
      start.next = previous;
    }
  }

  /**
   * <p>Removes all occurrences of the given element from the list.</p>
   *
   * <p>Revision 1.</p>
   *
   * @param element the element to be removed.
   */
  public void removeAll(T element) {
    while (head != null && head.value.equals(element)) {
      head = head.next;
    }

    Node<T> current = head;
    Node<T> previous = head;
    while (current != null) {
      if (current.value.equals(element)) {
        while (current != null && current.value.equals(element)) {
          current = current.next;
        }
        previous.next = current;
      }

      if (current != null) {
        previous = current;
        current = current.next;
      }
    }
  }

  /**
   * <p>Merges two sorted lists (in ascending order), and returns a single list containing all the elements in
   * ascending
   * order.</p>
   *
   * <p>If both arguments are null, then this method also returns null.</p>
   *
   * @param first  a list whose elements are sorted in ascending order.
   * @param second a list whose elements are sorted in ascending order.
   * @param <T>    a type which implements the <tt>Comparable&lt;T&gt;</tt> interface.
   * @return a list containing all elements from both list, sorted in ascending order.
   * @see Comparable
   */
  public static <T extends Comparable<T>> SinglyLinkedList<T> sortedMerge(SinglyLinkedList<T> first,
      SinglyLinkedList<T> second) {

    if (first == null) {
      return second;
    } else if (second == null) {
      return first;
    }

    Node<T> thisCurrent = first.head;
    Node<T> thatCurrent = second.head;
    SinglyLinkedList<T> mergedList = new SinglyLinkedList<>();
    if (thisCurrent.value.compareTo(thatCurrent.value) <= 0) {
      mergedList.insert(thisCurrent.value);
      thisCurrent = thisCurrent.next;
    } else {
      mergedList.insert(thatCurrent.value);
      thatCurrent = thatCurrent.next;
    }

    Node<T> current = mergedList.head;
    while (thisCurrent != null && thatCurrent != null) {
      if (thisCurrent.value.compareTo(thatCurrent.value) <= 0) {
        current.next = new Node<>(thisCurrent.value);
        thisCurrent = thisCurrent.next;
      } else {
        current.next = new Node<>(thatCurrent.value);
        thatCurrent = thatCurrent.next;
      }

      current = current.next;
    }

    while (thisCurrent != null) {
      current.next = new Node<>(thisCurrent.value);
      current = current.next;
      thisCurrent = thisCurrent.next;
    }

    while (thatCurrent != null) {
      current.next = new Node<>(thatCurrent.value);
      current = current.next;
      thatCurrent = thatCurrent.next;
    }

    return mergedList;
  }

  @Override
  public String toString() {
    return asList().toString();
  }

  private static class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
      this.value = value;
    }
  }
}
