package com.nazarvladyka.service;

import org.junit.Test;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class ServiceTest {

    private Service unit = new Service();
    private ArrayList<Integer> input;
    private int number;

    @Test
    public void CallChooseNumbersFromListEqualsToNumber() {
        input = new ArrayList<Integer>() {{
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
    public void CallChooseNumbersFromListEqualsToNumberWithListWhichAlreadyContainFoundedNumber() {
        input = new ArrayList<Integer>() {{
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
    public void CallChooseNumbersFromListWithListWhichContainNumbersSumOfWhichIsNotEnought() {
        input = new ArrayList<Integer>() {{
            add(1);
            add(8);
            add(17);
            add(1);
            add(3);
        }};
        number = 500;
        LinkedList<Integer> expected = new LinkedList<Integer>() {{
            add(0);
        }};

        assertEquals(expected, unit.chooseNumbersFromListEqualsToNumber(input, number));
    }

    @Test
    public void CallChooseNumbersFromListWithNumbersWhichWillFailInQuickCycle() {
        input = new ArrayList<Integer>() {{
            add(1);
            add(3);
            add(5);
            add(12);
            add(10);
            add(11);
            add(4);
            add(7);
        }};
        number = 21;
        ArrayList<Integer> expected = new ArrayList<Integer>() {{
            add(11);
            add(10);
        }};

        assertEquals(expected, unit.chooseNumbersFromListEqualsToNumber(input, number));
    }
}