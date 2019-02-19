package com.nazarvladyka.service;

import java.util.Collections;
import java.util.LinkedList;

public class Service {
    public LinkedList<Integer> chooseNumbersFromListEqualsToNumber(LinkedList<Integer> inputList, int searchedSum) {
        LinkedList<Integer> resultList = new LinkedList<>();

        //in case when sum of element are not enough
        int sumOfInputList = 0;
        for (Integer x : inputList) { sumOfInputList += x; }
        if (sumOfInputList < searchedSum || searchedSum == 0) {
            resultList.add(0);
            return resultList;
        }

        LinkedList<Integer> resultWithQuickSearch = quickSearch(inputList, searchedSum);
        LinkedList<Integer> resultEveryoneWithEveryone = everyoneWithEveryone(inputList, searchedSum);

        if (resultWithQuickSearch.indexOf(0) == 0) {
            resultList = resultEveryoneWithEveryone;
        } else {
            resultList = resultWithQuickSearch;
        }

        return resultList;
    }

    private LinkedList<Integer> quickSearch(LinkedList<Integer> inputList, int searchedSum) {
        LinkedList<Integer> outputList = new LinkedList<>();

        int difference = searchedSum;
        int elementIndexClosestToDifference;
        int minDifference = searchedSum;
        int sum = 0;
        boolean isThereAreNotSmallestNumberThatDifference = false;

        while(sum != searchedSum && !isThereAreNotSmallestNumberThatDifference) {
            elementIndexClosestToDifference = 0;

            for (Integer x : inputList) {
                if (x > difference) {
                    isThereAreNotSmallestNumberThatDifference = true;
                } else {
                    isThereAreNotSmallestNumberThatDifference = false;
                    break;
                }
            }

            if(!isThereAreNotSmallestNumberThatDifference) {
                for (Integer elem : inputList) {
                    if (minDifference == 0) { break; }
                    if ((difference - elem) < 0) { continue; }
                    if ((difference - elem) < minDifference) {
                        elementIndexClosestToDifference = inputList.indexOf(elem);
                        minDifference = difference - inputList.get(elementIndexClosestToDifference);
                    }
                }

                outputList.add(inputList.get(elementIndexClosestToDifference));
                inputList.remove(elementIndexClosestToDifference);
                //add all elements in list to sum
                sum += outputList.getLast();
                difference = searchedSum - sum;
            } else {
                outputList.clear();
                outputList.add(0);
            }
        }
        return outputList;
    }

    private LinkedList<Integer> everyoneWithEveryone(LinkedList<Integer> inputList, int searchedSum) {
        LinkedList<Integer> outputList = new LinkedList<>();

        //if there are numbers bigger that our searchedSum
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i) > searchedSum) {
                inputList.remove(i);
                i--;
            }
        }

        int sum = 0;
        while (sum != searchedSum) {
            Collections.sort(inputList);

            for(int i = 0; i < inputList.size() - 1; i++) {
                sum = inputList.getLast() + inputList.get(i);
                if (sum == searchedSum) {
                    outputList.add(inputList.getLast());
                    outputList.add(inputList.get(i));
                    break;
                }
            }
            inputList.removeLast();

            if(inputList.isEmpty() && outputList.isEmpty()) {
                outputList.add(0);
                break;
            }
        }
        return outputList;
    }
}