package com.example.springbootdemo.arithmetic.entity;


/**
 * @description:
 * @author: dong.zhang
 * @time: 2021/1/12
 */
public class ListNode {
    int val;
    /**
     * 下一个链表对象
     **/
    ListNode next;

    /**
     * 赋值链表的值
     **/
    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

