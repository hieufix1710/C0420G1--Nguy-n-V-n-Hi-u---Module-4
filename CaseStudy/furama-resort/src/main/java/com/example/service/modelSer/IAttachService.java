package com.example.service.modelSer;


import com.example.entity.model.AttachService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAttachService {

    Page<AttachService> findAllAttachService (Pageable pageable, String search);
    void saveAttachService(AttachService contract);
    void deleteAttachService(Long id);
    AttachService findById(Long id);

    List<AttachService> findAllAttachService();
}
