package com.disk.opus.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Tests
{
    @Test
    public void testAdd()
    {
        final var expected = 42;
        final var a = 19;
        final var b = 23;
        assertEquals(expected, Integer.sum(a, b));
    }
}
