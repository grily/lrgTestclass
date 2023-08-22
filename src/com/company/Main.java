package com.company;

import com.company.first.Animal;
import com.company.first.Cat;
import com.company.first.Dog;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Animal animal[] = {dog, cat};
        animal[0].makeSound();
        animal[1].makeSound();
    }
}
