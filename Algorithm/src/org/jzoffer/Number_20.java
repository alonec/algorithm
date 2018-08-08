package org.jzoffer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Number_20 {

    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();  // 栈顶的数一定是最小的

    public void push(int node) {
        stack1.push(node);
        if(stack2.isEmpty()){   // 第一个元素
            stack2.push(node);
        }else {
            if(stack2.peek() > node){       // 注意这里会把相同的数也存进栈
                stack2.push(node);
            }
        }

    }

    public void pop() {
        if (!stack2.isEmpty() ) {
            if (stack2.peek() ==  stack1.peek() ){  // pop所有比要出栈的元素小的数
                stack2.pop();
            }
        }
        top();
    }

    public int top() {
        if (! stack1.isEmpty()){
            return stack1.pop();
        }
        return Integer.parseInt(null);
    }

    public int min() {
        if (!stack2.isEmpty()){
            return stack2.peek();
        }
        return Integer.parseInt(null);
    }
}
