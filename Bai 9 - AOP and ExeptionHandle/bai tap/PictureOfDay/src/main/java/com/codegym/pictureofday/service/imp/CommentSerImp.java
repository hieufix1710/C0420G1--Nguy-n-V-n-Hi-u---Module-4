package com.codegym.pictureofday.service.imp;

import com.codegym.pictureofday.model.Comment;
import com.codegym.pictureofday.repository.CommentRepo;
import com.codegym.pictureofday.service.CommentSer;
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
       commentRepo.saveAndFlush(comment);
    }

    @Override
    public void update(Long id, Comment comment) {

    }

    @Override
    public int countTotalLike() {
        return commentRepo.countTotalLike();
    }
}
