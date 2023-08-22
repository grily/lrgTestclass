package com.company;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Animal animal[] = {dog, cat};
        animal[0].makeSound();
        animal[1].makeSound();
    }
}
