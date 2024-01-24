package org.example.t1_konsalting;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class abclass {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        if(!str.isEmpty()){
            for (int i = 0; i < str.length(); i++) {
                char currentChar = str.charAt(i);
                characterIntegerMap.put(currentChar, characterIntegerMap.getOrDefault(currentChar, 0) + 1);
            }
            characterIntegerMap.forEach((character, count) -> {
                System.out.println("Буква: " + character + ", Количество повторений: " + count);
            });
        }else {
            System.out.println("Введена пустая строка");
        }
    }
}
