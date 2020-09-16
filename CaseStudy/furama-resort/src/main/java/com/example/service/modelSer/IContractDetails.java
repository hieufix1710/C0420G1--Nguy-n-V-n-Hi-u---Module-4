package com.example.service.modelSer;


import com.example.entity.model.DetailContract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetails {

    Page<DetailContract> findAllDetailContract (Pageable pageable, String search);
    void saveDetailContract(DetailContract contract);
    void deleteDetailContract(Long id);
    DetailContract findById(Long id);

    List<DetailContract> findAllDetailContract();
}
