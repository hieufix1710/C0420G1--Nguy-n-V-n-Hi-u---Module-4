package com.codegym.pictureofday.service;

import com.codegym.pictureofday.model.Comment;
import com.codegym.pictureofday.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentSerImp implements CommentSer {
    @Autowired
    private CommentRepo commentRepo;
    @Override
    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    @Override
    public void delete(Long id) {
            commentRepo.deleteById(id);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Comment comment) {
        comment.setTotalLike(comment.getTotalLike()+1);
       commentRepo.save(comment);
    }

    @Override
    public void update(Long id, Comment comment) {
          commentRepo.findById(id).orElse(null).setMark(comment.getMark());
          commentRepo.findById(id).orElse(null).setAuthor(comment.getAuthor());
          commentRepo.findById(id).orElse(null).setFeedback(comment.getFeedback());
          commentRepo.findById(id).orElse(null).setTotalLike(comment.getTotalLike()+1);
    }
}
