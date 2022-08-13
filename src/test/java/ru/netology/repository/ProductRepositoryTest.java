package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product book1 = new Book(1, "Bun", 5, "Avdeeva");
    Product book2 = new Book(2, "Gnome Vasya", 10, "Lipskerov");
    Product book3 = new Book(3, "Brownie Kuzya", 15, "Alexandrova");

    Product smartphone1 = new Smartphone(4, "Smart", 20, "Myau");
    Product smartphone2 = new Smartphone(5, "Kript", 25, "Gau");
    Product smartphone3 = new Smartphone(6, "Tipt", 30, "Vau");

    @Test
    public void shouldSaveOnlyBook() {

        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOnlySmartphone() {

        ProductRepository repo = new ProductRepository();

        repo.save(smartphone1);
        repo.save(smartphone3);

        Product[] expected = {smartphone1, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveBookAndSmartphone() {

        ProductRepository repo = new ProductRepository();

        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);

        Product[] expected = {book2, book3, smartphone1, smartphone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldEmpty() {

        ProductRepository repo = new ProductRepository();

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveBookRemoteBookWithId3() {

        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.remoteById(3);

        Product[] expected = {book1, book2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveSmartphoneAndBookRemoteSmartphoneWithId5() {

        ProductRepository repo = new ProductRepository();

        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.remoteById(5);

        Product[] expected = {book2, book3, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
