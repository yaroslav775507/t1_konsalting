package org.example.t1_konsalting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

@Controller
public class abController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Подсчет букв");
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateFrequency(@RequestParam String inputString, Model model) {
        Map<Character, Integer> result = calculateCharacterFrequency(inputString);
        result = sortByValueDescending(result);
        model.addAttribute("inputString", inputString);
        model.addAttribute("result", result);
        model.addAttribute("title", "Подсчет букв");
        return "index";
    }

    private Map<Character, Integer> calculateCharacterFrequency(String inputString) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            characterIntegerMap.put(currentChar, characterIntegerMap.getOrDefault(currentChar, 0) + 1);
        }

        return characterIntegerMap;
    }

    private static Map<Character, Integer> sortByValueDescending(Map<Character, Integer> unsortedMap) {
        return unsortedMap.entrySet()
                .stream()
                .sorted(Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Entry::getKey,
                        Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}