package repository;

import model.Languages;
import model.MailBox;

import java.util.ArrayList;
import java.util.List;

public class MailBoxRepo implements IMailBoxRepo {
    private static List<MailBox> mailBoxList = new ArrayList<>();
    private static List<Languages> languagesList = new ArrayList<>();

    static {
        mailBoxList.add(new MailBox(1, 1, 5, 1, "Thor King Asgard"));
        mailBoxList.add(new MailBox(2, 2, 10, 0, "Jack King Oscar"));
        mailBoxList.add(new MailBox(1, 1, 5, 1, "Jhin Member Asgard"));
    }

    static {
        languagesList.add(new Languages(1, "English"));
        languagesList.add(new Languages(2, "Vietnamese"));
        languagesList.add(new Languages(3, "Chinese"));
        languagesList.add(new Languages(4, "Japanese"));
    }

    @Override
    public List<MailBox> findAll() {
        return mailBoxList;
    }

    @Override
    public void save(MailBox mailBox) {
        mailBoxList.add(mailBox);
    }

    @Override
    public void delete(int id) {
        mailBoxList.remove(id);
    }

    @Override
    public void edit(int id, MailBox mailBox) {
        mailBoxList.get(id).setIdLanguage(mailBox.getIdLanguage());
        mailBoxList.get(id).setPageSize(mailBox.getPageSize());
        mailBoxList.get(id).setSpamFilter(mailBox.getSpamFilter());
        mailBoxList.get(id).setSignature(mailBox.getSignature());
    }

    @Override
    public List<Languages> typeLanguages() {
        return languagesList;
    }

    @Override
    public MailBox findById(int id) {
        if (id>mailBoxList.size()){
            return mailBoxList.get(mailBoxList.size()-1);
        }
        return mailBoxList.get(id);
    }
}
