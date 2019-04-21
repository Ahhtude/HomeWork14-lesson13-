package org.socket.demo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

interface IFunction {
    int doSomethingWithNumbers(int param1, int param2);
}

public class LambdaDemo {

    public static void main(String[] args) {
        doAdd(1, 2, new IFunction() {
            @Override
            public int doSomethingWithNumbers(int param1, int param2) {
                return param1 - param2;
            }
        });

        doAdd(1, 2, (p1, p2) -> {
            return 0;
        } );

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.forEach((value)->{
            System.out.println("value is " + value);
            System.out.println(set.size());
        });

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.forEach(value->{
            System.out.println(value * 2);
        });

        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer * 2);
            }
        });

        Consumer<Integer> intConsumer = a -> {};
    }

    public static void doAdd(int param1, int param2, IFunction addFunction) {
        addFunction.doSomethingWithNumbers(param1, param2);
    }
}
