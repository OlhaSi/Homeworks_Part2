package com.telran;

import java.util.LinkedList;
import java.util.List;

public class IsMultiplied {

    public boolean isMultiplied(List<Integer> list, int n){
        LinkedList<Integer> linkedList = new LinkedList<>(list);

        while (linkedList.size() > 1){
            int a = linkedList.getFirst();
            int b = linkedList.getLast();

            if (a * b < n)
                linkedList.removeFirst();
            else if (a * b > n)
                linkedList.removeLast();
            else
                return true;
        }
        return false;
    }
}
