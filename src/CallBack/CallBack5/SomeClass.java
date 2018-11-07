package CallBack.CallBack5;

//Passing via Method
public class SomeClass {

    void doSomething(int i,CallBack callBack){
        if (i<0) {
            notify(0, callBack);
            return;
        }
        notify(i, callBack);
    }

    public void notify(int i,CallBack callBack){
        if(callBack != null){
            callBack.onCallBack(i);
        }
    }

    interface CallBack {
        void onCallBack(int i);
    }
}