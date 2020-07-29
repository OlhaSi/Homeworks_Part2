package telran.data;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(reverseWord("string"));

        System.out.println(changeCase("Hello"));

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 1, 2, 3, 4));
        System.out.println(getRepeated(list));

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 8, 10));
        System.out.println(isMultiplied(list1, 70));

        System.out.println(findGreatestCommonDivider(6, 9));

        System.out.println(findSquare(10));

    }

    public static String reverseWord(String word) {
        return new StringBuilder(word)
                .reverse()
                .toString();
    }

    public static String changeCase(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                sb.append(Character.toUpperCase(ch));
            }
            if (Character.isUpperCase(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.toString();
    }

    public static List<Integer> getRepeated(List<Integer> list) {
        Set<Integer> duplicates = new HashSet<>();
        Set<Integer> arr = new HashSet<>();
        for (Integer i : list) {
            if (!arr.add(i)) {
                duplicates.add(i);
            }
        }
        return new ArrayList<>(duplicates);
    }

    public static boolean isMultiplied(List<Integer> list, int n) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (n == list.get(i) * list.get(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int findGreatestCommonDivider(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a + b;
    }

    public static int findSquare(int a) {
        if (a > 0) {
            return findSquare(a - 1) + a + a - 1;
        } else
            return 0;
    }
}


