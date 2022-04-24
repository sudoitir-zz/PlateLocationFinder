package ir.sudoit.infrastructure.config;

import ir.sudoit.core.plate.usecase.impl.GetAllPlateUseCaseImpl;
import ir.sudoit.core.plate.usecase.impl.PlateProvinceFinderUseCaseImpl;
import ir.sudoit.core.plate.usecase.impl.UpdateImpl;
import ir.sudoit.infrastructure.persistence.converter.PlateRepositoryConverter;
import ir.sudoit.infrastructure.persistence.impl.PlateServiceImpl;
import ir.sudoit.infrastructure.persistence.repository.PlateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PlateConfig {

    private final PlateRepository plateRepository;
    private final PlateRepositoryConverter plateRepositoryConverter;


    @Bean
    public PlateServiceImpl plateService() {
        return new PlateServiceImpl(plateRepository, plateRepositoryConverter);
    }


    @Bean
    public GetAllPlateUseCaseImpl getAllPlateUseCase() {
        return new GetAllPlateUseCaseImpl(plateService());
    }

    @Bean
    public PlateProvinceFinderUseCaseImpl plateProvinceFinderUseCase() {
        return new PlateProvinceFinderUseCaseImpl(plateService());
    }

    @Bean
    public UpdateImpl updateFromGitHubUseCase() {
        return new UpdateImpl(plateService());
    }
}
