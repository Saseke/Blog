package service;

import model.Author;

import java.util.List;

/**
 * 测试类
 */
public interface Iauthor {

    Author findAuthor(int id);

    void addAuthor(Author author);
    Author login(String username);
    List<Author> listAuthor();
    void updateImage(int id);
}
