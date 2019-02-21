package com.nazarvladyka.service;

import java.util.Collections;
import java.util.LinkedList;

public class Service {
    public LinkedList<Integer> chooseNumbersFromListEqualsToNumber(LinkedList<Integer> inputList, int searchedSum)
            throws IllegalArgumentException {
        LinkedList<Integer> resultList = new LinkedList<>();

        if(inputList.isEmpty()) {
            throw new IllegalArgumentException("inputList is empty");
        } else if(searchedSum == 0) {
            throw new IllegalArgumentException("searchedSum is zero");
        } else if(searchedSum < 0) {
            throw new IllegalArgumentException("searchedSum is less than zero");
        }

        //in case when sum of element are not enough
        int sumOfInputList = 0;
        for (Integer x : inputList) { sumOfInputList += x; }
        if (sumOfInputList < searchedSum) {
            resultList.add(0);
            return resultList;
        }

        LinkedList<Integer> resultWithQuickSearch = quickSearch(inputList, searchedSum);

        if (resultWithQuickSearch.indexOf(0) == 0) {
            resultList = everyoneWithEveryoneSearch(inputList, searchedSum);
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
        boolean isThereAreSmallestNumberThatDifference = true;

        while(sum != searchedSum && isThereAreSmallestNumberThatDifference) {
            elementIndexClosestToDifference = 0;

            for (Integer x : inputList) {
                if (x > difference) {
                    isThereAreSmallestNumberThatDifference = false;
                } else {
                    isThereAreSmallestNumberThatDifference = true;
                    break;
                }
            }

            if(isThereAreSmallestNumberThatDifference) {
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

    private LinkedList<Integer> everyoneWithEveryoneSearch(LinkedList<Integer> inputList, int searchedSum) {
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