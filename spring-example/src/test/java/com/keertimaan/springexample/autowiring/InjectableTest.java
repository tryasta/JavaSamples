/**
 * Copyright 2015 Sayem Ahmed
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.keertimaan.springexample.autowiring;

import com.keertimaan.springexample.AbstractSpringTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://www.codesod.com">Sayem Ahmed</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class InjectableTest extends AbstractSpringTest {

  @Autowired
  @First
  private Injectable autoWired;

  @Resource
  @Second
  private Injectable resource;

  @Inject
  @First
  private Injectable inject;

  @Test
  public void testAutoWiredInjection() {
    assertThat(autoWired).isNotNull();
    assertThat(resource).isNotNull();
    assertThat(inject).isNotNull();

    autoWired.sayHello();
    resource.sayHello();
    inject.sayHello();
  }
}
