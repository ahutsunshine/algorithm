package com.algorithm.alibaba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSortAgeAndName {
    public static void main(String[] args) {
        List<NameAge> entries = new ArrayList<>();
        entries.add(new NameAge("Lily", 10));
        entries.add(new NameAge("Hanmeimei", 11));
        entries.add(new NameAge("Lilei", 12));
        entries.add(new NameAge("Lucy", 10));
        entries.add(new NameAge("Michael", 11));
        Collections.sort(entries);
        entries.forEach(e -> System.out.println(e.toString()));
    }
}

class NameAge implements Comparable<NameAge> {
    String name;
    int age;

    public NameAge(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(NameAge other) {
        int c = this.age - other.age;
        if (c != 0) {
            return c;
        }
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "[" + this.name + "," + this.age + "]";
    }
}
