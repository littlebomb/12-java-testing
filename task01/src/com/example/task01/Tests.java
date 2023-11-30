package com.example.task01;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tests {
    @Test(expected = Exception.class)
    public void testEmpty(){
        Integer.decode("");
    }

    @Test (expected = Exception.class)
    public void testInvalidSymbols() {
        Integer.decode("4f");
    }

    @Test (expected = Exception.class)
    public void testNonIntegerValue(){
        Integer.decode("0.1");
    }

    @Test
    public void testValueZero(){
        assertEquals(Integer.valueOf(0), Integer.decode("0"));
    }

    @Test
    public void testStartsWithPlus() {
        assertEquals(Integer.valueOf(42), Integer.decode("+42"));
    }

    @Test
    public void testStartsWithMinus() {
        assertEquals(Integer.valueOf(-42), Integer.decode("-42"));
    }

    @Test (expected = Exception.class)
    public void testStartsWithMultiplePluses(){
        Integer.decode("++42");
    }

    @Test (expected = Exception.class)
    public void testStartsWithMultipleMinuses(){
        Integer.decode("--42");
    }

    @Test
    public void testOctNumber(){
        assertEquals(Integer.valueOf(9), Integer.decode("0011"));
    }

    @Test
    public void testDecNumber(){
        assertEquals(Integer.valueOf(27), Integer.decode("0x1B"));
    }

    @Test
    public void testDecNumberStartingWithSharp(){
        assertEquals(Integer.valueOf(27), Integer.decode("#1B"));
    }

    @Test
    public void testMinValue(){
        assert(Integer.MIN_VALUE == Integer.decode(String.valueOf(Integer.MIN_VALUE)));
    }

    @Test
    public void testMaxValue(){
        assert(Integer.MAX_VALUE == Integer.decode(String.valueOf(Integer.MAX_VALUE)));
    }

}
