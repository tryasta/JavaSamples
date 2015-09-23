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

package com.keertimaan.experiments.thread;

import org.junit.Test;

/**
 * <p>This test demonstrates how <tt>ThreadLocal</tt> instances behave. The target class <tt>ThreadLocalHolder</tt> has
 * a private static member which is a <tt>ThreadLocal</tt>. We then create an instance of this class, and then
 * initialize two threads which accesses the same instance to set the value of that instance (Main thread also
 * participates).</p>
 *
 * <p>The most important point to note that the values set by each thread does not overwrite the others. Instead,
 * each one retains their unique values and properly sets/gets it.</p>
 *
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
public class ThreadLocalTest {

  @Test
  public void shouldTestThreadLocal() throws InterruptedException {
    ThreadLocalHolder holder = new ThreadLocalHolder();
    Thread first = new Thread(() -> holder.hellRun(50), "First Thread");
    Thread second = new Thread(() -> holder.hellRun(100), "Second Thread");

    first.start();
    second.start();

    holder.hellRun(69);
    first.join();
    second.join();

    System.out.println("After execution: " + holder.getValue());
  }
}
