package com.collection.hashmap;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Auther: chenxin
 * @Date: 2018/8/9 20:16
 * @Description:    确定哈希桶数组索引位置
 */
public class Hash_IndexFor {
    /**
     * HashMap的hash算法
     *步骤1：获取key的hashcode值
     * 步骤2：高位运算，通过hashcode值的高十六位异或低十六位得到hash值
     */
    private int hash(Object key){
        /*if (key == null)    return 0;
        // 获得key的hashcode值
        int hashcode = key.hashCode();
        // 高位运算
        int hash = hashcode ^(hashcode >>> 16); // 高16位与低十六位做异或运算
        return hash;*/
        int h;
        return key == null ? 0: (h = key.hashCode()) ^ (h >>> 16);
    }
    /**
     * 计算索引
     * JDK1.8把它去掉了，但是在put方法中直接使用了，没有单独作为方法。
     *
     */
    private int indexFor(int hash, int length){
        return hash & (length - 1);
    }
}
