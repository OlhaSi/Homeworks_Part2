import java.util.function.Function;

public class MyFunction implements Function<Double, Double> {

    @Override
    public Double apply(Double a) {
        return Math.sqrt(a);
    }

    Function<Double, Double> sqrt = a -> Math.sqrt(a);
    Function<Double, Double> sqrt1 = Math::sqrt;
}
