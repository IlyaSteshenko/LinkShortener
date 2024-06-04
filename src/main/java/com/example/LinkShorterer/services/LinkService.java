package com.example.LinkShorterer.services;

import com.example.LinkShorterer.daos.LinkDAO;
import com.example.LinkShorterer.daos.LinkDAOImpl;
import com.example.LinkShorterer.models.Link;

public class LinkService implements LinkDAO {

    private final LinkDAOImpl linkDAOImpl = new LinkDAOImpl();

    @Override
    public Link findDefaultLinkByShortLink(String shortLink) {
        return linkDAOImpl.findDefaultLinkByShortLink(shortLink);
    }

    @Override
    public void save(Link link) {
        linkDAOImpl.save(link);
    }
}
