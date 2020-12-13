import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


public class Main {

    //Повертає input, що містить результат застосування func до кожного елемента
    public static <F, T> Iterable<T> changeList(Iterable<F> input,
                                                Function<? super F, ? extends T> func) {
        List<T> res = new LinkedList<>();
        for (F temp : input)
            res.add(func.apply(temp));

        return res;
    }

    //Повертає input, що містить усі елементи, які задовольняють вхідному предикату condition.
    public static <T> Iterable<T> filterList(Iterable<T> input, Predicate<? super T> condition) {
        List<T> res = new LinkedList<>();
        for (T temp : input) {
            if (condition.test(temp))
                res.add(temp);
        }

        return res;
    }
}



























