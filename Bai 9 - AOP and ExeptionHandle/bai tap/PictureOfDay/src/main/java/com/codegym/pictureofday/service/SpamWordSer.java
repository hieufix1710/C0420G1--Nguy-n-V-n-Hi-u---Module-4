package com.codegym.pictureofday.service;

import com.codegym.pictureofday.model.Comment;
import com.codegym.pictureofday.model.SpamWord;

import java.util.List;

public interface SpamWordSer {
    List<SpamWord> findAll();
    boolean checkSpam(Comment comment);
}
