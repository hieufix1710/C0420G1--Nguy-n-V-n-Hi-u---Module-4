package com.example.repository;

import com.example.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NoteRepository extends JpaRepository<Note,Long> {

    @Query ("select c from Note c where  c.title like :search ")
    Page<Note> findAllByNoteType(Pageable pageable,String search);

    @Query ("select c from Note c ")
    Page<Note> findAll(Pageable pageable,String search);
}
