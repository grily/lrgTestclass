package com.company.digui;

import java.util.*;

public class Solution {

    public long fun1(int a){
//        递归  自己调用自己 每次调用都得给函数创建函数栈 计算结果得回栈
//        斐波那契数列 fn = f(n-1)+f(n-2)
        if(a == 0 || a == 1){
            return a;
        }
        return fun1(a-1)+fun1(a-2);
    }
    public int fun2(int a){
//        非递归  斐波那契数列 重新定义三个变量
        if(a == 0 || a == 1){
            return a;
        }else{
            int t1 = 0;
            int t2 = 1;
            int result = 0;
            for(int i=2;i<a+1;i++){
                result = t1+t2;
                t1 = t2;
                t2 = result;
            }
            return result;
        }
    }

    public int jiecheng(int n){
//        阶乘 fn = n*f(n-1)  递归
        if(n == 0 || n == 1){
            return 1;
        }
        return n*jiecheng(n-1);
    }

    public int jiecheng2(int n){
//        阶乘 fn = n*f(n-1)  非递归 定义2个变量
        if(n == 0 || n == 1){
            return 1;
        }
        int b = 1,result=1;

        for(int i=2;i<n+1;i++){
            result = i*b;
            b = result;
        }
        return result;
    }

    public int qingwa(int a){
//        青蛙上楼梯：这是一个经典的递归问题，楼梯有n个台阶，青蛙一次可以上1个、2个或3个台阶，计算青蛙有多少种上完楼梯的方法。
//        fn = f(n-1)+f(n-2)+f(n-3)
        if(a==1) return 1;
        if(a==2) return 2;
        if(a==3) return 4;
        return qingwa(a-1)+qingwa(a-2)+qingwa(a-3);


    }

    public int qingwa1(int a){
//        青蛙上楼梯：这是一个经典的递归问题，楼梯有n个台阶，青蛙一次可以上1个、2个或3个台阶，计算青蛙有多少种上完楼梯的方法。
//        fn = f(n-1)+f(n-2)+f(n-3)  非递归 需要定义4个变量
        if(a==1) return 1;
        if(a==2) return 2;
        if(a==3) return 4;

        int t1 = 1,t2=2,t3=4;
        int r = 0;
        for(int i=4;i<a+1;i++){
            r = t1+t2+t3;
            t1 = t2;
            t2 = t3;
            t3 = r;
        }
        return r;


    }

    public List<String> generateParenthesis(int n){
//        生成有效括号对
        List<String> list = new ArrayList<>();
        gene(n, list, 0,0, "");
        return list;
    }
    public void gene(int n, List<String> list, int left,int right, String cur){
//        递归的终止条件必须写在前面
        if(right>left||left>n||right>n){
            return;
        }

        if(left == n && right == n){
            list.add(cur);
        }

        if(left<n ){
            gene(n, list, left+1, right,cur+"(");

        }
        if(right<n ){
            gene(n, list, left, right+1,cur+")");

        }

    }



    public int pingguopanzi(int m,int n){
//        动态规划  m个苹果放入n个盘子里面 有几种放法
        int[][] res = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i<j){
                    res[i][j] = res[i][i];
                } else if (i==j) {
                    res[i][j] = 1;
                }
                else{
//                    System.out.println(i);
//                    System.out.println(j);
                    res[i][j] = res[i][j-1] + res[i-j][j];
                }

            }
        }
        return res[m][n];

    }
    public static int count(int a, int b) {
        if(a ==0 || b ==1){
            return 1;
        }else if(a < b){
            return count(a,a);
        }else {
            return count(a,b-1)+count(a-b,b);
        }
    }

//    火车进站 出站有多少种情况
    public void trainOut123(){
        int n = 7;
        int[] trains = {6 ,1 ,5, 3, 2, 7 ,4};
        Stack<Integer> station = new Stack<>();
        List<String> res = new ArrayList<>();
        trainOut3(station, trains, 0,0, "", res);
//        Collections.sort(res);
        System.out.println(res.size());
        for(String aa: res){
            System.out.println(aa);
        }
    }
    public void  trainOut(Stack<Integer> station, int[] trains, int in, int out, String res_temp, List<String> res){
        if (out == trains.length) {   //out表示已经出站的火车数量。当所有火车出站时，表示一个出站序列完成，将其添加到结果中
            res.add(res_temp);
        }
        if (!station.empty()) {  //当车站还有火车时
            int train = station.pop();  //出站一辆火车
            trainOut(station, trains, in, out+1, res_temp + train + " ", res);//该出站火车添加到当前出站序列红，出站火车数量+1
            station.push(train);
        }
        if (in < trains.length) { //当还有火车未进站时
            station.push(trains[in]);//进站一辆火车
            trainOut(station, trains, in+1, out, res_temp, res);//已进站火车数量+1
            station.pop();
        }


    }

    public void trainOut3(Stack<Integer> station, int[] trains, int in, int out, String str, List<String> list){
        if(out == trains.length){
            list.add(str);
        }
        if(!station.empty()){
            int trainnum = station.pop();
            trainOut3(station,trains,in,out-1,str+trainnum+" ",list);
            station.push(trainnum);

        }
        if(in < trains.length){
            station.push(trains[in]);
            trainOut3(station,trains,in+1,out,str,list);
            station.pop();
        }

    }





    public static void main(String[] args) {
        Solution solution = new Solution();
//        for(int i=0;i<10;i++){
//            System.out.println(solution.fun1(i));
//        }
//        for(int i=0;i<10;i++){
//            System.out.println(solution.fun2(i,0));
//        }

//        for(int i=0;i<6;i++){
//            System.out.println(solution.jiecheng2(i));
//        }
//        List<String> l = solution.generateParenthesis(3);
//        System.out.println(l);
//        for(String k:l){
//            System.out.println(k);
//        }
        System.out.println(solution.pingguopanzi(7,3));
//        solution.trainOut123();


    }
}
