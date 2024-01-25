package org.example.t1_konsalting.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class AbControllerTest {

    @InjectMocks
    private abController abController;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testIndex() {
        String result = abController.index(model);
        assertEquals("index", result);
        verify(model, times(1)).addAttribute(eq("title"), eq("Подсчет букв"));
    }

    @Test
    void testCalculateFrequency() {
        String inputString = "aaaaabcccc";
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put('a', 5);
        expectedResult.put('b', 1);
        expectedResult.put('c', 4);
        String result = abController.calculateFrequency(inputString, model);
        assertEquals("index", result);
        verify(model, times(1)).addAttribute(eq("inputString"), eq(inputString));
        verify(model, times(1)).addAttribute(eq("result"), eq(expectedResult));
        verify(model, times(1)).addAttribute(eq("title"), eq("Подсчет букв"));
    }

    @Test
    void testSortByValueDescending() {
        abController abc = new abController();
        Map<Character, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put('a', 3);
        unsortedMap.put('b', 1);
        unsortedMap.put('c', 5);
        unsortedMap.put('d', 2);
        Map<Character, Integer> expectedSortedMap = new LinkedHashMap<>();
        expectedSortedMap.put('c', 5);
        expectedSortedMap.put('a', 3);
        expectedSortedMap.put('d', 2);
        expectedSortedMap.put('b', 1);
        Map<Character, Integer> actualSortedMap = abc.sortByValueDescending(unsortedMap);
        assertEquals(expectedSortedMap, actualSortedMap);
    }
}
