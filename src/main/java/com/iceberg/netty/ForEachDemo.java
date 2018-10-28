package com.iceberg.netty;

import java.time.Period;
import java.util.ArrayList;

class People {
    public int id;
    public int name;
    public int age;

    public People(int id) {
        this.id = id;
    }

    public People(int id, int name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name=" + name +
                ", age=" + age +
                '}';
    }
}

public class ForEachDemo {



    public static void main(String[] args) {
        ArrayList<People> people = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            people.add(new People(i));
        }

        for (People people1: people) {
            people1.age = people1.id;
        }

        for (People people1: people) {
            System.out.println(people1);
        }

    }
}

