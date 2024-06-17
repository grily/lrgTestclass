package com.company.string;

import java.util.*;

import static java.lang.Character.MIN_VALUE;
import static java.lang.Character.digit;

public class Solution {
//    String 不是基础数据类型 他是字符数组 使用final修饰之后是不可变的 对他进行的任何操作都是创建一个新的对象 再把引用指向该对象
//    @Stable
//    private final byte[] value;
    public boolean isValid(String s) {
//        "{{}}"
//        判断字符串是否有效 {} [] ()
        Stack<Character> st = new Stack<>();
        for (Character a : s.toCharArray()) {
            if (a == '{') {
                st.add('}');
            } else if (a == '[') {
                st.add(']');
            } else if (a == '(') {
                st.add(')');
            } else {
                if (st.isEmpty() || a != st.pop()) {
                    return false;
                }
            }
        }
        if (!st.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isValid1(String s) {
//        "{{}}[]"
//        判断字符串是否有效 {} [] ()  不使用栈
        if (s == null || s.isEmpty()) {
            return false;
        }
        if (s.length() % 2 > 0) {
            return false;
        }
        int length = s.length() / 2;
        while (length > 0) {
            s = s.replace("{}", "").replace("[]", "").replace("()", "");
            System.out.println(s);
            --length;
        }
        return s.length() == 0;
    }

    public List<String> generateParenthesis(int n) {
//        生成的字符串
        List<String> res = new ArrayList<>();
        generenteI(res, 0, 0, n, "");
        return res;

    }

    private void generenteI(List<String> res, int left, int right, int n, String cur) {

        if (left == n && right == n) {
            res.add(cur);
        }
        if (left > n || right > n || right > left) {
            return;
        }
        if (left < n) {
            generenteI(res, left + 1, right, n, cur + "(");
        }
        if (right < n) {
            generenteI(res, left, right + 1, n, cur + ")");
        }

    }

    public int strStr(String haystack, String needle) {
//        子串在原字符串中出现的位置 遍历原字符串
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= m - n; i++) {
            System.out.println("i=" + i);
            int a = i;
            int b = 0;
            while (b < n && haystack.charAt(a) == needle.charAt(b)) {
                int index1 = haystack.charAt(a);
                int index2 = needle.charAt(b);
                a++;
                b++;
            }

            if (b == n) {
//                找到了子串  返回当前在原字符串中的位置
                return i;
            }
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int lengthOfLongestSubstring(String s) {
//        字符串的最长不重复子串的长度
//        滑动窗口
        Set<Character> strSet = new HashSet<>();
        int len = s.length();
        int j = -1;
        int maxCount = 0;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                //窗口向右滑动一次
                strSet.remove(s.charAt(i - 1));
            }
            while (j + 1 < len && !strSet.contains(s.charAt(j + 1))) {
//                在字符串范围内 新的字符没有出现过 就继续循环
                strSet.add(s.charAt(j + 1));
                j++;
            }
            maxCount = Math.max(maxCount, j - i + 1);
        }
        return maxCount;
    }

    public int myAtoi(String s) {
        //String类型转为整形 从第一个字符开始到遇到数字 遇到数字后在遇到非数据就截断
        if (s.isEmpty()) {
            return 0;
        }
        // 处理空格
        int n = s.length();
        int index = 0;
        while (index < n && s.charAt(index) == ' ') {
            ++index;
        }

        // 处理符号
        int sign = 1;
        int res = 0;
        if (index < n && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        // 处理数字
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            ++index;
        }
        return sign * res;

    }
    public int myAtoi1(String s) {
        int result = 0;
        if(s.length()==0){
            return result;
        }
        int index = 0;
        int n = s.length();

        while(index<n && s.charAt(index) == ' '){
            index++;
        }

        int sign = 1;
        if(index<n && (s.charAt(index) == '-' || s.charAt(index) == '+' )){
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;

        }

        while(index<n){
            if(Character.isDigit(s.charAt(index))){
                int digit = s.charAt(index) - '0';
                if((result-digit)/10 > Integer.MAX_VALUE){
                    return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                result = result*10 + digit;
            }
            index++;

        }
        return sign*result;
    }

    public String longestCommonPrefix(String[] strs) {
//        最长公共前缀 拿出来第一个元素 依次和别的元素进行 比较 是否是别的元素的前缀 不是的话就 截取
        if (strs.length == 0) return "";
        String first = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(first)) {
//                System.out.println(first);
                first = first.substring(0, first.length() - 1);
            }
        }
        return first;

    }

    public void multiply() {

        String str = "Hello";
        str = str + " World";
        System.out.println("str=" + str);
//        看着是String类型的内容被改变了  其实是引用被改变了 str由原来的hello的内存地址转为 指向 hello world 的内存地址而已

        String str1="i";
        String str2=new String("i");
//       这两种变量都创建了字符串“i” 她两一样吗？  不一样   内存的分配方式不一样
//       String str1="i";                 java虚拟机会将  "i" 其分配到常量池中  str1指向静态区
//       String str2=new String("i");     分配到堆内存  str2指向堆上的对象
//
        String a = "abcdefg";
        StringBuffer sb = new StringBuffer();
        sb.append(a).reverse();
        System.out.println(sb.toString());
        StringBuilder SB1 = new StringBuilder();


    }

    public String reverse(String abc){
//        字符串的反转
        char[] arr = abc.toCharArray();
        int i=0,j=abc.length()-1;
        while(i<j){
            System.out.println(i);
            System.out.println(j);
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            ++i;
            --j;
        }
        System.out.println(arr.toString());
        return new String(arr);

    }
    public String reverseStr(String abc){
        char[] arr = abc.toCharArray();
        int i=0;
        int j=abc.length()-1;
        while(i<j){
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            ++i;
            --j;
        }
        return new String(arr);

    }
    public int total1(int input){
        String abc = Integer.toBinaryString(input);
        char[] arr = abc.toCharArray();
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == '1'){
                count++;
            }
        }
        return count;
    }

    public void maiji(){
        for(int i=0;i<=20;i++){
                if((100-7*i)%4 == 0){
                    int j = (100-7*i)/4;
                    int z = 100-i-j;
                    if(j>0){
                        System.out.printf("i=%d,j=%d,z=%d \n",i,j,z);
                    }

                }

        }
    }

//    输入一个表达式（用字符串表示），求这个表达式的值。
//保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
//        3+2*{1+2*[-4/(8-6)+7]}    25

    public boolean wanquanshu(int n){
        int count = 0;
        for(int i=1;i<n;i++){
            if(n%i==0){
                System.out.println(i);
//                System.out.println(count);
                count+=i;
            }
        }
        System.out.println(count);
        return count==n?true:false;
    }






    // 注意类名必须为 Main, 不要有任何 package xxx 信息
        public static void main(String[] args) {
//            Scanner in = new Scanner(System.in);
//            // 注意 hasNext 和 hasNextLine 的区别
//            while (in.hasNextInt()) { // 注意 while 处理多个 case
//                int a = in.nextInt();
//                int b = in.nextInt();
//                System.out.println(a + b);
//            }
//            Solution solution = new Solution();
//            String abc = solution.reverseStr("zsffhgiiswalncvmbgkwlwtonhrxzqtcfifybxrhsicyqbbvrbegwixlheqcgytx");
//            System.out.println(abc);
//            solution.maiji();
//            System.out.println(solution.wanquanshu(28));
//            double a = 3.51;
//            long rr = Math.round(a);
//            System.out.println(rr);
//            int count = 0;
//            for(int i=1;i<20;i++){
//                if((""+i).contains("7")||i%7==0){
//                    System.out.println(i);
//                    count++;
//                }
//            }
//            System.out.println(count);
//            String aa = "I am a boy";
//            String[] arr = aa.split(" ");
//            for(int i=arr.length-1;i>=0;i--){
//                System.out.println(arr[i]);
//            }
//            Scanner in = new Scanner(System.in);
//
//            String[] arr = in.nextLine().split(" ");
//            // String[] arr = a.split(" ");
//            System.out.println(arr);
//            int i = arr.length-1;
//            while(i>=0){
//                System.out.print(arr[i]);
//                --i;
//            }
//            Scanner in = new Scanner(System.in);
//            String str = in.nextLine();
//            StringBuffer sb = new StringBuffer(str);
//            System.out.println(sb.reverse().toString());
//            int a = 200;
//            String stra = Integer.toBinaryString(a);
//            System.out.println(stra);
//            char[] arr = stra.toCharArray();
//            int max = 0;
//            for(int i=0;i<arr.length;i++){
//                int count = 0;
//                while(i<arr.length&&arr[i]=='1'){
//                    ++count;
//                    i++;
//                }
//                max = Math.max(max,count);
//            }
//            System.out.println(max);
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
//            while (in.hasNextInt()) { // 注意 while 处理多个 case
//                int a = in.nextInt();
//                int b = in.nextInt();
//                System.out.println(a + b);
//            }
            int n = in.nextInt();
            int lifang = (int)Math.pow(n,3);
//            等差数列求和   s=a1*n + n(n-1)*d/2
//            a1 = s/n-(n-1)*d/2
            int a1 = lifang/n -n + 1;
            for(int i=1;i<=n;i++){
                System.out.print(a1+"+");
                a1 += 2;
            }





        }



//    public static void main(String[] args) {
//        Map<Integer, Integer> map = new HashMap();
//        map.put(1, 1);
//        map.containsKey(1);
//        Solution solution = new Solution();
//        String[] arrs = new String[3];
//        arrs[0] = "florrrr";
//        arrs[1] = "flowser1";
//        arrs[2] = "flowser2";
//
////        solution.isValid1("{{{}}}");
////        solution.isValid1("{{{}}}[][][](({}))");
////        solution.generateParenthesis(3);
//        System.out.println(solution.generateParenthesis(3));
////        System.out.println(solution.strStr1("leetcode","leet"));
//        System.out.println(solution.myAtoi1("    --1"));
//        System.out.println(solution.myAtoi("    --1"));
//      System.out.println("最长公共前缀" + solution.longestCommonPrefix(arrs));
//
//        char a = 'a';
//
//
//        System.out.println(a-'0');
//        solution.multiply();
//        Integer aa = 129;
//        Integer bb = 129;
//        System.out.println(aa == bb);
//
//    }
}
