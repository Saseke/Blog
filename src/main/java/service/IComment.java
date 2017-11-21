package service;

import model.Comment;

import java.util.List;

/**
 * 控制主体
 */
public interface IComment {
    void addComment(Comment comment);
    List<Comment> selectComment(int file_id);
}
