package CallBack.CallBack5;

public class Main {

    private SomeClass someClass;

    public static void main(String[] args) {

        Main main = new Main();
        main.doWork();

    }

    public void doWork() {
        someClass = new SomeClass();

        int i=-1;
        someClass.doSomething(i, new SomeClass.CallBack() {
            @Override
            public void onCallBack(int i) {
                System.out.println("onCallBack :: " +i);

            }
        });

    }

}
