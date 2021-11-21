package com.stopka.giftsrandomizer.web.service;

import com.stopka.giftsrandomizer.match.Matcher;
import com.stopka.giftsrandomizer.model.Lottery;
import com.stopka.giftsrandomizer.model.Person;
import com.stopka.giftsrandomizer.web.response.PairsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PairsGiftsService {

    @Autowired
    private LotteryService lotteryService;
    @Autowired
    private Matcher matcher;

    public PairsResponse createLotter(List<Person> personList) {
        List<Person> personsMatchedWithGifts = matcher.matchGifts(personList);
        Lottery lottery = lotteryService.createLotter(personsMatchedWithGifts);
        return new PairsResponse(lottery);
    }
}
