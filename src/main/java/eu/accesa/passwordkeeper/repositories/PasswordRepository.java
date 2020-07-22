package eu.accesa.passwordkeeper.repositories;

import eu.accesa.passwordkeeper.entities.ApplicationEntity;
import eu.accesa.passwordkeeper.entities.PasswordEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.Set;

@Repository
public interface PasswordRepository extends CrudRepository<PasswordEntity, Long> {
    @Modifying
    @Query("update PasswordEntity p set p.activeTo = :activeTo where p.application = :application and p.userName = :userName")
    void disablePasswordForUser(@Param("application") ApplicationEntity application, @Param("userName") String userName, @Param("activeTo") OffsetDateTime activeTo);

    Set<PasswordEntity> findAllByApplication(ApplicationEntity application);
}
