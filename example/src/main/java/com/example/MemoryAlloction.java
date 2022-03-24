package com.example;

public class MemoryAlloction {
    private static final int _1MB=1024*1024;

    //-Xmn10m 新生代内存设置为10m
    //-XX:+PrintGCDetails 输出gc信息
    //-XX:SurvivorRatio=8 Eden和Survivor的空间比例是8:1
    //-verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
    public static void main(String[] args) {
        byte[] alloction1,alloction2,alloction3,alloction4;

        alloction1 = new byte[2*_1MB];
        alloction2 = new byte[2*_1MB];
        alloction3 = new byte[2*_1MB];
        alloction4 = new byte[3*_1MB]; //3MB是把该对象放到新生代，新生代的对象放到了老年代；4M则直接放到了老年代
    }
}
