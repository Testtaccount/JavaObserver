package Singleton;


public class Main {


    public static void main(String[] args) {

        Main main = new Main();
        main.doWork();

    }

    public void doWork() {
           Singleton.getInstance().print();
    }

}
