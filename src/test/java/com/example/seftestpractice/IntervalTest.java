package com.example.seftestpractice;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class IntervalTest {
    private Interval interval;

    @BeforeEach
    void setUp()
    {
        interval = new Interval(2,6);
    }


    @Test
    @DisplayName("Test create open - open")
    void testOpenOpen()
    {
        interval.setPstart(Paranthesis.OPEN);
        interval.setPend(Paranthesis.OPEN);
        assertEquals(3, interval.create()[0]);
        assertEquals(5, interval.create()[1]);
    }
    @Test
    @DisplayName("Test create open - closed")
    void testOpenClosed()
    {
        interval.setPstart(Paranthesis.OPEN);
        interval.setPend(Paranthesis.CLOSED);
        assertEquals(3, interval.create()[0]);
        assertEquals(6, interval.create()[1]);
    }
    @Test
    @DisplayName("Test create closed - open")
    void testClosedOpen()
    {
        interval.setPstart(Paranthesis.CLOSED);
        interval.setPend(Paranthesis.OPEN);
        assertEquals(2, interval.create()[0]);
        assertEquals(5, interval.create()[1]);
    }
    @Test
    @DisplayName("Test create closed - closed")
    void testClosedClosed()
    {
        interval.setPstart(Paranthesis.CLOSED);
        interval.setPend(Paranthesis.CLOSED);
        assertEquals(2, interval.create()[0]);
        assertEquals(6, interval.create()[1]);
    }
    @Test
    @DisplayName("Test create exception")
    void testException()
    {
        interval.setPstart(Paranthesis.CLOSED);
        interval.setPend(Paranthesis.CLOSED);
        interval.setStart(3);
        interval.setEnd(4);
        assertThrows(InvalidValuesForIntervalException.class, () -> interval.create());

    }
    @Test
    @DisplayName("Test contains when it does not")
    void testContainsNotExists()
    {
        interval.setPstart(Paranthesis.CLOSED);
        interval.setPend(Paranthesis.CLOSED);
        assertEquals(false, interval.Contains(7));
    }
    @Test
    @DisplayName("Test contains when it does")
    void testContainsExists()
    {
        interval.setPstart(Paranthesis.CLOSED);
        interval.setPend(Paranthesis.CLOSED);
        assertEquals(true, interval.Contains(4));
    }
    @Test
    @DisplayName("Test limit edgecase start")
    void testContainsStartEdge()
    {
        interval.setPstart(Paranthesis.CLOSED);
        interval.setPend(Paranthesis.CLOSED);
        assertEquals(true, interval.Contains(2));
    }
    @Test
    @DisplayName("Test limit edgecase end")
    void testContainsEndEdge()
    {
        interval.setPstart(Paranthesis.CLOSED);
        interval.setPend(Paranthesis.CLOSED);
        assertEquals(true, interval.Contains(6));
    }
}
