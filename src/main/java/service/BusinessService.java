package service;

import model.Author;
import model.Comment;
import model.File;

import java.util.List;

/**
 * Created by Yoke on 2017/8/12.
 */
public interface BusinessService {


     void addFile(File file);

     List<File> findFile(String content);

     List<File> findByTitle(String title);
     List<File> listAll();
     int totalFileList();
     File findByid(int id);
     void deleteFile(int id);
     void update(File file);
     Author findAuthorWithFile(int id);
     void addAuthor(Author author);
     Author login(String username);
     List<Author> listAuthors();
     void updateImage(int id);
     List<File> list(int id);
     void realUpdate(File file);
     void addComment(Comment comment);

     List<Comment> selectComment(int file_id);

}
