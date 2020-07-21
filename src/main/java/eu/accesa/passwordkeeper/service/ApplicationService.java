package eu.accesa.passwordkeeper.service;

import eu.accesa.passwordkeeper.model.Application;

import java.util.List;

public interface ApplicationService {
    Application createApplication(Application application);
    Application updateApplication(String applicationName, Application application);
    List<Application> getApplications();
    Application getApplicationByName(String name);
}
