package ir.sudoit.infrastructure.delivery.controller.impl;

import ir.sudoit.core.plate.Plate;
import ir.sudoit.core.plate.usecase.GetAllPlateUseCase;
import ir.sudoit.core.plate.usecase.PlateProvinceFinderUseCase;
import ir.sudoit.core.plate.usecase.UpdateUseCase;
import ir.sudoit.infrastructure.delivery.controller.PlateController;
import ir.sudoit.infrastructure.delivery.converters.PlateRestConverter;
import ir.sudoit.infrastructure.delivery.rest.PlateRest;
import ir.sudoit.infrastructure.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.webjars.NotFoundException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/plate")
public class PlateControllerImpl implements PlateController {

    private final GetAllPlateUseCase getAllPlateUseCase;
    private final PlateProvinceFinderUseCase plateProvinceFinderUseCase;
    private final UpdateUseCase updateUseCase;
    private final PlateRestConverter converter;




    @Override
    public List<PlateRest> getAllPlateList() throws GlobalException {
        return getAllPlateUseCase.execute().stream().map(converter::mapToRest).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity createPlateList(@RequestBody @Valid List<PlateRest> plateRest, BindingResult bindingResult) throws GlobalException {
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult);
        }
        plateRest.forEach(plateRest1 -> updateUseCase.execute(PlateRestConverter.INSTANCE.mapToEntity(plateRest1)))
        ;
        return ResponseEntity.ok(plateRest);
    }

    @Override
    public Plate getPlateState(Integer number) throws GlobalException {
        return plateProvinceFinderUseCase.execute(number).orElseThrow(() -> new NotFoundException("Number not found"));
    }


}
