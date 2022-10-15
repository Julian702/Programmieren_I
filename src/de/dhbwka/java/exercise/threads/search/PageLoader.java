package de.dhbwka.java.exercise.threads.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class PageLoader implements Runnable {

    private String url;
    private String pageContent;

    public PageLoader(String url) {
        this.url = url;
        this.pageContent = null;
    }

    @Override
    public void run() {
        this.pageContent = getStringContentFromUrl(this.url, "UTF-8");
    }

    public boolean pageLoaded() {
        return this.pageContent != null;
    }

    public String getUrl() {
        return url;
    }
    public String getPageContent() {
        return pageContent;
    }

    public static String getStringContentFromUrl(String url, String encoding) {
        StringBuilder buffer = new StringBuilder();
        String line = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream(), encoding))) {
            while ((line = br.readLine()) != null) {
                buffer.append(line).append(System.lineSeparator());
            }
        } catch (IOException ex) {

        }
        return buffer.toString();
    }
}
