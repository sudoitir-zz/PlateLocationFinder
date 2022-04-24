package ir.sudoit.core.plate.usecase.impl;

import ir.sudoit.core.plate.Plate;
import ir.sudoit.core.plate.port.PlateRepositoryService;
import ir.sudoit.core.plate.usecase.UpdateUseCase;

public record UpdateImpl(PlateRepositoryService repositoryService) implements UpdateUseCase {

    @Override
    public void execute(Plate plate) {
        repositoryService.savePlate(plate);
    }
}
