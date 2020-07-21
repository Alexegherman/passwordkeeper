package eu.accesa.passwordkeeper.model;

import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel("Application request model")
public class Application {

    private String name;
    private String url;
    private List<Password> passwords;

    public Application(String name, String url, List<Password> passwords) {
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

    public List<Password> getPasswords() {
        return passwords;
    }

    public void setPasswords(List<Password> passwords) {
        this.passwords = passwords;
    }
}

