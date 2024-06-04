package com.example.LinkShorterer.daos;

import com.example.LinkShorterer.beans.SessionFactoryManager;
import com.example.LinkShorterer.models.Link;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LinkDAOImpl implements LinkDAO {

    private final Session session = SessionFactoryManager.getSessionFactory().openSession();

    @Override
    public Link findDefaultLinkByShortLink(String shortLink) {
        List<Link> defaultLink = session.createQuery("from Link where shortLink=" + "'" + shortLink + "'", Link.class).getResultList();
        return defaultLink.get(0);
    }

    @Override
    public void save(Link link) {
        Transaction transaction = session.beginTransaction();
        session.save(link);
        transaction.commit();
        session.close();
    }
}
