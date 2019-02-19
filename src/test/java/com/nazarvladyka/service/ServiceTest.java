package com.nazarvladyka.service;

import org.junit.Test;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class ServiceTest {

    private Service unit = new Service();
    private LinkedList<Integer> input;
    private int number;

    @Test
    public void when_SearchedSumIsZero_ReturnZero() {
        input = new LinkedList<Integer>() {{
            add(4);
            add(10);
            add(7);
        }};
        number = 0;
        LinkedList<Integer> expected = new LinkedList<Integer>() {{
            add(0);
        }};

        assertEquals(expected, unit.chooseNumbersFromListEqualsToNumber(input, number));
    }

    @Test
    public void when_SearchedSumIsBiggerThanSumOfElements_ReturnZero() {
        input = new LinkedList<Integer>() {{
            add(8);
            add(20);
            add(7);
        }};
        number = 100;
        LinkedList<Integer> expected = new LinkedList<Integer>() {{
            add(0);
        }};

        assertEquals(expected, unit.chooseNumbersFromListEqualsToNumber(input, number));
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
        number = 8;
        LinkedList<Integer> expected = new LinkedList<Integer>() {{
            add(5);
            add(3);
        }};

        assertEquals(expected, unit.chooseNumbersFromListEqualsToNumber(input, number));
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
        number = 17;
        LinkedList<Integer> expected = new LinkedList<Integer>() {{
            add(17);
        }};

        assertEquals(expected, unit.chooseNumbersFromListEqualsToNumber(input, number));
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
        number = 57;
        LinkedList<Integer> expected = new LinkedList<Integer>() {{
            add(0);
        }};

        assertEquals(expected, unit.chooseNumbersFromListEqualsToNumber(input, number));
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
        number = 21;
        LinkedList<Integer> expected = new LinkedList<Integer>() {{
            add(11);
            add(10);
        }};

        assertEquals(expected, unit.chooseNumbersFromListEqualsToNumber(input, number));
    }
}