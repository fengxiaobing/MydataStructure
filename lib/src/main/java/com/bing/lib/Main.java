package com.bing.lib;

public class Main {
    public static void main(String[] args){
        Array<String> array = new Array();
        for (int i = 0; i < 10; i++) {
            array.addLast("分数"+i);
        }
        System.out.println(array);
        array.add(0,"测试便捷");
        System.out.println(array);
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        System.out.println(array);
    }
}
