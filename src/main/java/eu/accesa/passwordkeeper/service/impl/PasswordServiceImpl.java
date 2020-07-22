package eu.accesa.passwordkeeper.service.impl;

import eu.accesa.passwordkeeper.model.Password;
import eu.accesa.passwordkeeper.model.PasswordRequest;
import eu.accesa.passwordkeeper.service.PasswordService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class PasswordServiceImpl implements PasswordService {

    @Override public List<Password> getPasswordsByApplication(String applicationName, Boolean active) {
        return null;
    }

    @Override public Password createPassword(String applicationName, PasswordRequest passwordRequest) {
        return new Password("alexg", "strongpassword", OffsetDateTime.now(), OffsetDateTime.now());
    }

    @Override public Password updatePassword(String applicationName, PasswordRequest passwordRequest) {
        return new Password("alexg", "strongpassword", OffsetDateTime.now(), OffsetDateTime.now());
    }

}
