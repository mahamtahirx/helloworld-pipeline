package com.helloworld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {

    @Test
    void greetReturnsExpectedMessageForAName() {
        assertEquals("Hello World,Ehtesham", HelloWorld.greet("Ehtesham"));
    }

    @Test
    void greetHandlesEmptyName() {
        assertEquals("Hello World,", HelloWorld.greet(""));
    }
}
