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

/**
 * <p>A simple class which is used to create tests verifying the <tt>ThreadLocal</tt> behavior. For more details,
 * please visit the corresponding test class.</p>
 *
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
public class ThreadLocalHolder {
  private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
    @Override
    protected Integer initialValue() {
      return 10;
    }
  };

  public void hellRun(int value) {
    System.out.println("Current value: " + threadLocal.get());
    System.out.println("Trying to change to: " + value + " by thread " + Thread.currentThread()
        .getName());
    threadLocal.set(value);
    System.out.println("Changed the value to " + threadLocal.get() + " by thread " + Thread.currentThread()
        .getName());
  }

  public int getValue() {
    return threadLocal.get();
  }
}
