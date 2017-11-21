package service;

import model.Author;
import model.Comment;
import model.File;

import java.util.List;

/**
 * Created by Yoke on 2017/8/12.
 */
public interface FileDao {
    /**
     * 添加文章
     *
     * @param file 所需要添加的文章类型
     */
    void addFile(File file);

    /**
     * 根据内容进行模糊查询
     *
     * @param content
     * @return
     */
    List<File> findFile(String content);

    /**
     * 根据标题进行查询
     *
     * @param title
     * @return
     */
    List<File> findFileByTitle(String title);


    File findById(int id);

    /**
     * 列出所有的文章
     *
     * @return
     */
    List<File> listAll();

    /**
     * 列出文章的总页数
     *
     * @return
     */
    int totalFileList();

    /**
     * 删除文章
     *
     * @param id 文章的id
     */
    void deleteFile(int id);

    /**
     *
     */
    void updateFile(File file);

    /**
     * 通过作者的id来查找他的所有文章
     *
     * @param id
     * @return
     */
    Author findAuthorWithFile(int id);

    /**
     * 添加作者
     * @param author
     */
    void addAuthor(Author author);

    /**
     * 登录
     * @param username 用户名
     * @return
     */
    Author login(String username);
    List<Author> listAuthors();

    /**
     * 根据id来改变是否拥有头像
     * @param id
     */
    void updateImage(int id);

    List<File> list(int id);
    void realUpdate(File file);
//    添加评论
    void addComment(Comment comment);

    /**
     * 显示评论
     * @param file_id 文章的id
     * @return
     */
    List<Comment> selectComment(int file_id);
}
