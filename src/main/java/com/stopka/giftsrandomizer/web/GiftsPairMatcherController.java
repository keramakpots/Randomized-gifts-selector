package com.stopka.giftsrandomizer.web;

import com.stopka.giftsrandomizer.model.Person;
import com.stopka.giftsrandomizer.web.response.PairsResponse;
import com.stopka.giftsrandomizer.web.service.PairsGiftsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "gifts")
public class GiftsPairMatcherController {
    @Autowired
    private PairsGiftsService pairsGiftsService;

    @PostMapping(path = "pair")
    public PairsResponse pairPersonWithGifts(@RequestBody List<Person> persons) {
        return pairsGiftsService.createLotter(persons);
    }


}
