package de.dhbwka.java.exercise.threads.search;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchEngine {

    private final int NTHREADS = 10;
    private List<PageLoader> pageLoader = new ArrayList<>();
    
    private static final String[] URLs = {
        "https://www.tagesschau.de",
        "https://www.sueddeutsche.de",
        "https://www.spiegel.de",
        "https://www.kit.edu"
    };

    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.loadPages(URLs);
    }

    private void loadPages(String... urls){

        ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);
        for (String url : urls) {
            PageLoader pageLoader = new PageLoader(url);
            this.pageLoader.add(pageLoader);
            exec.submit(pageLoader);
            System.out.println("Gestartet: " + url);
        }
        exec.shutdown();
        while(!pageLoader.isEmpty()){
            for (PageLoader p : pageLoader) {
                if(p.pageLoaded()){
                    System.out.println("Loaded: " + p.getUrl());
                    System.out.println("Content: " + p.getPageContent().substring(0,40));
                    this.pageLoader.remove(p);
                    break;
                }
            }
        }
    }
}