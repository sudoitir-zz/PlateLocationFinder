package ir.sudoit.core.plate.usecase.impl;

import ir.sudoit.core.plate.Plate;
import ir.sudoit.core.plate.port.PlateRepositoryService;
import ir.sudoit.core.plate.usecase.GetAllPlateUseCase;

import java.util.Collection;


public record GetAllPlateUseCaseImpl(PlateRepositoryService repositoryService) implements GetAllPlateUseCase {

    @Override
    public Collection<Plate> execute() {
        return repositoryService.getAllPlate();
    }

}
