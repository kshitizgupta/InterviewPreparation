package javaInterview.interfaces;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceEx {
    public static void main(String[] args) {
        Consumer<String> printStringCaps = new Consumer<String>() {
            @Override
            public void accept(final String s) {
                System.out.printf("\t %s", s.toUpperCase());
            }
        };

        //Without boiler plate code
        Consumer<String> printStringSmall = s -> System.out.printf("\t %s", s.toLowerCase());

        System.out.println("Using consumer accept method");
        printStringCaps.accept("This is all capital letters");
        printStringSmall.accept("This is all lower case letters");

        List<String> names = List.of("Ross", "Monica", "Joey", "Chandler", "Phoebe", "Rachel", "Gunther","Emily");

        System.out.println("\nPassing consumer to list forEach");
        names.forEach(printStringCaps);

        System.out.println("\nPassing consumer to list forEach without creating consumer object explicitly");
        names.forEach(s -> System.out.printf("\t %s", s.toLowerCase()));
    }
}
