package com.example.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table (name = "note")
public class Note implements Validator {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;
    @NotEmpty
    private String content;


    @ManyToOne
    @JoinColumn (name = "note_type_id")
    private NoteType noteType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NoteType getNoteType() {
        return noteType;
    }

    public void setNoteType(NoteType noteType) {
        this.noteType = noteType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Note.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Note note= (Note) target;

        if (note.title.isEmpty()){
            errors.rejectValue("title","title.isEmpty");
        }
        if (note.content.isEmpty()){
            errors.rejectValue("content","content.isEmpty");
        }

    }
}
