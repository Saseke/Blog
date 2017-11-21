package model;

import java.util.Date;

/**
 * 控制主体
 */
public class Comment {
    private int id;
    private int file_id;
    private int author_id;
    private String matter;
    private Date date;

    public Comment() {
    }

    public Date getDate() {
        return date;

    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Comment(int id, int file_id, int author_id, String matter, Date date) {

        this.id = id;
        this.file_id = file_id;
        this.author_id = author_id;
        this.matter = matter;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public Comment(int file_id, int author_id, String matter) {

        this.file_id = file_id;
        this.author_id = author_id;
        this.matter = matter;
    }

    public Comment(int id, int file_id, int author_id, String matter) {

        this.id = id;
        this.file_id = file_id;
        this.author_id = author_id;
        this.matter = matter;
    }
}
