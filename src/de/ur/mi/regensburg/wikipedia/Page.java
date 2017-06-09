package de.ur.mi.regensburg.wikipedia;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Page {

    public static final String BASE_URL_DE = "https://de.wikipedia.org/wiki/";
    public static final String BASE_URL_EN = "https://en.wikipedia.org/wiki/";

    private String page;
    private Language language;
    private final String contentSelector;
    private String url;
    private boolean loaded = false;
    private Document document;
    private Elements content;

    public Page(String page, Language language, String contentSelector) {
        this.page = page;
        this.language = language;
        this.contentSelector = contentSelector;
        initUrl();
    }

    private void initUrl() {
        switch (language) {
            case DE:
                url = BASE_URL_DE + page;
                break;
            case EN:
                url = BASE_URL_EN + page;
                break;
            default:
                break;
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
