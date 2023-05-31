package com.javapandeng.po;

import java.io.Serializable;

public class ItemCategory implements Serializable {
    private int id;
    private String name;
    private Integer pid;
    private int isDelete;

    public ItemCategory(int id, String name, Integer pid, int isDelete) {
        this.id = id;
        this.name = name;
        this.pid = pid;
        this.isDelete = isDelete;
    }

    public ItemCategory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "ItemCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid='" + pid + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
