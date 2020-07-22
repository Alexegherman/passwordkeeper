package eu.accesa.passwordkeeper.service.impl;

import eu.accesa.passwordkeeper.entities.ApplicationEntity;
import eu.accesa.passwordkeeper.entities.PasswordEntity;
import eu.accesa.passwordkeeper.model.Password;
import eu.accesa.passwordkeeper.model.PasswordRequest;
import eu.accesa.passwordkeeper.repositories.ApplicationRepository;
import eu.accesa.passwordkeeper.repositories.PasswordRepository;
import eu.accesa.passwordkeeper.service.PasswordService;
import eu.accesa.passwordkeeper.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PasswordServiceImpl implements PasswordService {

    private final PasswordRepository passwordRepository;

    private final ApplicationRepository applicationRepository;

    @Autowired
    public PasswordServiceImpl(PasswordRepository passwordRepository, ApplicationRepository applicationRepository) {
        this.passwordRepository = passwordRepository;
        this.applicationRepository = applicationRepository;
    }

    @Override
    @Transactional
    public Password createPassword(String applicationName, PasswordRequest passwordRequest) {
        ApplicationEntity applicationEntity = applicationRepository.findByNameOrThrowException(applicationName);
        PasswordEntity passwordEntity = MapperUtil.mapPasswordDtoToEntity(passwordRequest);
        passwordEntity.setApplication(applicationEntity);
        return MapperUtil.mapPasswordEntityToModel(passwordRepository.save(passwordEntity));
    }

    @Override public Set<Password> getPasswordsByApplication(String applicationName, boolean active) {
        ApplicationEntity applicationEntity = applicationRepository.findByNameOrThrowException(applicationName);
        Set<PasswordEntity> passwordEntities = passwordRepository.findAllByApplication(applicationEntity);
        if (active) {
            return MapperUtil.mapPasswordEntitiesToModels(passwordEntities.stream()
                                                                          .filter(password -> password.getActiveTo() == null)
                                                                          .collect(Collectors.toSet()));
        }
        return MapperUtil.mapPasswordEntitiesToModels(passwordEntities);
    }

    @Override
    @Transactional
    public Password updatePassword(String applicationName, String userName, PasswordRequest passwordRequest) {
        ApplicationEntity applicationEntity = applicationRepository.findByNameOrThrowException(applicationName);
        passwordRepository.disablePasswordForUser(applicationEntity, userName, OffsetDateTime.now());
        PasswordEntity passwordEntity = MapperUtil.mapPasswordDtoToEntity(passwordRequest);
        passwordEntity.setApplication(applicationEntity);
        return MapperUtil.mapPasswordEntityToModel(passwordRepository.save(passwordEntity));

    }

}

