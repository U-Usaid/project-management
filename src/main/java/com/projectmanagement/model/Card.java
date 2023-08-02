package com.projectmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Card {
    @Id

    public Integer id;
    public String title;
    public String description;
    public int section;

}
