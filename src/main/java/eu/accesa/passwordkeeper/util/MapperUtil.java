package eu.accesa.passwordkeeper.util;


import eu.accesa.passwordkeeper.entities.ApplicationEntity;
import eu.accesa.passwordkeeper.entities.PasswordEntity;
import eu.accesa.passwordkeeper.model.ApplicationModel;
import eu.accesa.passwordkeeper.model.ApplicationRequest;
import eu.accesa.passwordkeeper.model.Password;
import eu.accesa.passwordkeeper.model.PasswordRequest;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class MapperUtil {

    public static ApplicationEntity mapApplicationDtoToEntity(ApplicationRequest applicationRequest){
        ApplicationEntity entity = new ApplicationEntity();
        entity.setName(applicationRequest.getName());
        entity.setUrl(applicationRequest.getUrl());
        Set<PasswordEntity> passwordEntities = mapPasswordDtosToEntities(applicationRequest.getPasswords(), entity);
        entity.setPasswords(passwordEntities);
        return entity;

    }

    public static Set<PasswordEntity> mapPasswordDtosToEntities(Set<PasswordRequest> passwords, ApplicationEntity application){
        return passwords.stream().map(password -> {
            PasswordEntity passwordEntity = mapPasswordDtoToEntity(password);
            passwordEntity.setApplication(application);
            return passwordEntity;
        }).collect(Collectors.toSet());
    }

    public static PasswordEntity mapPasswordDtoToEntity(PasswordRequest passwordRequest) {
        PasswordEntity passwordEntity = new PasswordEntity();
        passwordEntity.setUserName(passwordRequest.getUsername());
        passwordEntity.setPassword(passwordRequest.getPassword());
        passwordEntity.setActiveFrom(OffsetDateTime.now());
        return passwordEntity;
    }


    public static ApplicationModel mapApplicationEntityToModel(ApplicationEntity applicationEntity) {
        return new ApplicationModel(applicationEntity.getName(), applicationEntity.getUrl(),
                                    mapPasswordEntitiesToModels(applicationEntity.getPasswords()));
    }

    public static Set<Password> mapPasswordEntitiesToModels(Set<PasswordEntity> passwords) {
        return passwords.stream().map(MapperUtil::mapPasswordEntityToModel).collect(Collectors.toSet());
    }

    public static Password mapPasswordEntityToModel(PasswordEntity entity) {
        return new Password(entity.getUserName(), entity.getPassword(), entity.getActiveFrom(), entity.getActiveTo());

    }


}
