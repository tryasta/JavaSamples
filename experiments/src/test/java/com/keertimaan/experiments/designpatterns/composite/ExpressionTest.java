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

package com.keertimaan.experiments.designpatterns.composite;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
public class ExpressionTest {

  @Test
  public void constantShouldReturnValueAsIs() {
    final double value = 3.0;
    Expression e =  new Constant(value);
    assertThat(e.getValue()).isEqualTo(value);
  }

  @Test
  public void adderShouldAddTwoValues() {
    double leftValue = 2.0;
    double rightValue = 3.0;

    Expression leftExpression = new Constant(leftValue);
    Expression rightExpression = new Constant(rightValue);
    Expression addingExpression = new Adder(leftExpression, rightExpression);
    assertThat(addingExpression.getValue()).isEqualTo(5.0);
  }
}
