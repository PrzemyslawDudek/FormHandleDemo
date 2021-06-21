package pl.dudecode.FormHandleDemo.modelAttributeWithValues;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ModelAttributeWithValuesService {

    private static Set<Email> initDbEmailSet() {
        Set<Email> dbEmailSet = new HashSet<>();
        for (int i = 1; i < 3; i++) {
            Email email = new Email();
            email.setId(i);
            email.setLabel("email_" + i);
            email.setEmail("email_" + i + "@example.com");
            email.setActive(true);
            dbEmailSet.add(email);
        }
        return dbEmailSet;
    }
    private final static Set<Email> dbEmailSet = initDbEmailSet();


    public Set<Email> findAllEmails() {
        return dbEmailSet;
    }

    public Email editEmail(EmailDTO emailDTO) {
        Email email = findEmailById(emailDTO.getId());
        if (email != null) {
            email.setLabel(emailDTO.getLabel());
            email.setEmail(emailDTO.getEmail());
            email.setActive(emailDTO.isActive());
        }
        return email;
    }

    private Email findEmailById(long id) {
        for (Email e : dbEmailSet) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
