package com.company;

import com.company.first.Animal;
import com.company.first.Cat;
import com.company.first.Dog;
import second.Rectangle;
import second.Square;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Animal animal[] = {dog, cat};
        animal[0].makeSound();
        animal[1].makeSound();
    }
//public static void main(String[] args) {
//    Rectangle rt = new Rectangle(3.3,4.4);
//    Square sq = new Square(3.3);
//
//    System.out.println("长方形的面积=" + rt.getArea());
//    System.out.println("正方形的面积=" + sq.getArea());
//}
}
