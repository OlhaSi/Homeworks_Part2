package com.telran;

import java.util.Stack;

public class MaxElementInStack{

    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> trackMax = new Stack<>();

    public void insert(int num) {
        if (mainStack.isEmpty()) {

            mainStack.add(num);
            trackMax.add(num);
        } else {

            int a = trackMax.peek();
            trackMax.add(Math.max(a, num));
            mainStack.add(num);
        }
    }

    public int getMax() {
        return trackMax.peek();
    }

    public int remove() {
        if (!mainStack.isEmpty()) { // pop the top elements
            trackMax.pop();
            return mainStack.pop();
        }
        return 0;
    }



    //    Stack<Integer> stack;
//    int maxElement;
//
//    public MaxElementInStack() {
//        this.stack = stack;
//    }

//    public int getMaxElement(){
//        Stack<Integer> stack;
//
//        while (stack.size() > 0) {
//            int num = stack.pop();
//            if (num > maxElement) {
//                maxElement = num;
//            }
//        }
//
//        return maxElement;
//    }
}
