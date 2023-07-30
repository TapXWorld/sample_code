package org.example.learn.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test1 {

    static class Personal {

        public int point = 0;
        
        public Personal(int point) {
            this.point = point;
        }

        public boolean isMorethan60Points() {
            return this.point > 60;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("---");

        // Custom Object to filter
        List<Personal> list = new ArrayList<>();
        list.add(new Personal(10));
        list.add(new Personal(20));
        list.add(new Personal(10));
        list.add(new Personal(80));
        list.add(new Personal(10));
        list.add(new Personal(100));

        List<Personal> filterd = list.stream().filter(Personal::isMorethan60Points).collect(Collectors.toList());

        filterd.stream().forEach(element -> {
            System.out.println(element.point);
        });

        System.out.println("---");

        // Using inner JDK class to filter
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> integerFiltered = integerList.stream().filter(element -> element > 5).collect(Collectors.toList());
        integerFiltered.stream().forEach(element -> {
            System.out.println(element);
        });

        System.out.println("---");

        // Test reduce function
        int sum = integerList.stream().reduce(0, (left, right) -> left + right);
        System.out.println(sum);
    }
}
