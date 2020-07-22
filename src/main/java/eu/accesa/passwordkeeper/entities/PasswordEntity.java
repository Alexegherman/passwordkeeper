package eu.accesa.passwordkeeper.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "password")
public class PasswordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column
    private String password;

    @Column(name = "active_from")
    private OffsetDateTime activeFrom;

    @Column(name = "active_to")
    private OffsetDateTime activeTo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "application_id", nullable = false)
    private ApplicationEntity application;


    public PasswordEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public ApplicationEntity getApplication() {
        return application;
    }

    public void setApplication(ApplicationEntity application) {
        this.application = application;
    }

}
