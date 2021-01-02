package com.helius.character1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Helius
 * @Create 2020-07-21-12:05 上午
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
