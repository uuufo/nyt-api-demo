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

    @GetMapping("/")
    public String home(Model model) {
        articleService.getMostPopular(model);
        return "index";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @PostMapping("/search")
    public String getSearchResults(@RequestParam String searchText, Model model) {
        articleService.getSearchResults(model, searchText);
        model.addAttribute("searchText", searchText);
        return "search_results";
    }
}
