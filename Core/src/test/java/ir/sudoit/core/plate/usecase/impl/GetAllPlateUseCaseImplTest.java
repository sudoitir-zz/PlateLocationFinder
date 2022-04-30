package ir.sudoit.core.plate.usecase.impl;

import ir.sudoit.core.plate.Plate;
import ir.sudoit.core.plate.port.PlateRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GetAllPlateUseCaseImplTest {

    PlateRepository plateRepository = new PlateRepository() {
        @Override
        public Collection<Plate> getAllPlate() {
            return null;
        }

        @Override
        public void savePlate(Plate plate) {
            plate = new Plate();
            plateRepository.savePlate(plate);
        }

        @Override
        public Optional<Plate> findByNumber(Integer number) {
            return Optional.empty();
        }

        @Override
        public Optional<Plate> findByNumberAndCharacter(Integer number, String character) {
            return Optional.empty();
        }
    };

    GetAllPlateUseCaseImpl getAllPlateUseCase = new GetAllPlateUseCaseImpl(plateRepository);

//    @BeforeEach
//    @Test
//    void data() {
//        Plate plate = new Plate();
//        plateRepository.savePlate(plate);
//    }

    @Test
    void execute() {
       List<Plate> plate = new ArrayList<>();
       Plate plate1 = new Plate();
        plate1.setId(1L);
        plate1.setNumber(100);
        plate.add(plate1);

        GetAllPlateUseCaseImpl mock = Mockito.mock(GetAllPlateUseCaseImpl.class);
        OngoingStubbing<Collection<Plate>> collectionOngoingStubbing = Mockito.when(mock.execute()).thenReturn(plate);
        assertEquals(100, ((GetAllPlateUseCaseImpl) collectionOngoingStubbing.getMock()).execute().stream().findFirst().get().getNumber());


    }

}