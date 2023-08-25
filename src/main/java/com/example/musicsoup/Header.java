package com.example.musicsoup;

public class Header {
    String title;
    String adress;

    @Override
    public String toString() {
        return "Header{" +
                "title='" + title + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Header(String title, String adress) {
        this.title = title;
        this.adress = adress;
    }
}
