import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class UniqueStrings {

    Function<List<String>, Set<String>> stringSetFunction = new Function<List<String>, Set<String>>() {

        @Override
        public Set<String> apply(List<String> list) {
            return new HashSet<>(list);
        }
    };

    Function<List<String>, Set<String>> stringSetFunction1 = list -> {
        return new HashSet<String>(list);
    };

    Function<List<String>, Set<String>> stringSetFunction2 = list -> new HashSet<String>(list);

    Function<List<String>, Set<String>> stringSetFunction3 = HashSet::new;
}
