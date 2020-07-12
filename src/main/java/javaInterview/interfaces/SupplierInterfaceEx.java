package javaInterview.interfaces;

import java.util.function.Supplier;

/**
 * Does not take any parameter but returns some kind of object
 */
public class SupplierInterfaceEx {
    public static void main(String[] args) {
        Supplier<String> firstName = new Supplier<String>() {
            @Override
            public String get() {
                return "Kshitiz";
            }
        };

        Supplier<String> secondName = () -> "Gupta";
        System.out.println(firstName.get() + " " + secondName.get());
    }
}
