package eu.accesa.passwordkeeper.model;

import java.util.Set;

public class ApplicationRequest {
    private final String name;
    private final String url;
    private final Set<PasswordRequest> passwords;

    public ApplicationRequest(String name,
                              String url,
                              Set<PasswordRequest> passwords) {
        this.name = name;
        this.url = url;
        this.passwords = passwords;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Set<PasswordRequest> getPasswords() {
        return passwords;
    }
}
