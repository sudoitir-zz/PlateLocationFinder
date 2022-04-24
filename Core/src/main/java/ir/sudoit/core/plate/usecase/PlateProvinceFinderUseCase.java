package ir.sudoit.core.plate.usecase;

import ir.sudoit.core.plate.Plate;

import java.util.Optional;

public interface PlateProvinceFinderUseCase {

    Optional<Plate> execute(Integer number);
}
