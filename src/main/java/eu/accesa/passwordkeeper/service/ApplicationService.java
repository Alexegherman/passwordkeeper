package eu.accesa.passwordkeeper.service;

import eu.accesa.passwordkeeper.model.ApplicationModel;
import eu.accesa.passwordkeeper.model.ApplicationRequest;

import java.util.Set;

public interface ApplicationService {
    Set<ApplicationModel> getApplications();

    ApplicationModel createApplication(ApplicationRequest applicationRequest);

    ApplicationModel updateApplication(String applicationName, ApplicationRequest applicationModel);

}
