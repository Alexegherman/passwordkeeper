package eu.accesa.passwordkeeper.service;

import eu.accesa.passwordkeeper.model.ApplicationModel;

import java.util.Set;

public interface ApplicationService {
    Set<ApplicationModel> getApplications();

    ApplicationModel createApplication(ApplicationModel applicationModel);

    ApplicationModel updateApplication(String applicationName, ApplicationModel applicationModel);
}
