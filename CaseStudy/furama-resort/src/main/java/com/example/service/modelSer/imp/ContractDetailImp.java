package com.example.service.modelSer.imp;


import com.example.entity.model.DetailContract;
import com.example.repository.modelRepo.ContractDetailRepo;
import com.example.service.modelSer.IContractDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailImp implements IContractDetails {

    @Autowired
    private ContractDetailRepo contractDetailRepo;

    @Override
    public Page<DetailContract> findAllDetailContract(Pageable pageable, String search) {
        String temp="%"+search+"%";
        if ("".equals(search)){
            return contractDetailRepo.findAll(pageable,search);
        }
        return contractDetailRepo.findAllBySearch(pageable, search);
    }

    @Override
    public void saveDetailContract(DetailContract contract) {
             contractDetailRepo.saveAndFlush(contract);
    }

    @Override
    public void deleteDetailContract(Long id) {
          contractDetailRepo.deleteById(id);
    }

    @Override
    public DetailContract findById(Long id) {
        return contractDetailRepo.findById(id).orElse(null);
    }

    @Override
    public List<DetailContract> findAllDetailContract() {
        return contractDetailRepo.findAll();
    }
}
