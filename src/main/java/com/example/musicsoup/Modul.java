package com.example.musicsoup;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Modul {
    String songName;
    String result;

    public void poluchenieDannyh(String url) throws IOException {

        Document doc = Jsoup.connect(url+songName).get();
        Elements newsHeadlines = doc.select(".song-item a");
        if(newsHeadlines.isEmpty()) {
            songName="Ничего не найдено!";
        }else{
        for (Element r : newsHeadlines) {
            String songTitle=r.getElementsByClass("title").text();
            String artist=r.getElementsByClass("artist").text();
            result=songTitle+" - "+artist+"\n";
            }
        }
    }
}
