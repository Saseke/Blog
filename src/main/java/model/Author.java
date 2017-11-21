package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Yoke on 2017/8/12.
 */
public class Author {
    private int id;
    private String username;
    private String password;
    private String description;
    private Date date;
    private int image = 0;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Author(String username, String password, String description, Date date, int image) {
        this.username = username;
        this.password = password;
        this.description = description;
        this.date = date;
        this.image = image;
    }

    public Author(String username, String password, String description, Date date) {
        this.username = username;
        this.password = password;
        this.description = description;
        this.date = date;

    }

    private List<File> files = new ArrayList<File>();

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public Author() {
    }

    public Author(int id, String username, String password, String description, Date date) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.description = description;
        this.date = date;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
