package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    private Product product = new Smartphone(4,"S10", 550, "Samsung");

    @Test
    void shouldFindByName(){
        boolean actual = product.matches("S10");
        assertTrue(actual);

    }
      @Test
    void shouldFindByProducer(){
        boolean actual = product.matches("Samsung");
        assertTrue(actual);

    }
     @Test
    void shouldNotFindByProducer(){
        boolean actual = product.matches("Nokia");
        assertFalse(actual);

    }
     @Test
    void shouldNotFindByName(){
        boolean actual = product.matches("S20");
        assertFalse(actual);

    }

}