package com.company.reflect;

public class Get {
//    平时的项目中很少用到反射   但是一般框架设计中会大量用到反射
//    1.JDBC连接数据库时 通过Class.forName() 通过反射加载数据库的驱动程序
//    2.Spring中 XML的配置模式 spring通过xml配置模式装载Bean的过程

    //获取反射机制三种方式
    public static void main(String[] args) throws ClassNotFoundException {
        //方式一(通过建立对象)
        Student stu = new Student();
        Class classobj1 = stu.getClass();
        System.out.println(classobj1.getName());


        //方式二（所在通过路径-相对路径）
        Class classobj2 = Class.forName("com.company.reflect.Student");
        System.out.println(classobj2.getName());

        //方式三（通过类名）
        Class classobj3 = Student.class;
        System.out.println(classobj3.getName());
    }
}
