package com.example;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    static class OOMObject {

    }

    //vm args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
