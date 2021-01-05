import com.example.functionalprogrammingexamples.Person;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionTest {

    @Test
    public void function() {
        Function<Integer, String> function = t -> t + t + " costam.pl";
        System.out.println(function.apply(6));
    }

    @Test
    public void predicate() {
        Predicate<Person> predicate = p -> p.getAge() > 25;

        boolean test1 = predicate.test(new Person("Krzysiek", "Krzysiek",20));
        boolean test2 = predicate.test(new Person("Jozek", "Jozek",29));

        System.out.println(test1);
        System.out.println(test2);
    }
}
