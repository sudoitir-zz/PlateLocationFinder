package ir.sudoit.infrastructure.delivery.controller;


import ir.sudoit.core.plate.Plate;
import ir.sudoit.infrastructure.delivery.rest.PlateRest;
import ir.sudoit.infrastructure.exception.GlobalException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/plate")
public interface PlateController {


    @GetMapping(path = "get-all-plate-list")
    List<PlateRest> getAllPlateList() throws GlobalException;

    @PostMapping(path = "create-plate")
    ResponseEntity createPlateList(@RequestBody List<PlateRest> category, BindingResult bindingResult) throws GlobalException;

    @GetMapping (path = "get-state/{number}")
    Plate getPlateState(@PathVariable Integer number) throws GlobalException;

}
