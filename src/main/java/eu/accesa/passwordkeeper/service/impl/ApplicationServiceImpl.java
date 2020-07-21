package eu.accesa.passwordkeeper.service.impl;

import eu.accesa.passwordkeeper.model.Application;
import eu.accesa.passwordkeeper.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Override public Application createApplication(Application application) {
        return null;
    }

    @Override public Application updateApplication(String applicationName, Application application) {
        return null;
    }

    @Override public List<Application> getApplications() {
        return null;
    }

    @Override public Application getApplicationByName(String name) {
        return null;
    }
}
