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

package com.keertimaan.springexample.xmlconfig.autowiring;

/**
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
public class BeanC {

  /**
   * <p>This constructor exists to prove that, during autowiring by constructor Spring will automatically pick the
   * constructor with most argument whose dependencies it can fully satisfy. So this one will never be called.</p>
   *
   * @param beanA bean of type <tt>BeanA</tt>.
   * @see BeanA
   */
  public BeanC(BeanA beanA) {
    System.out.println("This constuctor will never be called: " + beanA.getClass().getSimpleName());
  }

  /**
   * <p>This constructor proves that, during autowiring by constructor Spring will first try to determine the
   * dependencies by matching the bean types. However, if there are more than one type is found to be eligible, then
   * Spring will use <i>by name</i> matching strategy to restrict the number of candidate beans. This is exactly why
   * bean of type <tt>BeanD</tt> is being injected here, not <tt>BeanB</tt> even though the reference type is of
   * <tt>BeanB</tt>.</p>
   *
   * <p>For testing autowiring by constructor, try changing the name/type of the last argument (beans are already
   * defined in the corresponding xml file.</p>
   *
   * @param beanA bean of type <tt>BeanA</tt>.
   * @param beanD bean of type <tt>BeanD</tt>.
   * @see BeanA
   * @see BeanB
   * @see BeanD
   */
  public BeanC(BeanA beanA, BeanB beanD) {
    System.out.println("This constructor is being called by Spring");
    System.out.println("id of BeanA: " + beanA.getName() + ", and type: " + beanA.getClass().getName());
    System.out.println("id of BeanB: " + beanD.getName() + ", and type: " + beanD.getClass()
        .getName());
  }
}
