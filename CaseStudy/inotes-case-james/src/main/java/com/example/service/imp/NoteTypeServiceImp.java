package com.example.service.imp;

import com.example.model.NoteType;
import com.example.repository.NoteTypeRepository;
import com.example.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteTypeServiceImp implements NoteTypeService {

    @Autowired
    private NoteTypeRepository noteTypeRepository;
    @Override
    public List<NoteType> findAll() {
        return noteTypeRepository.findAll();
    }
}
