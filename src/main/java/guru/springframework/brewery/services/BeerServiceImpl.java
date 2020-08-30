package guru.springframework.brewery.services;

import guru.springframework.brewery.web.model.BearDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BearDto getBeerById(UUID beerId){
        return BearDto.builder().id(UUID.randomUUID()).beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }
    @Override
    public BearDto saveNewBeer(BearDto bearDto){
        return BearDto.builder()
                .id(UUID.randomUUID())
                .build();
    }
    @Override
    public void updateBeer(UUID beerId, BearDto bearDto){

    }
    @Override
    public void deleteById(UUID beerId){
        log.debug("Deleting a beer...!!!");
    }

}
