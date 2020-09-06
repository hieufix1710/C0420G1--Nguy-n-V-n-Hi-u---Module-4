package com.codegym.pictureofday.repository;

import com.codegym.pictureofday.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Long> {

    @Query ("select count (c.totalLike) from Comment  c")
    int countTotalLike();
}
