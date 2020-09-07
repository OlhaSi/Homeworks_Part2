import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Algebra {

    /**
     * Determines whether the number is prime.
     *
     * @param n u=int number, n > 1
     * @return true if the number is prime
     */
    public boolean isPrime(int n) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(n))
                .noneMatch(value -> n % value == 0);
    }

    public long factorial(int n) {
        return LongStream
                .rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);
    }

    public int getSumOfOddNumbers(int a, int b) {
        return IntStream
                .rangeClosed(a, b)
                .filter(x -> x % 2 != 0)
                .sum();
    }
}
