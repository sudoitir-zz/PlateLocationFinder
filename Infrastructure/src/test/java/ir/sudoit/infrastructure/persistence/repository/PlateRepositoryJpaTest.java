package ir.sudoit.infrastructure.persistence.repository;

import ir.sudoit.infrastructure.persistence.entities.PlateEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@DataJpaTest
class PlateRepositoryJpaTest {

    @Autowired
    PlateRepositoryJpa repository;

    @Test
    void findByNumber() {
        PlateEntity plate = new PlateEntity();
        plate.setState("Tehran");
        plate.setNumber(545);
        repository.save(plate);
        assertNotNull(plate.getId());
    }


    @Test
    void queryResult1() throws Exception {
        try {
            Optional<PlateEntity> queryResult = repository.findByNumber(545);
            assertFalse(queryResult.isPresent());
        } catch (Exception ignored) {
        }
    }
}