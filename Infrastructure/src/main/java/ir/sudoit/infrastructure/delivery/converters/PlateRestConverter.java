package ir.sudoit.infrastructure.delivery.converters;

import ir.sudoit.core.plate.Plate;
import ir.sudoit.infrastructure.delivery.controller.impl.PlateControllerImpl;
import ir.sudoit.infrastructure.delivery.rest.PlateRest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring", uses= PlateControllerImpl.class)
public interface PlateRestConverter {

    PlateRestConverter INSTANCE = Mappers.getMapper(PlateRestConverter.class);
    Plate mapToEntity(PlateRest plateRest);

    PlateRest mapToRest(Plate plate);

}
