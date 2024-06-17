package com.company.array;

import java.sql.Array;
import java.util.*;

public class Solution {
    public int longestConsecutive(int[] nums) {
//        找出数组中最长的连续子串 [100,4,200,1,3,2]  4
//        不能直接排序Arrays.sort() 时间复杂度是 nlogn 题目要求的时间复杂度是 n
//        用set先去重 看是否存在num-1  存在的话说明他不是序列的起点 跳过 不存在的话说明他是序列的起点 开始循环判断num++
        int maxlong = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                maxlong = Math.max(maxlong, count);
            }

        }
        return maxlong;
    }

    public void moveZeroes(int[] nums) {
//        数组中的0 全部移动到数组的尾部 且不破坏数组其余元素的相对位置
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public int maxArea(int[] height) {
//        盛最多水的容器  双指针 左右指针
        int max = 0;
//        for(int i=0;i<height.length-1;i++){
//            for(int j=i+1;j<height.length;j++){
//                int high = height[i]>height[j]?height[j]:height[i];
//                int area = (j-i)*high;
//                max = Math.max(max, area);
//            }
//        }

        int left = 0, right = height.length - 1;
        while (left < right) {
            int high = Math.min(height[left], height[right]);
            int area = high * (right - left);
            max = Math.max(max, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }


        }
        return max;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //数组中的3数之和等于0
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;

            while (k > j) {
                int rest = nums[i] + nums[j] + nums[k];
                if (rest == 0) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(nums[i]);
                    list1.add(nums[j]);
                    list1.add(nums[k]);
                    list.add(list1);
                    break;
                } else if (rest > 0) {
                    k--;
                } else {
                    j++;
                }

            }
        }

        return list;

    }

    public int subarraySum(int[] nums, int k) {
//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
//子数组是数组中元素的连续非空序列。
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i]; // 0,3,7,14,16,13,14,18,20,14 ====pre-k====-7,-4,0,7,9,6,7,11,13,7
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public void shexingjizhen(int n){
//        蛇形矩阵  第一行
//        第一行 i=1  j=1 2 3 4    1  3  6  10  n*(n+1)/2
//        第二行 i=2  j=2 3 4      2  5  9      n*(n+1)/2 -i +1
//        第三行 i=3  j=3 4        4  8
//        第四行 i=4  j=4          7
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                System.out.print(j*(j+1)/2-i+1+" ");
            }
            System.out.print("\n");
        }
    }

    public int calculate(String s) {
        //        表达式求值
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
    public static int calculate1(String line){
//        表达式求值
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int number = 0;
        int len = line.length();
        char[] chars = line.toCharArray();
        for(int i = 0; i < len; i++){
            char ch = chars[i];
            if(ch == ' ')continue;
            if(Character.isDigit(ch)){
                number = number * 10 + ch - '0';
            }
            if(ch == '('){
                int count = 1;
                int j = i + 1;
                while(count > 0){
                    if(chars[j] == ')')count--;
                    if(chars[j] == '(')count++;
                    j++;
                }
                //递归，解小括号中的表达式
                number = calculate1(line.substring(i + 1, j - 1));
                i = j - 1;
            }
            if(!Character.isDigit(ch) || i == len - 1){
                if(sign == '+'){
                    stack.push(number);
                }else if(sign == '-'){
                    stack.push(-1 *number);
                }else if(sign =='*'){
                    stack.push(stack.pop() * number);
                }else if(sign == '/'){
                    stack.push(stack.pop() / number);
                }
                //更新符号
                sign = ch;
                //刷新数字
                number = 0;
            }
        }
        //栈中数字求和得到结果
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static int minEatingSpeed(int[] peaches, int H) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;

            System.out.printf("%d, %d , %d \n", left, right, mid);
            if (canFinish(peaches, H, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int minEatingSpeed1(int[] peaches, int H) {
        for(int i=1;i<Integer.MAX_VALUE;i++){
            if(canFinish(peaches,H,i)){
                System.out.println(i);
                return i;
            }
        }
        return 0;

    }


    private static boolean canFinish(int[] peaches, int H, int speed) {
        int time = 0;
//        for (int i = 0; i < peaches.length; i++) {
//            time += (peaches[i] + speed - 1) / speed; // 向上取整
//        }
//        return time <= H;
        for (int i = 0; i < peaches.length; i++) {
            if(peaches[i] < speed){
                time+=1;
            }else{
                if(peaches[i] % speed == 0){
                    time += peaches[i] / speed;
                }else{
                    time += peaches[i] / speed;
                    time += 1;
                }
            }

        }
        return H<time?false:true;
    }


    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
//            int mid = (left+right)/2;
            int mid = left+(right-left)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

//    public static void main(String[] args) {
//        int[] peaches = {3, 6, 7, 11};
//        int H = 8;
////        System.out.println(binarySearch(peaches, 14));
//        int result = minEatingSpeed1(peaches, H);
////        System.out.println("最小速度为：" + result);
//    }


//    public static void main(String[] args) {
//        Solution solution = new Solution();
////        int[] nums = {3,4,7,2,-3,1,4,2,-6};
////        HashMap<Integer, Integer> mp = new HashMap<>();
////        mp.put(1,1);
////        mp.put(2,2);
////        int value = mp.getOrDefault(3,0); //不存在key时  返回默认值
//////        int value = mp.get(3); //不存在key时  直接报错了
////        System.out.println(value);
//////        System.out.println(solution.longestConsecutive(nums));
//////        solution.moveZeroes(nums);
//////        System.out.println(solution.threeSum(nums));
////        System.out.println(solution.subarraySum(nums,7));
////        solution.shexingjizhen(4);
//        String s = "400-300*1/2+(2+4)/3";
//        System.out.println(solution.calculate1(s));  // 输出：7
//
//    }

    public static void main(String[] args) {
//        篮球装入篮筐 输出LR看篮球是怎么出来的
        Scanner scanner = new Scanner(System.in);
        String[] pushInput = scanner.nextLine().split(",");
        String[] popInput = scanner.nextLine().split(",");
        scanner.close();

        int[] pushList = new int[pushInput.length];
        int[] popList = new int[popInput.length];

        for (int i = 0; i < pushInput.length; i++) {
            pushList[i] = Integer.parseInt(pushInput[i]);
        }

        for (int i = 0; i < popInput.length; i++) {
            popList[i] = Integer.parseInt(popInput[i]);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        int popIdx = 0;


        for (int pushNum : pushList) {
            q.add(pushNum);

            while (!q.isEmpty()) {
                if (q.peek().equals(popList[popIdx])) {
                    q.poll();
                    popIdx++;
                    ans.append("L");
                } else if (!q.isEmpty() && q.peekLast().equals(popList[popIdx])) {
                    q.pollLast();
                    popIdx++;
                    ans.append("R");
                } else {
                    break;
                }
            }
        }

        if (ans.length() == pushList.length) {
            System.out.println(ans);
        } else {
            System.out.println("NO");
        }

    }
}

