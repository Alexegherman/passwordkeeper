package eu.accesa.passwordkeeper.service;

import eu.accesa.passwordkeeper.model.Password;

import java.util.List;

public interface PasswordService {

    Password createPassword(String applicationName, Password password);

    List<Password> getPasswordsByApplication(String applicationName, Boolean active);

    Password updatePassword(String applicationName, Password password);
}
