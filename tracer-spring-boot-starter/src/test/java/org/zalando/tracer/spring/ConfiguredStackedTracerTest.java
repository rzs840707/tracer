package org.zalando.tracer.spring;

/*
 * ⁣​
 * Tracer: Servlet
 * ⁣⁣
 * Copyright (C) 2015 Zalando SE
 * ⁣⁣
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ​⁣
 */

import org.junit.Test;
import org.junit.Test.None;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.zalando.tracer.Tracer;

@ActiveProfiles("uuid")
@TestPropertySource(properties = "tracer.stacked: true")
public final class ConfiguredStackedTracerTest extends AbstractTest {

    @Autowired
    private Tracer tracer;

    @Test(expected = None.class)
    public void shouldBeStacked() {
        tracer.start();
        tracer.get("X-Trace-ID");
        tracer.start();
    }

}
