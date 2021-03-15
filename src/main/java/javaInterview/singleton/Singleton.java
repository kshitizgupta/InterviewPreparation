package javaInterview.singleton;

import java.io.Serializable;

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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    protected Object readResolve() {
        return instance;
    }
}
