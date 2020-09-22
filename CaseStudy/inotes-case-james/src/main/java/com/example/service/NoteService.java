package com.example.service;

import com.example.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface NoteService {
    Page<Note> findAll(Pageable pageable,String search);
    void save(Note note);
    void delete(Long id);
    Note findById(Long id);
    void update(Note note);
}
