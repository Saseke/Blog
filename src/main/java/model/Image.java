package model;

/**
 * 控制主体
 */
public class Image {
    public Image() {
    }

    private int id;
    private String path;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public Image(int id, String path, String name) {

        this.id = id;
        this.path = path;
        this.name = name;
    }
}
