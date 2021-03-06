// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.android.core.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests {@link RequestContext}
 */
public class ContextTests {
    @Test
    public void simpleContext() {
        RequestContext context = new RequestContext("key", "value");

        Option<Object> optionValue = context.getData("key");
        assertTrue(optionValue.isInitialized());
        assertEquals("value", optionValue.getValue());
        assertFalse(context.getData("fakeKey").isInitialized());
    }

    @Test
    public void constructorKeyCannotBeNull() {
        assertThrows(NullPointerException.class, () -> new RequestContext(null, null));
    }

    @ParameterizedTest
    @MethodSource("addDataSupplier")
    public void addData(String key, String value, String expectedOriginalValue) {
        RequestContext context = new RequestContext("key", "value").addData(key, value);

        Option<Object> optionValue = context.getData(key);
        assertTrue(optionValue.isInitialized());
        assertEquals(value, optionValue.getValue());

        Option<Object> optionValue1 = context.getData("key");
        assertTrue(optionValue1.isInitialized());
        assertEquals(expectedOriginalValue, optionValue1.getValue());
    }

    private static Stream<Arguments> addDataSupplier() {
        return Stream.of(
            // Adding with same key overwrites value.
            Arguments.of("key", "newValue", "newValue"),
            Arguments.of("key", "", ""),

            // New values.
            Arguments.of("key2", "newValue", "value"),
            Arguments.of("key2", "", "value")
        );
    }

    @Test
    public void addDataKeyCannotBeNull() {
        RequestContext context = new RequestContext("key",  "value");

        assertThrows(IllegalArgumentException.class, () -> context.addData(null, null));
    }

    @Test
    public void getValueKeyCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> RequestContext.NONE.getData(null));
    }
}
