package ir.sudoit.infrastructure.delivery.controller;


import ir.sudoit.core.plate.Plate;
import ir.sudoit.infrastructure.delivery.rest.PlateRest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/plate")
@Validated
public interface PlateController {


    @GetMapping(path = "get-all-plate-list")
    List<PlateRest> getAllPlateList();

    @PostMapping(path = "create-plate")
    ResponseEntity<?> createPlateList(@RequestBody List<PlateRest> category);

    @GetMapping(path = "get-state/{number}")
    Plate getPlateState(@PathVariable Integer number);

}
