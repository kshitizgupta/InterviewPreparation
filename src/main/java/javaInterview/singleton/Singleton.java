package javaInterview.singleton;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton implements Serializable {
    static private volatile Singleton instance = null;
    private static final Object mutex = new Object();

    private Singleton() {
        if (instance != null) {
            throw new IllegalStateException("Illegal access of constructor");
        }
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (mutex) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    //Preventing from clone
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    //Preventing from deserialisation
    protected Object readResolve() {
        return instance;
    }

    public static void main(String[] args) {
//        testReflectionIssue();

        int result = test(15);
        System.out.println(result);
        return;
    }

    private static int test(int a) {
        try {
            System.out.println("In try 1");
            if(a > 5) {
                throw new Exception();
            }
            System.out.println("In try 2");
        } catch (Exception e) {
            e.printStackTrace();
            return 6;
        } finally {
            System.out.println("In fainally");
            return 5;
        }
    }

    private static void testReflectionIssue() {
        Singleton firstObj = Singleton.getInstance();
        Singleton secondObj;
        try {
            Constructor constructor = Singleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);

            secondObj = (Singleton) constructor.newInstance();
        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
        } catch (IllegalAccessException e) {
//            e.printStackTrace();
        } catch (InstantiationException e) {
//            e.printStackTrace();
        } catch (InvocationTargetException e) {
//            e.printStackTrace();
        } catch (IllegalStateException e) {
//            e.printStackTrace();
        }
    }
}
