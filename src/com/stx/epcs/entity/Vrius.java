package com.stx.epcs.entity;

/**
 * Created by Administrator on 2020/3/18 0018.
 */
public class Vrius {
    private long id;
    private String name;
    private String descrip;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    @Override
    public String toString() {
        return id +"\t\t" + name +"\t\t" + descrip +"\r" ;
    }
}
