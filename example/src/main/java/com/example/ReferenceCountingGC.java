package com.example;

public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB=1024*1024;

    private byte[] bigSize = new byte[20*_1MB];

    //打印gc日志
    //vm args: -verbose:gc
    public static void main(String[] args) {
        ReferenceCountingGC objA=new ReferenceCountingGC();
        ReferenceCountingGC objB=new ReferenceCountingGC();
        objA.instance=objB;
        objB.instance=objA;

        objA=null;
        objB=null;

        System.gc();
    }
}
