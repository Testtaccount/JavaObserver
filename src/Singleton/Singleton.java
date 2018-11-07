package Singleton;

public class Singleton {

    private static volatile Singleton sInstance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (sInstance == null) {
            synchronized (Singleton.class) {
                if (sInstance == null) {
                    sInstance = new Singleton();
                }
            }
        }
        return sInstance;
    }

    public void print() {
        System.out.println("Print!");
    }
}
