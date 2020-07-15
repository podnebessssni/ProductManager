package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Product product = new Book(3,"Idiot", 75, "Dostoyevski");

    @Test
    void shouldFindByAuthor() {

       boolean actual = product.matches("Dostoyevski");
       assertTrue(actual);
    }
    @Test
    void shouldFindByName() {

       boolean actual = product.matches("Idiot");
       assertTrue(actual);
    }
    @Test
    void shouldNotFindByName() {

       boolean actual = product.matches("Hamlet");
       assertFalse(actual);
    }
     @Test
    void shouldNotFindByAuthor() {

       boolean actual = product.matches("Shakespear");
       assertFalse(actual);
    }


}