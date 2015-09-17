/**
 * Copyright (C) 2015 Rakuten, Inc.
 * All Rights Reserved. No use, copying or distribution of this work may be made
 * except in accordance with a valid license agreement from Rakuten. This notice
 * must be included on all copies, modifications and derivatives of this work.
 */

package com.keertimaan.springexample.javaconfig.autowiring;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author <a href="mailto:sayem.ahmed@rakuten.com">Sayem Ahmed</a>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Second {
}
