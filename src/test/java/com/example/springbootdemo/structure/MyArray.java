package com.example.springbootdemo.structure;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: dong.zhang
 * @time: 2021/4/28 19:03
 */
@Data
@NoArgsConstructor
public class MyArray<T> {

    private T[] array;
    private int size;

    public MyArray(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    public void aa() {
        boolean flag = this.array instanceof Double[] ? true : false;
        System.out.println((T) this.array[0].getClass().getName());
        System.out.println(flag);
    }

    public void insert(int index, T element) {
        this.array[index] = element;
    }
}
