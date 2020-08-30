package guru.springframework.brewery.services;

import guru.springframework.brewery.web.model.BearDto;

import java.util.UUID;

public interface BeerService {
    BearDto getBeerById(UUID beerId);

    BearDto saveNewBeer(BearDto bearDto);

    void updateBeer(UUID beerId, BearDto bearDto);

    void deleteById(UUID beerId);
}
