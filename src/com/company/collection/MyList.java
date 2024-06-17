package com.company.collection;

import com.company.gson.Person;

import java.util.*;

public class MyList {
//    List是有序的集合 允许重复 可以对元素排序可以通过索引位置访问元素 不会出现数组边界问题
//    ArrayList 基于动态数组 具有连续的内存空间
//    LinkedList 基于双向链表
//    本身不是线程安全的



    public static int piaoliang(String abc){
//        漂亮数
        char[] chars = abc.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(char c: chars){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());

        Collections.sort(list, Collections.reverseOrder());
        int value=26;
        int count = 0;
        for(int v:list){
            count += value*v;
            --value;
        }
        return count;

    }

    public  void lianbiao(){
//        6 2 1 2 3 2 5 1 4 5 7 2 2
            int a = 6;
            int b = 2;
            int[] arr =new int[2*a-2];
            for(int i=0;i<arr.length;i++){
                arr[i]=1;
            }
            int delete = 2;
            //System.out.println(arr[7]);
            LinkedList<Integer> list = new LinkedList<>();
            list.add(b);
            for(int i=0;i<(a-1)*2;i=i+2){
                int one = arr[i];
                int two = arr[i+1];
                list.add(list.indexOf(arr[i+1])+1,arr[i]);
            }
            list.remove(list.indexOf(delete));
            for (Integer i : list) {
                System.out.print(i + " ");
            }

    }


 public void  maxandmin(int[] arr, int n){
//        计算数组中最大N个数和最小N个数的和  需要对数组去重  如果最大N个数和最小N个数有重叠 返回-1
     Set<Integer> set = new HashSet<>();
     for(int a: arr){
         set.add(a);
     }
     if(2*n>set.size()){
         System.out.println(-1);
         return;
     }
     int[] newarr = new int[set.size()];
     for(int i:set){
         newarr[i] = i;
     }
     Arrays.sort(newarr);
     int max = 0;
     int min = 0;
     for(int i=0;i<newarr.length;i++){
         max += newarr[newarr.length-i-1];
         min += newarr[i];
     }
     System.out.println(max+min);

 }
    public List<Integer> findFriends(int[] height) {
//        在学校中，N个小朋友站成一队， 第i个小朋友的身高为height[i]， </div> <div>  第i个小朋友可以看到的第一个比自己身高更高的小朋友j，那么j是i的好朋友(要求j &gt; i)。
//        </div> <div>  请重新生成一个列表，对应位置的输出是每个小朋友的好朋友位置，如果没有看到好朋友，请在该位置用0代替  java算法
        int n = height.length;
        List<Integer> friends = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

//        for (int i = 0; i < n; i++) {
//            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
//                friends.set(stack.pop(), i + 1);
//            }
//            stack.push(i);
//            friends.add(0);
//        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(height[j]>height[i]){
                    friends.add(j);
                    break;
                }
                System.out.println(j);
                if(j==n-1){
                    friends.add(0);
                }
            }
        }

        return friends;
    }

    public boolean iszhiyinzi(int n){
        for(int i=2;i<n;i++){
            if(n/i != n){
                return false;
            }
        }
        return true;
    }

    public void zhiyinzi(int n){
        for(int i=2;i<=n;i++){
            System.out.println(iszhiyinzi(i));
        }
    }


public static void main(String[] args) {



//    List<Integer> linkedlist = new LinkedList<>();
//    list.add(123);
//    list.add("abc");
//    list.add(true);
//    list.add('c');
//    for(Object o:list){
//        System.out.println(o);
//    }
//    Object[] arr = new Object[3];
//    arr[0] = 123;
//    arr[1] = "abc";
//    arr[2] = true;
//    for(Object c:arr){
//        System.out.println(c);
//    }

//    int[] arr = {1, 2, 3, 4, 5};
//    String str = Arrays.toString(arr);
//    System.out.println(str); // 输出：[1, 2, 3, 4, 5]
//    int[] arr1 = {1, 2, 3, 4, 5};
//    int[] arr2 = {1, 2, 3, 4, 5};
//    boolean isEqual = Arrays.equals(arr1, arr2);
//    System.out.println(isEqual); // 输出：true
//
//    int[] arr3 = {1, 2, 3, 4, 5, 6};
//    int index = Arrays.binarySearch(arr3, 4);
//    index = Arrays.binarySearch(arr3, 6);
//    System.out.println(index); // 输出：3
//    Arrays.sort(arr3);
//
//    list.add(22);
//    list.add(33);
//
//    list.add(0);
//    list.add(8);
//
//    list.add(2);
//    list.add(33);
//
//    list.add(77);
//    list.add(66);

//    Collections.sort(list);
//    Collections.max(list);
//    Collections.min(list);
//    List<Integer> list1 = new ArrayList<>();
//    Collections.copy(list,list1);
//
//    List<Person> list2 = new ArrayList<>();
//    list2.add(new Person("liruige",123));
//    list2.add(new Person("hugugu",22));
//    list2.add(new Person("gaoxing",345));
//    Collections.sort(list2);
//    for(Person o:list2){
//        System.out.println(o.getName() + "  " + o.getAge());
//    }



//    for(int i=0;i<10;i++){
//        list.add(i);
//        linkedlist.add(i);
//    }
//    System.out.println(list.size());
//    System.out.println(linkedlist.size());
//    System.out.println(list.indexOf(9));
    MyList myList = new MyList();
//    int[] arr3 = {123 ,124, 125 ,121 ,119, 122, 126 ,123,199};
    myList.zhiyinzi(100);
////    Arrays.sort(arr3);
//    for(int a:r){
//        System.out.print(a + " ");
//    }

//    float a = 1.22f;
//    double b = 3;
//    System.out.printf("%.2f \n",a);
//    System.out.printf("%.2f",b);


}

}
