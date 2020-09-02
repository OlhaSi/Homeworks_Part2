import java.util.Arrays;
import java.util.List;

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
    }
}
