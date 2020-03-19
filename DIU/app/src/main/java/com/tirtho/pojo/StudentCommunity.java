package com.tirtho.pojo;

public class StudentCommunity {
    private int logo;
    private String name;

    public StudentCommunity(int logo, String name) {
        this.logo = logo;
        this.name = name;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
