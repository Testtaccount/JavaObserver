package CallBack.CallBack6;

public class Main {

    private SomeClass someClass;

    public static void main(String[] args) {

        Main main = new Main();
        main.doWork();

    }

    public void doWork() {
        someClass = new SomeClass();
        CallBack callBack=new CallBack() {
            @Override
            public void onCallBack(int i) {
                System.out.println("onCallBack :: " +i);

            }
        };
        someClass.setCallBack(callBack);
        int i=5;
        someClass.doSomething(i);
    }

}
