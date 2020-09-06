package com.codegym.pictureofday.repository;

import com.codegym.pictureofday.model.SpamWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpamWordRepo extends JpaRepository<SpamWord,Integer> {
}
