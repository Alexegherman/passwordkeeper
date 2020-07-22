package eu.accesa.passwordkeeper.service.impl;

import eu.accesa.passwordkeeper.entities.ApplicationEntity;
import eu.accesa.passwordkeeper.entities.PasswordEntity;
import eu.accesa.passwordkeeper.model.ApplicationModel;
import eu.accesa.passwordkeeper.model.ApplicationRequest;
import eu.accesa.passwordkeeper.repositories.ApplicationRepository;
import eu.accesa.passwordkeeper.service.ApplicationService;
import eu.accesa.passwordkeeper.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    @Transactional
    public ApplicationModel createApplication(ApplicationRequest applicationRequest) {
        ApplicationEntity savedApplication = applicationRepository.save(MapperUtil.mapApplicationDtoToEntity(
                applicationRequest));
        return MapperUtil.mapApplicationEntityToModel(savedApplication);
    }

    @Override
    @Transactional
    public ApplicationModel updateApplication(String applicationName, ApplicationRequest applicationModel) {
        ApplicationEntity entity = applicationRepository.findByNameOrThrowException(applicationName);
        entity.setName(applicationModel.getName());
        entity.setUrl(applicationModel.getUrl());
        entity.getPasswords().forEach(p -> p.setActiveTo(OffsetDateTime.now()));
        Set<PasswordEntity> passwordEntities =
                MapperUtil.mapPasswordDtosToEntities(applicationModel.getPasswords(), entity);
        entity.addPasswords(passwordEntities);
        return MapperUtil.mapApplicationEntityToModel(applicationRepository.save(entity));

    }

    @Override public Set<ApplicationModel> getApplications() {
        return applicationRepository.findAll()
                                    .stream()
                                    .map(MapperUtil::mapApplicationEntityToModel)
                                    .collect(Collectors.toSet());
    }
}
