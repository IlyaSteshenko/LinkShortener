package com.example.LinkShorterer.controllers;

import com.example.LinkShorterer.models.Link;
import com.example.LinkShorterer.services.LinkService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ShortLinkController {

    @GetMapping("/*")
    public RedirectView openShortLink(HttpServletRequest request) {

        LinkService linkService = new LinkService();
        Link link = linkService.findDefaultLinkByShortLink(request.getRequestURL().substring(7));

        return new RedirectView(link.getDefaultLink());
    }
}
