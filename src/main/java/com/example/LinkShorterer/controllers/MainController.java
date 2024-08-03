package com.example.LinkShorterer.controllers;

import com.example.LinkShorterer.models.Link;
import com.example.LinkShorterer.services.LinkService;
import com.example.LinkShorterer.services.ShortLinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    // Главная страница
    @GetMapping("/new")
    public String mainPage(Model model) {
        model.addAttribute("link", new Link());
        return "main_page";
    }

    // Создание короткой ссылки
    @PostMapping("/new")
    public String createNewLink(
            @ModelAttribute(name = "link") Link defaultLink,
            Model model
    ) {
        LinkService linkService = new LinkService();
        String shortLink = ShortLinkService.createShortLink(defaultLink);

        Link newLink = new Link();
        newLink.setDefaultLink(defaultLink.getDefaultLink());
        newLink.setShortLink(shortLink);

        linkService.save(newLink);

        model.addAttribute("shortLink", shortLink);
        return "success";
    }
}
