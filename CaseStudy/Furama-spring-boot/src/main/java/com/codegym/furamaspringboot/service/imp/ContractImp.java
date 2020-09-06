package com.codegym.furamaspringboot.service.imp;

import com.codegym.furamaspringboot.model.Contract;
import com.codegym.furamaspringboot.repository.ContractRepo;
import com.codegym.furamaspringboot.service.IContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractImp implements IContract {

    @Autowired
    private ContractRepo contractRepo;
    @Override
    public Page<Contract> findAllContract(Pageable pageable, String search) {
        String temp="%"+search+"%";
        if ("".equals(search)){
            return contractRepo.findAll(pageable,search);
        }
        return contractRepo.findAllBySearch(pageable,temp);
    }

    @Override
    public void saveContract(Contract contract) {
          contractRepo.save(contract);
    }

    @Override
    public void deleteContract(Long id) {
          contractRepo.deleteById(id);
    }

    @Override
    public Contract findById(Long id) {
        return contractRepo.findById(id).orElse(null);
    }

    @Override
    public List<Contract> findAllContract() {
        return contractRepo.findAll();
    }
}
