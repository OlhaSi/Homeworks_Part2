import java.util.function.Function;

public class Closure {

    double a;
    double b;
    double c;

    public Closure(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Function<Double, Double> function = new Function<Double, Double>() {
        @Override
        public Double apply(Double x) {
            return Math.pow(a * x, 2) + (b * x) + c;
        }
    };

    Function<Double, Double> function1 = x -> Math.pow(a * x, 2) + (b * x) + c;
}
