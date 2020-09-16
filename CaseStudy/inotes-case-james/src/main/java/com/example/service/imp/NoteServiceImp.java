package com.example.service.imp;

import com.example.model.Note;
import com.example.repository.NoteRepository;
import com.example.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImp implements NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Override
    public Page<Note> findAll(Pageable pageable,String search) {
        if ("".equals(search)){
            return noteRepository.findAll(pageable,search);
        }
        String temp="%"+search+"%";
        return noteRepository.findAllByNoteType(pageable,temp);
    }

    @Override
    public void save(Note note) {
        noteRepository.saveAndFlush(note);
    }

    @Override
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public Note findById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Note note) {

    }
}
