package model;

import java.io.Serializable;

/**
 * Created by Yoke on 2017/8/7.
 */
public class Page<T> implements Serializable {
    private int pageSize; //每页显示多少条记录
    private int currentPage;  //当前第几页
    private int totalRecord; //一共多少条记录
    private int totalPage;   //一共有多少页记录

    public Page() {
    }

    public Page(int pageSize, int currentPage, int totalRecord, int totalPage) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }


}
