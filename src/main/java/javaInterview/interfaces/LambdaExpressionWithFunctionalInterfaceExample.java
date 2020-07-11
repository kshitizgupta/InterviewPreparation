package javaInterview.interfaces;

public class LambdaExpressionWithFunctionalInterfaceExample {

    @FunctionalInterface
    interface Abc {
        void show();
    }

    public static void main(String[] args) {
        //Earlier
        Abc old = new Abc() {
            @Override
            public void show() {
                System.out.println("Functional Interface Old Example");
            }
        };

        old.show();
        //With Java8
        Abc newObj = () -> System.out.println("Functional Interface wiht lambda Implementation");

        newObj.show();
    }
}
