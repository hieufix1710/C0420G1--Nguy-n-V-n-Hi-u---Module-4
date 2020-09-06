package com.codegym.furamaspringboot.service;

import com.codegym.furamaspringboot.model.Contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAttachService {

    Page<com.codegym.furamaspringboot.model.AttachService> findAllAttachService (Pageable pageable, String search);
    void saveAttachService(com.codegym.furamaspringboot.model.AttachService contract);
    void deleteAttachService(Long id);
    com.codegym.furamaspringboot.model.AttachService findById(Long id);

    List<com.codegym.furamaspringboot.model.AttachService> findAllAttachService();
}
