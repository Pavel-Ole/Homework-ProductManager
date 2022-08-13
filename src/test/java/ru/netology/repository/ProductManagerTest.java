package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductManager;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "Bun", 5, "Avdeeva");
    Product book2 = new Book(2, "Gnome Vasya", 10, "Lipskerov");
    Product book3 = new Book(3, "Brownie Kuzya", 15, "Alexandrova");
    Product book4 = new Book(7, "Bun2", 7, "Avdeeva");

    Product smartphone1 = new Smartphone(4, "Smart", 20, "Myau");
    Product smartphone2 = new Smartphone(5, "Kript", 25, "Gau");
    Product smartphone3 = new Smartphone(6, "Tipt", 30, "Vau");

    @Test
    public void shouldAddOnlyBooks() {

        manager.add(book1);
        manager.add(book3);
        manager.add(book2);

        Product[] expected = {book1, book3, book2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOnlyBook() {

        manager.add(book1);

        Product[] expected = {book1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldEmpty() {

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOnlySmartphones() {

        manager.add(smartphone2);
        manager.add(smartphone1);
        manager.add(smartphone3);

        Product[] expected = {smartphone2, smartphone1, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddBooksAndSmartphones() {

        manager.add(book1);
        manager.add(book3);
        manager.add(smartphone2);
        manager.add(smartphone1);
        manager.add(smartphone3);

        Product[] expected = {book1, book3, smartphone2, smartphone1, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddBooksAndSmartphonesAndSearchNameBrownieKuzya() {

        manager.add(book1);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = {book3};
        Product[] actual = manager.searchBy("Brownie Kuzya");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddBooksAndSmartphonesAndSearchSeveralName() {

        manager.add(book1);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = {book1, book4};
        Product[] actual = manager.searchBy("Bun");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddBooksAndSmartphonesAndNotSearchNameKript() {

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Kript");

        Assertions.assertArrayEquals(expected, actual);
    }

}
