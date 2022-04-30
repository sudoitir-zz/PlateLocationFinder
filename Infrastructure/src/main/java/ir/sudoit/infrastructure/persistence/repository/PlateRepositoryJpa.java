package ir.sudoit.infrastructure.persistence.repository;

import ir.sudoit.infrastructure.persistence.entities.PlateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;

@Repository
public interface PlateRepositoryJpa extends JpaRepository<PlateEntity, Long> {

    Optional<PlateEntity> findByNumber(@NotEmpty Integer number);



}