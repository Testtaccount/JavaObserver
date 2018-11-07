package CallBack.CallBack4;

//Passing via Method
public class SomeClass {

   CallBack callBack;

    public SomeClass() {
        this.callBack=null;
    }

    void setCallBack(CallBack callBack){
        this.callBack = callBack;
    }

    void doSomething(){
        if(callBack !=null){
            callBack.onCallBack();
        }
    }

    interface CallBack {
        void onCallBack();
    }
}