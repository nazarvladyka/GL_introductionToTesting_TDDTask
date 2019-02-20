package com.nazarvladyka.service;

import org.junit.Test;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class ServiceTest {

    private Service unit = new Service();
    private LinkedList<Integer> input;

    @Test
    public void when_SearchedSumIsBiggerThanSumOfElements_ReturnZero() {
        input = new LinkedList<Integer>() {{
            add(8);
            add(20);
            add(7);
        }};
        LinkedList<Integer> expected = new LinkedList<Integer>() {{
            add(0);
        }};

        assertEquals(expected, unit.chooseNumbersFromListEqualsToNumber(input, 100));
    }

    @Test
    public void when_EnoughDataForQuickSearch() {
        input = new LinkedList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
        LinkedList<Integer> expected = new LinkedList<Integer>() {{
            add(5);
            add(3);
        }};

        assertEquals(expected, unit.chooseNumbersFromListEqualsToNumber(input, 8));
    }

    @Test
    public void when_SearchedNumberAlreadyInTheList_ReturnThisNumber() {
        input = new LinkedList<Integer>() {{
            add(12);
            add(5);
            add(17);
            add(1);
            add(3);
        }};
        LinkedList<Integer> expected = new LinkedList<Integer>() {{
            add(17);
        }};

        assertEquals(expected, unit.chooseNumbersFromListEqualsToNumber(input, 17));
    }

    @Test
    public void when_ItIsImpossibleToReturnListWithCurrentData_ReturnZero() {
        input = new LinkedList<Integer>() {{
            add(8);
            add(7);
            add(15);
            add(78);
            add(4);
            add(8);
            add(7);
            add(15);
            add(18);
            add(2);
        }};
        LinkedList<Integer> expected = new LinkedList<Integer>() {{
            add(0);
        }};

        assertEquals(expected, unit.chooseNumbersFromListEqualsToNumber(input, 57));
    }

    @Test
    public void when_MethodQuickSearchReturnWrongData_And_MethodEveryoneWithEveryOneFixIt() {
        input = new LinkedList<Integer>() {{
            add(23);
            add(12);
            add(5);
            add(11);
            add(4);
            add(10);
            add(7);
        }};
        LinkedList<Integer> expected = new LinkedList<Integer>() {{
            add(11);
            add(10);
        }};

        assertEquals(expected, unit.chooseNumbersFromListEqualsToNumber(input, 21));
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_ListIsEmpty_ThrowIllegalArgumentException() {
        input = new LinkedList<>();
        unit.chooseNumbersFromListEqualsToNumber(input, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_SearchedSumIsZero_ThrowIllegalArgumentException() {
        input = new LinkedList<Integer>() {{
            add(1);
            add(2);
        }};
        unit.chooseNumbersFromListEqualsToNumber(input, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_SearchedSumIsLessThanZero_ThrowIllegalArgumentException() {
        input = new LinkedList<Integer>() {{
            add(1);
            add(2);
        }};
        unit.chooseNumbersFromListEqualsToNumber(input, -1);
    }
}