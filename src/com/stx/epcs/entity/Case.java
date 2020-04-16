package com.stx.epcs.entity;

/**
 * 病毒类
 */
public class Case {
    // 抽象到我们系统里面，理出一下主线；
    private long id;

    private String name;

    private String province;

    private int status;

    private Vrius vrius;

    public Vrius getVrius() {
        return vrius;
    }

    public void setVrius(Vrius vrius) {
        this.vrius = vrius;
    }

    public Case() {
        this.setStatus(1);
    }

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
