package CallBack.CallBack3;

//Passing via Constructor
public class SomeClass {

   CallBack callBack;

    public SomeClass(CallBack callBack) {
        this.callBack=callBack;
    }

//    void setCallBack(CallBack callBack){
//        this.callBack = callBack;
//    }

    void doSomething(){
        if(callBack !=null){
            callBack.onCallBack();
        }
    }

    interface CallBack {
        void onCallBack();
    }
}