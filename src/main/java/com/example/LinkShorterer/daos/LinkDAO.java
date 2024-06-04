package com.example.LinkShorterer.daos;

import com.example.LinkShorterer.models.Link;

public interface LinkDAO {

    Link findDefaultLinkByShortLink(String shortLink);
    void save(Link link);
}
