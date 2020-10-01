package com.telran;

public class Casino {

    public int getMinBets(int cash, int minLimitToDouble) {
        int startCash = 1;
        int count = 0;

        while (cash > startCash) {

//            System.out.println("cash = " + cash);
//            System.out.println("count = " + count);
//            System.out.println("minLimitToDouble = " + minLimitToDouble);
//            System.out.println("----------");

            if (minLimitToDouble > 0) {
                if (cash % 2 == 0) {
                    cash = cash / 2;
                    count++;
                    minLimitToDouble--;
                } else {
                    cash = (cash - 1) / 2;
                    count = count + 2;
                    minLimitToDouble--;
                }
            } else {
                count++;
                cash--;
            }
        }
        return count;
    }
}
