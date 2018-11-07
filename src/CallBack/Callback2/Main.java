package CallBack.Callback2;

public class Main {

    public static void main(String[] args) {

        SomeClass someClass = new SomeClass();

        someClass.setCallBack(new SomeClass.CallBack() {
            @Override
            public void onCallBack() {
                System.out.println("onCallBack :: Anonymous");
            }
        });
        someClass.doSomething();
    }
    
}
