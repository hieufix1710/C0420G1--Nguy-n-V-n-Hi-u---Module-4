package com.example.service.modelSer;


import com.example.entity.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContract {
    Page<Contract> findAllContract (Pageable pageable, String search);
    void saveContract(Contract contract);
    void deleteContract(Long id);
    Contract findById(Long id);

    List<Contract> findAllContract();
}
