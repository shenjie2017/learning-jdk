package com.example;

public class JVMStackOOM {
    private void dontStop(){
        while(true){
        }
    }

    public void stackLeakByThread(){
        while(true){
            new Thread(new Runnable() {
                public void run() {
                    dontStop();
                }
            }).start();
        }
    }

    //测试线程对栈的影响
    //-Xss2m
    public static void main(String[] args) {
        new JVMStackOOM().stackLeakByThread();
    }
}
