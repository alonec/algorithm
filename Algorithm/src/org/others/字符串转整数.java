package org.others;

/**
 * 将一个字符串转整数，数值为0或者是字符串等不是一个合法的数值返回0，
 * 小数直接取整数部分。要求：不能使用字符串转整数的库函数
 *
 */
public class 字符串转整数 {

    public static void main(String[] args) {
        String str = "03.6e7";
//        String str = "0367";

        method(str);
    }
    public static int method(String str){
        char[] strs = str.toCharArray();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if ( !(strs[i] <= 58 && strs[i] >= 48) && strs[i] != '.'){
                return 0;
            }
        }
        int i;
        for (i = 0; i < str.length(); i++) {
            while (strs[i] == '0'){
                i++;
            }
            if (strs[i] == '.'){
                break;
            }else {
                result.append(strs[i]);
            }
        }
        System.out.println(result);
        return 1;
    }

}
