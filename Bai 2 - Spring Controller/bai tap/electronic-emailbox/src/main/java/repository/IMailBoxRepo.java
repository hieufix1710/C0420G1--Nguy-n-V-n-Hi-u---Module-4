package repository;

import model.Languages;
import model.MailBox;

import java.util.List;

public interface IMailBoxRepo {
    List<MailBox> findAll ();

    void save (MailBox mailBox);
    void delete(int id);
    void edit (int id,MailBox mailBox);
    List<Languages> typeLanguages ();
    MailBox findById(int id);
}
