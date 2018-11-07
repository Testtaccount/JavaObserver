package CallBack.CallBack6;

//Passing via Method
public class SomeClass {

    private CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    void doSomething(int i){
        if (i<0) {
            notify(0);
            return;
        }
        notify(i);
    }

    public void notify(int i){
        if(callBack != null){
            callBack.onCallBack(i);
        }
    }

}