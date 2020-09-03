import com.sun.org.apache.xpath.internal.operations.Operation;
import sun.tools.jstat.Operator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        MyFunction function = new MyFunction();
        double res = function.apply(5.5);
        System.out.println(res);

        UniqueStrings uniqueStrings = new UniqueStrings();
        List<String> list = Arrays.asList("sdfs", "sf", "sf", "shjfs");
        System.out.println(uniqueStrings.stringSetFunction.apply(list));

        Closure closure = new Closure(1.5, 2.2, 4.1);
        System.out.println(closure.function.apply(4.2));


        // issue with list of unique elements
        Function<List<Integer>, List<Integer>> uniqListMaker = (List<Integer> list1) ->
                new ArrayList<>(new HashSet<Integer>(list1));
        System.out.println(uniqListMaker.apply(Arrays.asList(2, 2, 3, 4, 5, 5, 6)));


        // example of using a callback
        printResult(num -> num * num, 10);
        printResult(num -> num + 5, 10);

        Function<Integer, Integer> sqr = num -> {
            return num * num;
        };

        printResult(sqr, 3);
    }

    static void printResult(Function<Integer, Integer> function, int num) {
        int res = function.apply(num);
        System.out.println(res);
    }

    static void myPrintResult(MyNewFunction myNewFunction, int num) {
        int res = myNewFunction.compute(num);
        System.out.println(res);
    }
}

interface MyNewFunction {
    int compute(int num);
}
