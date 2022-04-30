package ir.sudoit.infrastructure.delivery.controller.impl;

import ir.sudoit.core.plate.Plate;
import ir.sudoit.core.plate.usecase.GetAllPlateUseCase;
import ir.sudoit.core.plate.usecase.PlateProvinceFinderUseCase;
import ir.sudoit.core.plate.usecase.UpdateUseCase;
import ir.sudoit.infrastructure.delivery.controller.PlateController;
import ir.sudoit.infrastructure.delivery.converters.PlateRestConverter;
import ir.sudoit.infrastructure.delivery.rest.PlateRest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/plate")
@Validated
@Slf4j
public class PlateControllerImpl implements PlateController {

    private final GetAllPlateUseCase getAllPlateUseCase;
    private final PlateProvinceFinderUseCase plateProvinceFinderUseCase;
    private final UpdateUseCase updateUseCase;
    private final PlateRestConverter converter;


    @Override
    public List<PlateRest> getAllPlateList() {
        return getAllPlateUseCase.execute().stream().map(converter::mapToRest).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<?> createPlateList(@RequestBody @Validated List<PlateRest> plateRest) {
        try {
            plateRest.forEach(plateRest1 -> updateUseCase.execute(PlateRestConverter.INSTANCE.mapToEntity(plateRest1)));
            return ResponseEntity.ok(plateRest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @Override
    public Plate getPlateState(Integer number) {
        return plateProvinceFinderUseCase.execute(number).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Number not found"));
    }
}
