package dev.jlarsen.nytapidemo.services;

import dev.jlarsen.nytapidemo.models.nytmostpopular.Article;
import dev.jlarsen.nytapidemo.models.nytmostpopular.Media;
import dev.jlarsen.nytapidemo.models.nytmostpopular.NytResponse;
import dev.jlarsen.nytapidemo.models.nytsearch.Doc;
import dev.jlarsen.nytapidemo.models.nytsearch.Headline;
import dev.jlarsen.nytapidemo.models.nytsearch.NytSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    /**
     * Pull our values from applications.properties
     */
    @Value("${api_key}")
    private String apikey;

    @Value("${mostPopularUrl}")
    private String mostPopularUrl;

    @Value("${searchUrl}")
    private String searchUrl;

    @Autowired
    RestTemplate restTemplate;

    /**
     * Query NYT "Most Popular" API and map response
     * @return List of Articles
     */
    public List<Article> getMostPopular() {
        NytResponse response = null;
        try {
            response = restTemplate.getForObject(mostPopularUrl + "api-key=" + apikey, NytResponse.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        List<Article> articles = new ArrayList<>();
        if (response != null && response.getStatus().equals("OK")) {
            Article[] allArticles = response.getResults();
            for (Article article : allArticles) {
                if (article.getMedia().length > 0) {
                    article.setImageUrl(article.getMedia()[0].getMedia_metadata()[1].getUrl());
                    articles.add(article);
                }
            }
        } else {
            articles.add(new Article("Sorry, having trouble fetching Most Popular.."));
        }
        return articles;
    }

    /**
     * Query NYT Search API and map response
     * @return List of "Docs"
     */
    public List<Doc> getSearchResults(String searchText) {
        NytSearchResponse response = null;
        try {
            response = restTemplate.getForObject(searchUrl + searchText + "&" + "api-key=" + apikey, NytSearchResponse.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        List<Doc> docs = new ArrayList<>();
        if (response != null && response.getStatus().equals("OK")) {
            Doc[] allDocs = response.getResponse().getDocs();
            for (Doc doc : allDocs) {
                if (doc.getMultimedia().length > 0) {
                    for (Media media : doc.getMultimedia()) {
                        if (media.getSubtype().equals("largeHorizontal375")) {
                            doc.setImageUrl("https://www.nytimes.com/" + media.getUrl());
                        }
                    }
                    if (!doc.getNewsDesk().equals(doc.getSection())) {
                        doc.setSection(doc.getNewsDesk() + " " + doc.getSection());
                    }
                    docs.add(doc);
                }
            }
        }  else {
            docs.add(new Doc(new Headline("Sorry, having trouble fetching search results..")));
        }
        return docs;
    }
}
