package dev.jlarsen.nytapidemo.services;

import dev.jlarsen.nytapidemo.models.nytmostpopular.Article;
import dev.jlarsen.nytapidemo.models.nytmostpopular.Media;
import dev.jlarsen.nytapidemo.models.nytmostpopular.NytResponse;
import dev.jlarsen.nytapidemo.models.nytsearch.Doc;
import dev.jlarsen.nytapidemo.models.nytsearch.NytSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    private final String mostPopularUrl = "https://api.nytimes.com/svc/mostpopular/v2/viewed/1.json?";
    private final String searchUrl = "https://api.nytimes.com/svc/search/v2/articlesearch.json?q=";
    private final String apikey = "$api_key;";

    @Autowired
    RestTemplate restTemplate;

    public void getMostPopular(Model model) {
        NytResponse response = null;
        try {
            response = restTemplate.getForObject(mostPopularUrl + apikey, NytResponse.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if (response != null && response.getStatus().equals("OK")) {
            Article[] allArticles = response.getResults();
            List<Article> articles = new ArrayList<>();
            for (Article article : allArticles) {
                if (article.getMedia().length > 0) {
                    article.setImageUrl(article.getMedia()[0].getMedia_metadata()[1].getUrl());
                    articles.add(article);
                }
            }
            model.addAttribute(articles);
        }
    }

    public void getSearchResults(Model model, String searchText) {
        NytSearchResponse response = null;
        try {
            response = restTemplate.getForObject(searchUrl + searchText + "&" + apikey, NytSearchResponse.class);
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
        }
        if (response != null && response.getStatus().equals("OK")) {
            Doc[] allDocs = response.getResponse().getDocs();
            List<Doc> docs = new ArrayList<>();
            for (Doc doc : allDocs) {
                if (doc.getMultimedia().length > 0) {
                    for (Media media : doc.getMultimedia()) {
                        if (media.getSubtype().equals("largeHorizontal375")) {
                            doc.setImageUrl("https://www.nytimes.com/" + media.getUrl());
                        }
                    }
                    if (doc.getSubsection() != null) {
                        doc.setSection(doc.getSection() + " " + doc.getSubsection());
                    }
                    docs.add(doc);
                }
            }
            model.addAttribute(docs);
        }
    }
}
