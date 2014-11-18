/*
 * Copyright 2014 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */
package io.vertx.ext.apex.middleware;

import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.Handler;
import io.vertx.ext.apex.core.RoutingContext;
import io.vertx.ext.apex.middleware.impl.CookieParserImpl;

import java.util.Map;

/**
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@VertxGen
public interface CookieParser extends Handler<RoutingContext> {

  static CookieParser cookierParser() {
    return new CookieParserImpl();
  }

  @Override
  void handle(RoutingContext event);

  static final String COOKIES_ENTRY_NAME = CookieParser.class.getName() + ".cookies";

  static Map<String, ApexCookie> cookies() {
    return RoutingContext.getContext().get(COOKIES_ENTRY_NAME);
  }

  static Map<String, ApexCookie> cookies(RoutingContext context) {
    return context.get(COOKIES_ENTRY_NAME);
  }

}
