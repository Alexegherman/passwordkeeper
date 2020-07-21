package eu.accesa.passwordkeeper.model;

import io.swagger.annotations.ApiModel;

import java.time.OffsetDateTime;

@ApiModel("Password request model")
public class Password {

    private String username;
    private String password;
    private OffsetDateTime activeFrom;
    private OffsetDateTime activeTo;

    public Password(String username, String password, OffsetDateTime activeFrom, OffsetDateTime activeTo) {
        this.username = username;
        this.password = password;
        this.activeFrom = activeFrom;
        this.activeTo = activeTo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public OffsetDateTime getActiveFrom() {
        return activeFrom;
    }

    public void setActiveFrom(OffsetDateTime activeFrom) {
        this.activeFrom = activeFrom;
    }

    public OffsetDateTime getActiveTo() {
        return activeTo;
    }

    public void setActiveTo(OffsetDateTime activeTo) {
        this.activeTo = activeTo;
    }
}
