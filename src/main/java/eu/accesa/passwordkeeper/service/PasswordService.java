package eu.accesa.passwordkeeper.service;

import eu.accesa.passwordkeeper.model.Password;
import eu.accesa.passwordkeeper.model.PasswordRequest;

import java.util.List;
import java.util.Set;

public interface PasswordService {
    Password createPassword(String applicationName, PasswordRequest passwordRequest);

    Set<Password> getPasswordsByApplication(String applicationName, boolean active);

    Password updatePassword(String applicationName,String userName, PasswordRequest password);
}
