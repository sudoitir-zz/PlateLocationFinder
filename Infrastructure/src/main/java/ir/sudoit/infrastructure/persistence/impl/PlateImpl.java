package ir.sudoit.infrastructure.persistence.impl;

import ir.sudoit.core.plate.Plate;
import ir.sudoit.core.plate.port.PlateRepository;
import ir.sudoit.infrastructure.persistence.converter.PlateRepositoryConverter;
import ir.sudoit.infrastructure.persistence.entities.PlateEntity;
import ir.sudoit.infrastructure.persistence.repository.PlateRepositoryJpa;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public record PlateImpl(PlateRepositoryJpa plateRepositoryJpa,
                        PlateRepositoryConverter plateRepositoryConverter) implements PlateRepository {
    @Override
    public Collection<Plate> getAllPlate() {
        return plateRepositoryJpa.findAll().stream().map(plateRepositoryConverter::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public void savePlate(Plate plate) {
        PlateEntity plateEntity = plateRepositoryConverter.mapToTable(plate);
        plateRepositoryJpa.save(plateEntity);
    }

    @Override
    public Optional<Plate> findByNumber(Integer number) {
        return plateRepositoryJpa.findByNumber(number).stream().map(plateRepositoryConverter::mapToEntity).findAny();
    }

    @Override
    public Optional<Plate> findByNumberAndCharacter(Integer number, String character) {
        return Optional.empty();
    }


}
