package com.company.gson;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name123='" + name + '\'' +
                ", age123=" + age +
                '}';
    }
    Object object = new Object();

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Person person = (Person) obj;
        return age==person.age && name==person.name;

    }

//    @Override
//    public int hashCode(){
//        int result = 17;
//        result = 31*result + name.hashCode();
//        result = 31*result + age;
//        return result;
//    }

    @Override
    public int compareTo(Person var1){
        int result =  this.age - var1.age;
        if(result == 0){
            result = this.name.compareTo(var1.getName());
        }
        return result;
    }
}
