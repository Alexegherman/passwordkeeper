package eu.accesa.passwordkeeper.service;

import eu.accesa.passwordkeeper.model.Password;
import eu.accesa.passwordkeeper.model.PasswordRequest;

import java.util.List;

public interface PasswordService {
    List<Password> getPasswordsByApplication(String applicationName, Boolean active);

    Password createPassword(String applicationName, PasswordRequest passwordRequest);

    Password updatePassword(String applicationName, PasswordRequest passwordRequest);
}
