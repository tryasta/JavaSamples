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
    double value = 3.0;
    assertThat(new Constant(value).getValue()).isEqualTo(value);
  }

  @Test
  public void adderShouldAddTwoValues() {
    double leftValue = 2.0;
    double rightValue = 3.0;
    Expression addingExpression = new Adder(new Constant(leftValue), new Constant(rightValue));
    assertThat(addingExpression.getValue()).isEqualTo(5.0);
  }

  @Test
  public void subtractorShouldSubtractTwoValues() {
    double leftValue = 5.0;
    double rightValue = 1.0;
    Expression subtractingExpression = new Subtractor(new Constant(leftValue), new Constant(rightValue));
    assertThat(subtractingExpression.getValue()).isEqualTo(leftValue - rightValue);
  }

  @Test
  public void multiplierShouldMultiplyTwoValues() {
    double leftValue = 5.0;
    double rightValue = 3.0;
    Expression multiplyingExpression = new Multiplier(new Constant(leftValue), new Constant(rightValue));
    assertThat(multiplyingExpression.getValue()).isEqualTo(leftValue * rightValue);
  }

  @Test
  public void dividerShouldDivideTwoValues() {
    double leftValue = 20.0;
    double rightValue = 2.0;
    Expression dividingExpression = new Divider(new Constant(leftValue), new Constant(rightValue));
    assertThat(dividingExpression.getValue()).isEqualTo(leftValue / rightValue);
  }

  @Test
  public void shouldCalculateComplexExpression() {
    Expression threePlusFive = new Adder(new Constant(3), new Constant(5));
    Expression threePlusFiveMultiply100 = new Multiplier(threePlusFive, new Constant(100));
    Expression eightyTwoMinus2 = new Subtractor(new Constant(82), new Constant(2));
    Expression threePlusFiveMultiply100DividedByEightyTwoMinus2 =
        new Divider(threePlusFiveMultiply100, eightyTwoMinus2);
    assertThat(threePlusFiveMultiply100DividedByEightyTwoMinus2.getValue()).isEqualTo(10);
  }
}
