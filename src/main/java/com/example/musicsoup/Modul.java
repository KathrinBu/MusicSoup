package com.example.musicsoup;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Modul {
    String songName;
    String result;

    List<String> playlist=new ArrayList<>();
    ObservableList<Header> observableList= FXCollections.observableArrayList();

    public void poluchenieDannyh(String url) throws IOException {
        observableList.clear();
        playlist.clear();
        Document doc = Jsoup.connect(url+songName).get();
        Elements headlines = doc.select(".song-item a");
//    Elements time=doc.getElementsByTag("div");
//        System.out.println(time.get(5));
//        Elements time=doc.select("[\\d\\d:\\d\\d]");
//        System.out.println(time.text());
        for (Element r : headlines) {
            String songTitle=r.ownText();
            String artist=r.absUrl("href");
            if(songTitle.isEmpty()){
                songName="none :((";
            }
            else {
            result=songTitle+" - "+artist+"\n";
            playlist.add(result);
            observableList.add(new Header(songTitle,artist));
         //   System.out.println(result);
            }}
        }
    }

