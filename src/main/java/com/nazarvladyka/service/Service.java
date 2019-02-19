package com.nazarvladyka.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Service {
    public LinkedList<Integer> chooseNumbersFromListEqualsToNumber(ArrayList<Integer> inputList, int number) {
        LinkedList<Integer> resultList = new LinkedList();

        //in case when sum of element are not enough
        int sumOfInputList = 0;
        for (Integer x : inputList) { sumOfInputList += x; }
        if (sumOfInputList < number || number == 0) {
            resultList.add(0);
            return resultList;
        }

        //method wish quick cycle
        LinkedList<Integer> resultListWithQuickSearch = new LinkedList<>();
        LinkedList<Integer> inputListForQuickSearch = new LinkedList<>(inputList);

        int indexOfElementWithMinDifference;
        int minDifference = number;
        int difference = number;
        int sum = 0;
        boolean isThereAreNotSmallestNumberThatDifference = false;

        while(sum != number && !isThereAreNotSmallestNumberThatDifference) {
            indexOfElementWithMinDifference = 0;

            for (Integer x : inputListForQuickSearch) {
                if (x > difference) {
                    isThereAreNotSmallestNumberThatDifference = true;
                } else {
                    isThereAreNotSmallestNumberThatDifference = false;
                    break;
                }
            }

            if(!isThereAreNotSmallestNumberThatDifference) {
                for (Integer x : inputListForQuickSearch) {
                    minDifference = difference - inputListForQuickSearch.get(indexOfElementWithMinDifference);
                    if ((difference - x) < 0) {
                        continue;
                    }
                    if (minDifference == 0) {
                        break;
                    } else if ((difference - x) < minDifference) {
                        indexOfElementWithMinDifference = inputListForQuickSearch.indexOf(x);
                    }
                }

                resultListWithQuickSearch.add(inputListForQuickSearch.get(indexOfElementWithMinDifference));
                inputListForQuickSearch.remove(indexOfElementWithMinDifference);
                //add all elements in list to sum
                sum += resultListWithQuickSearch.getLast();
                difference = number - sum;
            } else {
                resultListWithQuickSearch.removeAll(resultListWithQuickSearch);
                resultListWithQuickSearch.add(0);
            }
        }
// in case when first method didn't find needed list
        if (resultListWithQuickSearch.size() == 1 && resultListWithQuickSearch.contains(0)) {
            LinkedList<Integer> resultListWithEveryoneWithEveryone = new LinkedList<>();
            LinkedList<Integer> inputListForEveryoneWithEveryone = new LinkedList<>(inputList);

            sum = 0;
            difference = number;
            //if there are numbers bigger that our number
            for (int i = 0; i < inputListForEveryoneWithEveryone.size(); i++) {
                if (inputListForEveryoneWithEveryone.get(i) > number) {
                    inputListForEveryoneWithEveryone.remove(i);
                    i--;
                }
            }

            while (sum != number) {
                Collections.sort(inputListForEveryoneWithEveryone);

                for(int i = 0; i < inputListForEveryoneWithEveryone.size() - 1; i++) {
                    sum = inputListForEveryoneWithEveryone.getLast() + inputListForEveryoneWithEveryone.get(i);
                    if (sum == number) {
                        resultListWithEveryoneWithEveryone.add(inputListForEveryoneWithEveryone.getLast());
                        resultListWithEveryoneWithEveryone.add(inputListForEveryoneWithEveryone.get(i));
                        break;
                    }
                }
                inputListForEveryoneWithEveryone.removeLast();

                if(inputListForEveryoneWithEveryone.isEmpty() && resultListWithEveryoneWithEveryone.isEmpty()) {
                    resultListWithEveryoneWithEveryone.add(0);
                    break;
                }

            }
//            if (resultListWithEveryoneWithEveryone.size() == 0) {
//                resultList.add(0);
//                return resultList;
//            }
            resultList = resultListWithEveryoneWithEveryone;
        } else {
            resultList = resultListWithQuickSearch;
        }

        return resultList;
    }
}