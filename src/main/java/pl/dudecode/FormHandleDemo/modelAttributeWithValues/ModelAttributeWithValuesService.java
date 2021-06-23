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
    private final Set<Email> dbEmailSet;

    public ModelAttributeWithValuesService() {
        dbEmailSet = initDbEmailSet();
    }

    public Set<Email> findAllEmails() {
        return dbEmailSet;
    }

    public Email editEmail(Email email) {
        Email editedEmail = findEmailById(email.getId());
        if (editedEmail != null) {
            editedEmail.setLabel(email.getLabel());
            editedEmail.setEmail(email.getEmail());
            editedEmail.setActive(email.isActive());
        }
        return editedEmail;
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
