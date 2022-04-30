package ir.sudoit.infrastructure.persistence.impl;

import ir.sudoit.core.plate.Plate;
import ir.sudoit.infrastructure.persistence.converter.PlateRepositoryConverter;
import ir.sudoit.infrastructure.persistence.entities.PlateEntity;
import ir.sudoit.infrastructure.persistence.repository.PlateRepositoryJpa;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PlateServiceImplTest {

    @Autowired
    PlateRepositoryJpa repository;
    @Autowired
    PlateRepositoryConverter plateRepositoryConverter;

    @BeforeAll
    void saveData(){
        PlateEntity plate0 = new PlateEntity();
        plate0.setState("Tehran");
        plate0.setNumber(545);
        PlateEntity plate1 = new PlateEntity();
        plate1.setState("Kerman");
        plate1.setNumber(541841);
        List<PlateEntity> plateEntities = new ArrayList<>();
        plateEntities.add(plate0);
        plateEntities.add(plate1);
        repository.saveAll(plateEntities);
    }

    @Test
    @AssertTrue
    void getAllPlate() {
        List<Plate> plate = repository.findAll().stream().map(plateRepositoryConverter::mapToEntity).toList();
    }

    @Test
    void savePlate() {
    }

    @Test
    void findByNumber() {
    }

    @Test
    void findByNumberAndCharacter() {
    }

    @Test
    void plateRepository() {
    }

    @Test
    void plateRepositoryConverter() {
    }
}