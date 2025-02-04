package com.example.LinkShorterer.services;

import com.example.LinkShorterer.beans.SessionFactoryManager;
import com.example.LinkShorterer.models.Link;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Value;

import java.util.Random;

// Сервис для создания короткой ссылки
public class ShortLinkService {

    // Метод для проверки существования URLа
    // Если существует -> true
    // Если не существует -> false
    private static boolean isURlExist(String shortLink) {
        Session session = SessionFactoryManager.getSessionFactory().openSession();
        try {
            session.createQuery("from Link where shortLink=" + "'" + shortLink + "'", Link.class).getResultList().get(0);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    // Метод для создания короткой ссылки
    public static String createShortLink(Link link) {

        char[] alphabet = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890".toCharArray();

        StringBuilder url = new StringBuilder("localhost:8082/");
        Random random = new Random();

        for (int i = 0; i <= 7; i++) {
            url.append(alphabet[random.nextInt(alphabet.length)]);
        }

        if (isURlExist(url.toString())) {
            return createShortLink(link);
        }
        return url.toString();
    }
}
