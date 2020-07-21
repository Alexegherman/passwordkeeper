package eu.accesa.passwordkeeper.service.impl;

import eu.accesa.passwordkeeper.model.Password;
import eu.accesa.passwordkeeper.service.PasswordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordServiceImpl implements PasswordService {

    @Override public Password createPassword(String applicationName, Password password) {
        return null;
    }

    @Override public List<Password> getPasswordsByApplication(String applicationName, Boolean active) {
        return null;
    }

    @Override public Password updatePassword(String applicationName, Password password) {
        return null;
    }
}
