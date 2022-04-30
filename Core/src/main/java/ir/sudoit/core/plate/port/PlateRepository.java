package ir.sudoit.core.plate.port;

import ir.sudoit.core.plate.Plate;

import java.util.Collection;
import java.util.Optional;

public interface PlateRepository {

   Collection<Plate> getAllPlate();

   void savePlate(Plate plate);

   Optional<Plate> findByNumber(Integer number);

   Optional<Plate> findByNumberAndCharacter(Integer number, String character);

}
