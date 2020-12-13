import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;
import static org.junit.Assert.*;


public class TesT {

    final private Map<Object, List<?>> testvar;

    public TesT() {
        testvar = new HashMap<>();
        testvar.put(String.class, Arrays.asList("qwe", "rty", "uio", "asd", "fgh"));
        testvar.put(Float.class, Arrays.asList(1f, 1.5f, 2f, 2.5f, 3f, 3.1f, 4f, 4.2f, 4.5f));
        testvar.put(Integer.class, Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @org.junit.Test
    public void floatFilter() {
        Predicate<Float> biggerFloat = f -> f > 3.2 ;
        List<Float> ext = Arrays.asList( 4f, 4.2f, 4.5f);
        List<Float> act = (List<Float>)
                Main.filterList((List<Float>) testvar.get(Float.class), biggerFloat);

        difference(ext, act);
    }

    @org.junit.Test
    public void stringFilter() {
        Predicate<String> firstQ = str -> str.charAt(0) == 'q';
        List<String> exp = Arrays.asList("qwe");
        List<String> act = (List<String>)
                Main.filterList((List<String>) testvar.get(String.class), firstQ);

        difference(exp, act);
    }

    @org.junit.Test
    public void intFilter() {
        Predicate<Integer> Numb2 = integer -> integer%2 == 0;
        List<Integer> exp = Arrays.asList(2, 4, 6);
        List<Integer> act = (List<Integer>)
                Main.filterList((List<Integer>) testvar.get(Integer.class), Numb2);

        difference(exp, act);
    }


    @org.junit.Test
    public void changeInt() {
        Function<Integer, Integer> multiple = a -> a * 2;
        List<Integer> exp = Arrays.asList(2, 4, 6, 8, 10, 12);
        List<Integer> act = (List<Integer>)
                Main.changeList((List<Integer>) testvar.get(Integer.class), multiple);

        difference(exp, act);
    }

    @org.junit.Test
    public void changeFloat() {
        Function<Float, Float> opWithFloats = a -> Math.round((a - 0.5f) * 10f) / 10f;
        List<Float> exp = Arrays.asList(0.5f, 1f, 1.5f, 2f, 2.5f, 2.6f, 3.5f, 3.7f, 4f);
        List<Float> act = (List<Float>)
                Main.changeList((List<Float>) testvar.get(Float.class), opWithFloats);

        difference(exp, act);
    }

    @org.junit.Test
    public void changeString() {
        Function<String, String> stringsWithW = s -> s + "w";
        List<String> expected = Arrays.asList("qwew", "rtyw", "uiow", "asdw", "fghw");
        List<String> actual = (List<String>)
                Main.changeList((List<String>) testvar.get(String.class), stringsWithW);

        difference(expected, actual);
    }

    private <T> void difference(List<T> first, List<T> second) {
        assertTrue(first.size() == second.size() && first.containsAll(second) && second.containsAll(first));
    }

}
