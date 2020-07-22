package eu.accesa.passwordkeeper.service.impl;

import eu.accesa.passwordkeeper.model.ApplicationModel;
import eu.accesa.passwordkeeper.model.Password;
import eu.accesa.passwordkeeper.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Set;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Override public Set<ApplicationModel> getApplications() {
        Password password = new Password("alexg", "strongpassword", OffsetDateTime.now(), OffsetDateTime.now());

        return Collections.singleton(new ApplicationModel("facebook", "https://facebook.com", Collections.singleton(password)));
    }

    @Override public ApplicationModel createApplication(ApplicationModel applicationModel) {
        Password password = new Password("alexg", "strongpassword", OffsetDateTime.now(), OffsetDateTime.now());

        return new ApplicationModel("facebook", "https://facebook.com", Collections.singleton(password));
    }

    @Override public ApplicationModel updateApplication(String applicationName, ApplicationModel applicationModel) {
        Password password = new Password("alexg", "strongpassword", OffsetDateTime.now(), OffsetDateTime.now());

        return new ApplicationModel("facebook", "https://facebook.com", Collections.singleton(password));
    }
}
