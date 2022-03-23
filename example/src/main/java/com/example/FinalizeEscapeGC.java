package com.example;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVA_HOOK = null;

    public void isAlive(){
        System.out.println("yes,i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVA_HOOK=this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVA_HOOK=new FinalizeEscapeGC();

        //第一次拯救自己
        SAVA_HOOK=null;
        System.gc();
        Thread.sleep(500); //finalize优先级比较低，所以暂停0.5秒等待执行
        if(SAVA_HOOK!=null){
            SAVA_HOOK.isAlive();
        }else{
            System.out.println("no,i am dead :(");
        }

        //第二次拯救自己失败
        SAVA_HOOK=null;
        System.gc();
        Thread.sleep(500);
        if(SAVA_HOOK!=null){
            SAVA_HOOK.isAlive();
        }else{
            System.out.println("no,i am dead :(");
        }
    }
}
