package eu.accesa.passwordkeeper.repositories;

import eu.accesa.passwordkeeper.entities.ApplicationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityNotFoundException;

import java.util.Set;

@Repository
public interface ApplicationRepository extends CrudRepository<ApplicationEntity, Long> {
    Set<ApplicationEntity> findAll();

    ApplicationEntity findByName(String name);


    default ApplicationEntity findByNameOrThrowException(String name){
        ApplicationEntity applicationEntity = findByName(name);
        if (applicationEntity == null) {
            throw new EntityNotFoundException(String.format("Application with name %s not found.", name));
        }
        return applicationEntity;
    }


}
