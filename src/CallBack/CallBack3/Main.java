package CallBack.CallBack3;

public class Main implements SomeClass.CallBack{

    private SomeClass someClass;

    public static void main(String[] args) {

        Main main=new Main();
        main.doWork();

    }

    public void doWork(){
        someClass = new SomeClass(this);
        someClass.doSomething();
    }

    @Override
    public void onCallBack() {
        System.out.println("onCallBack :: Constructor");
    }

}
