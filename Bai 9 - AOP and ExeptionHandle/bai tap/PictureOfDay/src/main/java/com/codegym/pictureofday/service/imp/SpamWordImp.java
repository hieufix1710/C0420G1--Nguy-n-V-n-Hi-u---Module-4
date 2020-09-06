package com.codegym.pictureofday.service.imp;

import com.codegym.pictureofday.model.Comment;
import com.codegym.pictureofday.model.SpamWord;
import com.codegym.pictureofday.repository.SpamWordRepo;
import com.codegym.pictureofday.service.SpamWordSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpamWordImp  implements SpamWordSer {
    @Autowired
    private SpamWordRepo spamWordRepo;
    @Override
    public List<SpamWord> findAll() {
        return spamWordRepo.findAll();
    }

    @Override
    public boolean checkSpam(Comment comment) {
        boolean check=true;
        for (SpamWord s :
                this.spamWordRepo.findAll()) {
            if (comment.getFeedback().equals(s.getSpamWord())) {
                check = false;
            }
            if (comment.getFeedback().toLowerCase().contains(s.getSpamWord())){
                check=false;
            }
        }
        return check;
    }
}
