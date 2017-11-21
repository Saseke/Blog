package model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Yoke on 2017/8/1.
 */
public class File implements Serializable {
   private int id;
   private String title;
   private String content;
   private Date date;
   private int time;
    private int author_id;

    public File(String title, String content, Date date, int time, int author_id) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.time = time;
        this.author_id = author_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public File(int id, String title, String content, Date date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public File(int id, String title, String content, Date date, int time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.time = time;
    }


    public File(String title, String content, Date date) {

        this.title = title;
        this.content = content;
        this.date = date;
    }

    public File() {
    }

    public File(String title, String content, Date date, int time) {

        this.title = title;
        this.content = content;
        this.date = date;
        this.time = time;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
