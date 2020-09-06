package com.codegym.furamaspringboot.service.imp;

import com.codegym.furamaspringboot.model.AttachService;
import com.codegym.furamaspringboot.repository.AttachServiceRepo;
import com.codegym.furamaspringboot.service.IAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImp implements IAttachService {
    @Autowired
    private AttachServiceRepo attachServiceRepo;
    @Override
    public Page<AttachService> findAllAttachService(Pageable pageable, String search) {
        String temp="%"+search+"%";
        if ("".equals(search)){
            return attachServiceRepo.findAll(pageable,search);
        }
        return attachServiceRepo.findAllBySearch(pageable, search);
    }

    @Override
    public void saveAttachService(AttachService contract) {
         attachServiceRepo.saveAndFlush(contract);
    }

    @Override
    public void deleteAttachService(Long id) {
           attachServiceRepo.deleteById(id);
    }

    @Override
    public AttachService findById(Long id) {
        return attachServiceRepo.findById(id).orElse(null);
    }

    @Override
    public List<AttachService> findAllAttachService() {
        return attachServiceRepo.findAll();
    }
}
