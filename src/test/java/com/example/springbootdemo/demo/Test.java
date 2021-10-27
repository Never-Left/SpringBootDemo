package com.example.springbootdemo.demo;

import com.example.springbootdemo.structure.MyArray;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: ZhangDong
 * @Date: 2019/9/5 16:11
 */
public class Test {

    public static void main(String[] args) {
        MyArray<Double> array = new MyArray<>(3);
        array.insert(0, new Double(3.14));
        array.aa();
//        Double[] array1 = array.getArray();

    }


}
