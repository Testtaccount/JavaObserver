package CallBack.CallBack1;

public class CallBackImpl implements SomeClass.CallBack {

    @Override
    public void onCallBack() {
        System.out.println("onCallBack :: CallBackImpl");
    }
}
