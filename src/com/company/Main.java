package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	    String string = "java is a good java is fine java java";
        System.out.println(string);
        System.out.println();

        String[] ar = string.split(" ");
        int len = ar.length;
        System.out.println("The number of all words is: " + len);
        System.out.println();

        List<String> stringList = Arrays.asList(ar);
        int count = 0;
        for (String str: stringList) {
            if(Objects.equals(str, "java")) {
                count++;
            }
        }
        System.out.println("The number of word java is: " + count);
        System.out.println();

        List<String> newList = stringList.stream().filter(str -> str.length()>1).collect(Collectors.toList());
        System.out.println("The number of words with more then one letter is: " + newList.size());

        for(int i = 0; i<ar.length-1; i++) {
            if(ar[i] == ar[i+1]) {
                System.out.println(ar[i].toString());
            }
        }

        System.out.println();
        Set<String> stringSet1 = stringList.stream().filter(i -> Collections.frequency(stringList, i) > 1)
                .collect(Collectors.toSet());
        System.out.println("Repeating words are: ");
        stringSet1.forEach(System.out::println);

        System.out.println();
        Set<String> item = new HashSet<>();
        Set<String> i = stringList.stream().filter(n -> !item.add(n)).collect(Collectors.toSet());
        System.out.println("Another way to show repeating words: ");
        i.forEach(System.out::println);
    }
}
