package guru.springframework.brewery.web.controller;

import guru.springframework.brewery.services.BeerService;
import guru.springframework.brewery.web.model.BearDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }


    @GetMapping({"/{beerId}"})
    public ResponseEntity<BearDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BearDto bearDto) {
        BearDto saveDto = beerService.saveNewBeer(bearDto);
        HttpHeaders headers= new HttpHeaders();
        headers.add( "Location","/api/v1/beer"+ saveDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId"})
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,@RequestBody BearDto bearDto) {
        beerService.updateBeer(beerId, bearDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping({"/{beerId"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteById(beerId);
    }

}
