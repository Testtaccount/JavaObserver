package CallBack.CallBack4;

public class Main{

    private SomeClass someClass;

    public static void main(String[] args) {

        Main main=new Main();
        main.doWork();

    }

    public void doWork(){
        someClass = new SomeClass();
        someClass.setCallBack(new SomeClass.CallBack() {
            @Override
            public void onCallBack() {
                System.out.println("onCallBack :: Method");
            }
        });
        someClass.doSomething();
    }

}
