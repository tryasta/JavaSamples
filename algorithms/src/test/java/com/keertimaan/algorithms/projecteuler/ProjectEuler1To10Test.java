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

package com.keertimaan.algorithms.projecteuler;

import org.junit.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
public class ProjectEuler1To10Test {

  @Test
  public void testMultipleOf3And5LessThan() {
    assertThat(ProjectEuler1To10.multipleOf3And5LessThan(1000)).isEqualTo(233168);
  }

  @Test
  public void testFibonacciEvenSum() {
    assertThat(ProjectEuler1To10.fibonacciEvenSum(-1)).isEqualTo(0);
    assertThat(ProjectEuler1To10.fibonacciEvenSum(0)).isEqualTo(0);
    assertThat(ProjectEuler1To10.fibonacciEvenSum(1)).isEqualTo(0);
    assertThat(ProjectEuler1To10.fibonacciEvenSum(2)).isEqualTo(2);
    assertThat(ProjectEuler1To10.fibonacciEvenSum(3)).isEqualTo(2);
    assertThat(ProjectEuler1To10.fibonacciEvenSum(8)).isEqualTo(10);
    assertThat(ProjectEuler1To10.fibonacciEvenSum(34)).isEqualTo(44);
    assertThat(ProjectEuler1To10.fibonacciEvenSum(4000000)).isEqualTo(4613732);
  }

  @Test
  public void testLargestPrimeFactor() {
    assertThat(ProjectEuler1To10.largestPrimeFactor(BigInteger.valueOf(3))).isEqualTo(BigInteger.valueOf(3));
    assertThat(ProjectEuler1To10.largestPrimeFactor(BigInteger.valueOf(15))).isEqualTo(BigInteger.valueOf(5));
    assertThat(ProjectEuler1To10.largestPrimeFactor(BigInteger.valueOf(18))).isEqualTo(BigInteger.valueOf(3));
    assertThat(ProjectEuler1To10.largestPrimeFactor(BigInteger.valueOf(13195))).isEqualTo(BigInteger.valueOf(29));
    assertThat(ProjectEuler1To10.largestPrimeFactor(new BigInteger("600851475143", 10))).isEqualTo(BigInteger.valueOf(
        6857));
  }
}
