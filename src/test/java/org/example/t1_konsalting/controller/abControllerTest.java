package org.example.t1_konsalting.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashMap;
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
}
