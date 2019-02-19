package com.nazarvladyka.controller;

import com.nazarvladyka.service.Service;
import java.util.LinkedList;

public class Controller {
    public Controller() {
        callChooseNumbersFromListEqualsToNumber();
    }

    private void callChooseNumbersFromListEqualsToNumber() {
        LinkedList<Integer> inputList = new LinkedList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
        int number = 0;
        Service service = new Service();

        System.out.println("Input list: " + inputList);
        System.out.println("Number: " + number);
        System.out.println("--------------------------------------------");
        System.out.println("Output list: " + service.chooseNumbersFromListEqualsToNumber(inputList, number));
    }
}