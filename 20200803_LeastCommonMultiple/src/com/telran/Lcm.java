package com.telran;

public class Lcm {

    public int computeGreatestCommonDivisor(int a, int b){
        if (b == 0){
            return a;
        }
        int d = a % b;
        return computeGreatestCommonDivisor(b, d);
    }

    public int computeLeastCommonMultiple(int a, int b){
        return a * b / computeGreatestCommonDivisor(a, b);
    }


//    public static void main(String[] args) {
//        System.out.println(computeLeastCommonMultiple(100,5));
//    }
}
