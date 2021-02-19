package dev.jlarsen.nytapidemo.controllers;

import dev.jlarsen.nytapidemo.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * Retrieves List<Article> of "Most Popular" articles from service and attaches them to the model
     */
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute(articleService.getMostPopular());
        return "index";
    }

    /**
     * Return simple search form
     */
    @GetMapping("/search")
    public String search() {
        return "search";
    }

    /**
     * Retrieves List<Doc> of search results from service and attaches them to the model
     */
    @PostMapping("/search")
    public String getSearchResults(@RequestParam String searchText, Model model) {
        model.addAttribute(articleService.getSearchResults(searchText));
        model.addAttribute("searchText", searchText);
        return "search_results";
    }
}
