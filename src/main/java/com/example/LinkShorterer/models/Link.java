package com.example.LinkShorterer.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Getter
    @Column(name = "defaultLink")
    private String defaultLink;

    @Setter
    @Getter
    @Column(name = "shortLink")
    private String shortLink;

}
