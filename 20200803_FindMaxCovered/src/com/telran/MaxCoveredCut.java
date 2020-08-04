package com.telran;

import java.util.Arrays;
import java.util.List;

public class MaxCoveredCut {

    public static int maxCovered(List<Double> list, double l) {
        int res = 1;
        double left;
        double right;
        double currentNumber;
        int currentIndex;
        int numberOfOccurrences;

        for (int i = 0; i < list.size(); i++) {
            left = list.get(i);
            right = left + l;
            currentNumber = left;
            currentIndex = i;
            numberOfOccurrences = 0;

            for (int j = currentIndex; j < list.size(); j++) {
                if(currentNumber < right){
                    currentNumber = list.get(currentIndex);
                    numberOfOccurrences++;
                }
                currentIndex++;

                if (numberOfOccurrences > res) {
                    res = numberOfOccurrences;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        List<Double> nums = Arrays.asList(1.1, 2.5, 3.5, 4.2, 8.2, 9.5, 10.4);
        double l = 2.5;
        System.out.println("RES 1 = " + maxCovered(nums, l));

        List<Double> nums1 = Arrays.asList(0.2, 0.25, 0.6, 0.7, 0.8, 0.9);
        double l1 = 0.3; 
        System.out.println("RES 2 = " + maxCovered(nums1, l1));

    }

}
