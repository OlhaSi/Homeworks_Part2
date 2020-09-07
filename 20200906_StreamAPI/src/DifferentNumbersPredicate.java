public class DifferentNumbersPredicate implements TernaryPredicate{

    @Override
    public boolean test(int a, int b, int c) {
        return a != b && b != c && c != a;
    }
}
