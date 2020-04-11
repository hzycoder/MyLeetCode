package cn.zy.leetCode.MyStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 *  UNSOLVED 错误，题目要求使用队列，非链表
 *  225. 用队列实现栈
 *  https://leetcode-cn.com/problems/implement-stack-using-queues/
 * create by park.huang 2020/04/11
 **/
//class MyStack {
//    private List<Integer> list;
//
//    /** Initialize your data structure here. */
//    public MyStack() {
//        list = new ArrayList<>();
//    }
//
//    /** Push element x onto stack. */
//    public void push(int x) {
//        list.add(x);
//    }
//
//    /** Removes the element on top of the stack and returns that element. */
//    public int pop() {
//        Integer result = list.get(list.size() - 1);
//        list.remove(list.size() - 1);
//        return result;
//    }
//
//    /** Get the top element. */
//    public int top() {
//        return list.get(list.size() - 1);
//    }
//
//    /** Returns whether the stack is empty. */
//    public boolean empty() {
//        return list.isEmpty();
//    }
//}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */