package CallBack.CallBack1;

public class Main {

    public static void main(String[] args) {

        SomeClass someClass = new SomeClass();

        CallBackImpl myCallBackImpl = new CallBackImpl();
        someClass.setCallBack(myCallBackImpl);
        someClass.doSomething();
    }

}
