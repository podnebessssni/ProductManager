package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;


class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product first = new Book(1,"Hamlet", 100, "Shakespeare");
    private Product second = new Book(2,"Harry Potter", 80, "Joan Rowling");
    private Product third = new Book(3,"Idiot", 75, "Dostoyevski");
    private Product fourth = new Smartphone(4,"S10", 550, "Samsung");
    private Product fifth = new Smartphone(5,"3310", 100, "Nokia");
    private Product sixth = new Smartphone(6,"S20", 600, "Samsung");
    private Product seventh = new Book(7,"QA Information", 35, "Samsung");


    @BeforeEach
    void setUp(){
    manager.add(first);
    manager.add(second);
    manager.add(third);
    manager.add(fourth);
    manager.add(fifth);
    manager.add(sixth);
    manager.add(seventh);
    }

    @Test
    void shouldSearchByAuthor() {

    Product[] expected = {new Book(3,"Idiot", 75,"Dostoyevski" )} ;
    Product[] actual = manager.searchBy("Dostoyevski");
    assertArrayEquals(expected, actual);

    }
    @Test
    void shouldSearchByName() {

        Product[] expected = {new Smartphone(4, "S10", 550, "Samsung")};
        Product[] actual = manager.searchBy("S10");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookName() {

        Product[] expected = {new Book(1,"Hamlet", 100, "Shakespeare")};
        Product[] actual = manager.searchBy("Hamlet");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByProducer() {

        Product[] expected = {new Smartphone(5,"3310", 100, "Nokia")};
        Product[] actual = manager.searchBy("Nokia");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByNonExistName() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Tolstoy");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchMoreThanOne() {

        Product[] expected = {new Smartphone(4,"S10", 550, "Samsung"),
                              new Smartphone(6,"S20", 600, "Samsung"),
                              new Book(7,"QA Information", 35, "Samsung")};
        Product[] actual = manager.searchBy("Samsung") ;
        assertArrayEquals(expected, actual);
    }


}