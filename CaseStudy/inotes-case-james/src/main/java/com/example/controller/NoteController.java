package com.example.controller;

import com.example.model.Note;
import com.example.service.NoteService;
import com.example.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoteController {
    @Autowired
    private NoteTypeService noteTypeService;
    @Autowired
    private NoteService noteService;

    @GetMapping("/create-new-note")
    public String createForm(Model model) {
        model.addAttribute("note", new Note());
        model.addAttribute("noteTypes", noteTypeService.findAll());
        return "new-note-form";
    }

    @GetMapping("/list-notes")
    public String showList(Model model, Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search) {

        model.addAttribute("notes", noteService.findAll(pageable,search));
        model.addAttribute("search", search);
        return "list-notes";
    }

    @PostMapping("/createNewNote")
    public String createNewNote(@ModelAttribute("note") Note note, Model model) {
        noteService.save(note);
        model.addAttribute("message", "Created !");
        return "new-note-form";

    }

    @GetMapping("/search")
    public String search(Model model, Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search
    ) {
        model.addAttribute("notes", noteService.findAll(pageable, search));
        model.addAttribute("search", search);
        return "list-notes";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam ("id") Long id,Model model){
        noteService.delete(id);
        model.addAttribute("message","Deleted !");

        return "redirect:/list-notes";

    }

    @GetMapping ("/edit")
    public String edit(@RequestParam ("id") long id,Model model){
        Note note=noteService.findById(id);
        model.addAttribute("note",note);
        model.addAttribute("noteType",noteTypeService.findAll());
        return "edit-form";
    }
    @PostMapping ("/update")
    public String update(@ModelAttribute ("note") Note note,Model model){
        noteService.save(note);
        model.addAttribute("message","Update success !");
        return "edit-form";
    }
}
