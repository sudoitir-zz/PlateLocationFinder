package ir.sudoit.infrastructure.persistence.converter;

import ir.sudoit.core.plate.Plate;
import ir.sudoit.infrastructure.config.PlateConfig;
import ir.sudoit.infrastructure.delivery.converters.PlateRestConverter;
import ir.sudoit.infrastructure.persistence.entities.PlateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring", uses= PlateConfig.class)
public interface PlateRepositoryConverter{

    PlateRestConverter INSTANCE = Mappers.getMapper(PlateRestConverter.class);
    PlateEntity mapToTable(Plate plate);

    Plate mapToEntity(PlateEntity plateEntity);

}
