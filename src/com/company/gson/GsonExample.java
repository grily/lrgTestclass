
package com.company.gson;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GsonExample {
    public static void main(String[] args) {
        // 创建一个Gson对象
        Gson gson = new Gson();

        // 定义一个Java对象
        Person person = new Person("John", 25);

        // 将Java对象转换为JSON字符串
        String jsonString = gson.toJson(person);
        System.out.println("JSON String: " + jsonString);

        // 将JSON字符串转换回Java对象
        Person deserializedPerson = gson.fromJson(jsonString, Person.class);
        System.out.println("Deserialized Person: " + deserializedPerson);

        Person person2 = new Person("John", 25);
        System.out.println("person和person2的比较：" + person.compareTo(person2));

        Set<Person> set2 = new HashSet<>();
        set2.add(person);
        set2.add(person2);
        System.out.println(set2.size());
//        person2.setName("lili");

        System.out.println(person.hashCode());
        System.out.println(person2.hashCode());
        if(person2.equals(person)){
            System.out.println("相等");
        }else{
            System.out.println("不相等");
        }

//        Map<Person,Integer> map = new HashMap<>();
//        Set<Person> set = new HashSet<>();
//        for(int i=0;i<10;i++){
//            map.put((new Person("lili",i)),i);
//            set.add(new Person("lili",i));
//        }
//
//        map.values();
//        for(int i : map.values()){
//            System.out.println(i);
//        }
//        for(Person p: set){
//            System.out.println(p.getName());
//        }



    }
}
