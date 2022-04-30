package ir.sudoit.core.plate.usecase.impl;

import ir.sudoit.core.plate.Plate;
import ir.sudoit.core.plate.port.PlateRepository;
import ir.sudoit.core.plate.usecase.PlateProvinceFinderUseCase;

import java.util.Optional;

public record PlateProvinceFinderUseCaseImpl(
        PlateRepository repositoryService) implements PlateProvinceFinderUseCase {

    @Override
    public Optional<Plate> execute(Integer number) {
        return repositoryService.findByNumber(number);
    }
}
