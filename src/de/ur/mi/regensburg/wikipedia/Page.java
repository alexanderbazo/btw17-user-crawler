package de.ur.mi.regensburg.wikipedia;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Page {

    public static final String BASE_URL_WIKI_DE = "https://de.wikipedia.org/wiki/";
    public static final String BASE_URL_WIKI_EN = "https://en.wikipedia.org/wiki/";
    public static final String BASE_URL_BUNDESWAHLLEITER = "https://bundeswahlleiter.de/bundestagswahlen/2017/wahlbewerber/bund-99/";

    private String page;
    private Language language;
    private boolean isFromWikipedia;
    private boolean isBundeswahlLeiter;
    private final String contentSelector;
    private String url;
    private boolean loaded = false;
    private Document document;
    private Elements content;

    public Page(String page, Language language, boolean isFromWikipedia, boolean isBundeswahlLeiter, String contentSelector) {

        this.page = page;
        this.language = language;
        this.contentSelector = contentSelector;
        this.isFromWikipedia = isFromWikipedia;
        this.isBundeswahlLeiter = isBundeswahlLeiter;
        initUrl();
    }

    private void initUrl() {
        if(isFromWikipedia) {
            switch (language) {
                case DE:
                    url = BASE_URL_WIKI_DE + page;
                    break;
                case EN:
                    url = BASE_URL_WIKI_EN + page;
                    break;
                default:
                    break;
            }
        }
        if(isBundeswahlLeiter){
            url = BASE_URL_BUNDESWAHLLEITER + page;
        }
    }

    public boolean isLoaded() {
        return loaded;
    }

    public Document getDocument() {
        return document;
    }

    public Elements getContentElements() {
        return content;
    }

    public void fetchDocument() {
        try {
            document = Jsoup.connect(url).get();
            content = document.select(contentSelector);
            loaded = true;
        } catch (IOException e) {
            e.printStackTrace();
            loaded = false;
        }
    }

}
