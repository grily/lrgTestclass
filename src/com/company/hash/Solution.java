package com.company.hash;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
//    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//        字母异位词分组
//        将数组中的单词按字符数组排序  将排序后的字符串作为 hash的key
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] strchar = str.toCharArray();

            Arrays.sort(strchar);
            String a = new String(strchar);
            if(!map.containsKey(a)){
                map.put(a, new ArrayList<>());
            }
            List<String> list = map.get(a);
            list.add(str);
        }

//        return new ArrayList<List<String>>(map.values());
        List<List<String>> list = new ArrayList<List<String>>();
        list.addAll(map.values());
        return list;
    }

    public void piaoliang(String abc){
        char[] charstr = abc.toCharArray();
//        Map<Character,Integer> map = new HashMap<>();
//        for(char c: charstr){
//            map.put(c,map.getOrDefault(c,0)+1);
//        }
        int num = 3;
        for(int i= 0;i< num;i++){
            String s = abc;
            Map<Character,Integer> map =  new HashMap<>();
            for(int j = 0;j< s.length();j++){
                char c = s.charAt(j);
                map.put(c,map.getOrDefault(c,0)+1);
            }
            List<Integer> sortList = new ArrayList();
//            for(Map.Entry<Character,Integer> entrySet: map.entrySet()){
//                sortList.add(entrySet.getValue());
//            }
            for(int value: map.values()){
                sortList.add(value);
            }
            //降序排序
            Collections.sort(sortList,Collections.reverseOrder());
            int count = 26;
            int res = 0;
            for(Integer sort : sortList){
                res += sort*count;
                count--;
            }
            System.out.println(res);
        }

    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs));
    }
}

