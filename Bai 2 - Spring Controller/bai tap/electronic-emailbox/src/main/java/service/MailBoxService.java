package service;

import model.Languages;
import model.MailBox;
import repository.IMailBoxRepo;
import repository.MailBoxRepo;

import java.util.List;

public class MailBoxService implements IMailBoxService {
    IMailBoxRepo mailBoxRepo= new MailBoxRepo();
    @Override
    public List<MailBox> findAll() {
        return mailBoxRepo.findAll();
    }

    @Override
    public void save(MailBox mailBox) {
          mailBoxRepo.save(mailBox);
    }

    @Override
    public void delete(int id) {
        mailBoxRepo.delete(id);
    }

    @Override
    public void edit(int id, MailBox mailBox) {
          mailBoxRepo.edit(id,mailBox);
    }

    @Override
    public List<Languages> typeLanguages() {
        return mailBoxRepo.typeLanguages();
    }

    @Override
    public MailBox findById(int id) {
        return mailBoxRepo.findById(id);
    }
}
