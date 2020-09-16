package com.example.repository;

import com.example.model.NoteType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteTypeRepository extends JpaRepository<NoteType,Long> {
}
