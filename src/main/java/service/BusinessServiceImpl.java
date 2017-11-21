package service;



import model.Author;
import model.Comment;
import model.File;

import java.util.List;


public class BusinessServiceImpl implements BusinessService  {
    private FileDaoImpl dao = new FileDaoImpl();

    public void setDao(FileDaoImpl dao) {
        this.dao = dao;
    }

    public void addFile(File file) {
        dao.addFile(file);
    }

    public List<File> findFile(String content) {
        return dao.findFile(content);
    }

    public List<File> findByTitle(String title) {
        return dao.findFileByTitle(title);
    }

    public List<File> listAll() {
        return dao.listAll();
    }
    public int totalFileList() {
        return dao.totalFileList();
    }

    public File findByid(int id) {
        return dao.findById(id);
    }

    public void deleteFile(int id) {
        dao.deleteFile(id);
    }

    public void update(File file) {
        dao.updateFile(file);
    }

    public Author findAuthorWithFile(int id) {
        return dao.findAuthorWithFile(id);
    }

    public void addAuthor(Author author) {
        dao.addAuthor(author);
    }



    public Author login(String username){
        return dao.login(username);
    }

    public List<Author> listAuthors() {
        return dao.listAuthors();
    }

    public void updateImage(int id) {
        dao.updateImage(id);
    }

    public List<File> list(int id) {
        return dao.list(id);
    }

    public void realUpdate(File file) {
        dao.realUpdate(file);
    }

    public void addComment(Comment comment) {
        dao.addComment(comment);
    }

    public List<Comment> selectComment(int file_id) {
        return dao.selectComment(file_id);
    }


//    public int allPageList() {
//        return dao.totalFileList();
//    }


}
