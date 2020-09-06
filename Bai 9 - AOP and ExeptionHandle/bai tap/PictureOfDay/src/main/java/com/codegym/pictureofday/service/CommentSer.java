package com.codegym.pictureofday.service;

import com.codegym.pictureofday.model.Comment;

import java.util.List;

public interface CommentSer {
    List<Comment> findAll();
    void delete(Long id);
    Comment findById(Long id);
    void save(Comment comment);
    void update(Long id,Comment comment);
    int countTotalLike();

}
