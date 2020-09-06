package com.codegym.pictureofday.model;

import javax.persistence.*;

@Entity
@Table (name = "spam_word")
public class SpamWord {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String spamWord;

    public SpamWord() {
    }

    public SpamWord(int id, String spamWord) {
        this.id = id;
        this.spamWord = spamWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpamWord() {
        return spamWord;
    }

    public void setSpamWord(String spamWord) {
        this.spamWord = spamWord;
    }
}
