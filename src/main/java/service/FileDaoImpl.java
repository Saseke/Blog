package service;


import DBAccess.DBAccess;
import IFile.IFile;
import model.Author;
import model.Comment;
import model.File;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileDaoImpl implements FileDao {

    public void addFile(File file) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            IFile iFile = sqlSession.getMapper(IFile.class);
            iFile.addFile(file);
            sqlSession.commit();
            System.out.println("保存成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            assert sqlSession != null;
            sqlSession.close();
        }
    }

    public List<File> findFile(String content) {
        DBAccess db = new DBAccess();
        SqlSession sqlsession = null;
        List<File> files = null;
        try {
            sqlsession = db.getSqlSession();
            IFile iFile = sqlsession.getMapper(IFile.class);
            files = iFile.findFile(content);
            sqlsession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert sqlsession != null;
            sqlsession.close();
        }
        return files;
    }

    public List<File> findFileByTitle(String title) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        List<File> files = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            IFile iFile = sqlSession.getMapper(IFile.class);
            files = iFile.findFileByTitle(title);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
        return files;
    }

    public File findById(int id) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        File file = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            IFile iFile = sqlSession.getMapper(IFile.class);
            file = iFile.findById(id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
        return file;
    }

    public List<File> listAll() {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;

        List<File> files = new ArrayList<File>();
        try {
            sqlSession = dbAccess.getSqlSession();
            IFile iFile = sqlSession.getMapper(IFile.class);
            files = iFile.listAll();
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            assert sqlSession != null;
            sqlSession.close();
        }
        return files;
    }

    public int totalFileList() {
        List<File> files = listAll();
        return files.size();

    }
// 删除文章
    public void deleteFile(int id) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            IFile iFile = sqlSession.getMapper(IFile.class);
            iFile.deleteFile(id);
            sqlSession.commit();
            System.out.println("删除成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }
//    更新文章
    public void updateFile(File file) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            IFile iFile = sqlSession.getMapper(IFile.class);
            iFile.updateFile(file);
            sqlSession.commit();
            System.out.println("更新成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }

    }

    public Author findAuthorWithFile(int id) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        Author author = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Iauthor iauthor = sqlSession.getMapper(Iauthor.class);
            author = iauthor.findAuthor(id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
        return author;
    }

    public void addAuthor(Author author) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;

        try {
            sqlSession = dbAccess.getSqlSession();
            Iauthor iauthor = sqlSession.getMapper(Iauthor.class);
            iauthor.addAuthor(author);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    public Author login(String username) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        Author author = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Iauthor iauthor = sqlSession.getMapper(Iauthor.class);
             author = iauthor.login(username);
             sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert sqlSession != null;
            sqlSession.close();
        }
        return author;
    }

    public List<Author> listAuthors() {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        List<Author> authors = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Iauthor iauthor = sqlSession.getMapper(Iauthor.class);
            authors =  iauthor.listAuthor();
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert sqlSession != null;
            sqlSession.close();
        }
        return authors;
    }

    public void updateImage(int id) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Iauthor iauthor = sqlSession.getMapper(Iauthor.class);
            iauthor.updateImage(id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            assert sqlSession != null;
            sqlSession.close();
        }

    }

    public List<File> list(int id) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        List<File> files = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            IFile iFile = sqlSession.getMapper(IFile.class);
             files =  iFile.list(id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
        return files;
    }

    public void realUpdate(File file) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            IFile iFile = sqlSession.getMapper(IFile.class);
            iFile.realUpdate(file);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

    public void addComment(Comment comment){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            IComment iComment = sqlSession.getMapper(IComment.class);
            iComment.addComment(comment);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

    public List<Comment> selectComment(int file_id) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        List<Comment> comments = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            IComment iComment =  sqlSession.getMapper(IComment.class);
            comments = iComment.selectComment(file_id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert sqlSession != null;
            sqlSession.close();
        }
        return comments;
    }

}
