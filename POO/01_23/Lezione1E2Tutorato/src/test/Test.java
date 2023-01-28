package test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

interface C {
    double getPi();
    double getE();
}

@FunctionalInterface
interface F {
    double getPi();
}

public class Test {
    public static void main(String[] args) {
        C c = new C() {
            @Override
            public double getPi() {
                return 1;
            }

            @Override
            public double getE() {
                return 2;
            }
        };
        System.out.println(c.getPi() + " " +  c.getE());

        F f = () -> 3.14;

        System.out.println(f.getPi());

        Predicate<Integer> p = x -> true;
        p.test(10);
        Consumer<Integer> l = k -> System.out.println("cacca" + k);
        l.accept(10);
        Function<Integer, String> ff = x -> "Stellina mao mao" + x;
        System.out.println(ff.apply(10));

        ArrayList<Integer> in = new ArrayList<>();

        in.stream().filter(x -> x % 2 == 0).map(x -> x * x).forEach(x -> System.out.println(x));
        List<Integer> ll = in.stream().filter(x -> x % 2 == 0).map(x -> x * x).toList();
    }
}
