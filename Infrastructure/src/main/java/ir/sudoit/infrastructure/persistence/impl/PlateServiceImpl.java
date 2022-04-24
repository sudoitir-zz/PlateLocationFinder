package ir.sudoit.infrastructure.persistence.impl;

import ir.sudoit.core.plate.Plate;
import ir.sudoit.core.plate.port.PlateRepositoryService;
import ir.sudoit.infrastructure.persistence.converter.PlateRepositoryConverter;
import ir.sudoit.infrastructure.persistence.entities.PlateEntity;
import ir.sudoit.infrastructure.persistence.repository.PlateRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public record PlateServiceImpl(PlateRepository plateRepository,
                               PlateRepositoryConverter plateRepositoryConverter) implements PlateRepositoryService {
    @Override
    public Collection<Plate> getAllPlate() {
        return plateRepository.findAll().stream().map(plateRepositoryConverter::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public void savePlate(Plate plate) {
        PlateEntity plateEntity = plateRepositoryConverter.mapToTable(plate);
        plateRepository.save(plateEntity);
    }

    @Override
    public Optional<Plate> findByNumber(Integer number) {
        return plateRepository.findByNumber(number).stream().map(plateRepositoryConverter::mapToEntity).findAny();
    }

    @Override
    public Optional<Plate> findByNumberAndCharacter(Integer number, String character) {
        return Optional.empty();
    }


}
