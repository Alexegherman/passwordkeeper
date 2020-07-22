package eu.accesa.passwordkeeper.model;

import java.util.Set;

public class ApplicationModel {

    private String name;
    private String url;
    private Set<Password> passwords;

    public ApplicationModel(String name, String url, Set<Password> passwords) {
        this.name = name;
        this.url = url;
        this.passwords = passwords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Password> getPasswords() {
        return passwords;
    }

    public void setPasswords(Set<Password> passwords) {
        this.passwords = passwords;
    }
}
