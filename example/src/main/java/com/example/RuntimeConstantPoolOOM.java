package com.example;

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOM {
    //设置方法区常量池大小
    //vm args: -XX:PermSize=10m -XX:MaxPermSize=10m
    //jdk1.8用MetaspaceSize替代了PermSize
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i=0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
