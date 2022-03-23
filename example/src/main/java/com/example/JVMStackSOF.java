package com.example;

public class JVMStackSOF {
    private int stackLength=1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    //测试栈深度
    //vm args: -Xss256k
    public static void main(String[] args) throws Throwable {
        JVMStackSOF oom = new JVMStackSOF();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:"+oom.stackLength);
            throw e;
        }
    }
}
