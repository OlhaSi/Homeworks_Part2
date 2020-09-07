import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {

        TernaryPredicate classicPredicate = new DifferentNumbersPredicate();
        classicPredicate.test(1,2,3);

        TernaryPredicate lambdaPredicate = (a, b, c) -> a != b && b != c && c != a;

        System.out.println(lambdaPredicate.test(1,2,3));
        System.out.println(lambdaPredicate.test(1,3,3));

        Function<Integer,Integer> f = x -> x * 2;
        Function<Integer,Integer> g = x -> x + 3;
        Function<Integer,Integer> fAndGComposition = f.compose(g);
        // the same
        Function<Integer,Integer> fAndGComposition1 = f.andThen(g);
        System.out.println(fAndGComposition.apply(4));
        g.compose(f);


        // homework

        // 1. get combined list from two Predicates list
        List<String> list = Arrays.asList("Groovy", "Jack", "Google", "Microsoft", "Java", "Kotlin");
        List<String> combinedList = list.stream()
                .filter(startsWith("Ja").and(smallerThan(5)))
                .collect(Collectors.toList());

        System.out.println(combinedList);

        // 2. get factorial
        System.out.println(factorial(4));

        // 3. get a sum of odd numbers in the range
        System.out.println(getSumOfOddNumbers(1, 9));

        // 4. check if the number is prime
        System.out.println(isNumberPrime(5));

    }

    // 1.
    public static Predicate<String> startsWith(String begin) {
        return s -> s.startsWith(begin);
    }

    // 1.
    public static Predicate<String> smallerThan(int size) {
        return s -> size >= s.length();
    }

    // 2.

    /**
     *
     * @param n > 0
     * @return multiplication of all the numbers from 1 to n
     */
    public static long factorial(int n) {
        return LongStream
                .rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);
    }

    // 3.
    public static int getSumOfOddNumbers(int a, int b) {
        return IntStream
                .rangeClosed(a, b)
                .filter(x -> x % 2 != 0)
                .sum();
    }

    // 4.
    public static boolean isNumberPrime(int num) {
        return num > 1 && IntStream
                .rangeClosed(2, num / 2)
                .noneMatch(x -> num % x == 0);
    }
}
