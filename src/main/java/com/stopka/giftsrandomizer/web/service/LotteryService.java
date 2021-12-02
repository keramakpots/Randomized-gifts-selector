package com.stopka.giftsrandomizer.web.service;

import com.stopka.giftsrandomizer.model.Lottery;
import com.stopka.giftsrandomizer.model.Person;
import com.stopka.giftsrandomizer.repository.LotteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LotteryService {
    @Autowired
    private LotteryRepository lotteryRepository;

    public Lottery createLottery(List<Person> personList) {
        return new Lottery(1l, personList, new BigDecimal(40), 1l);
    }

}
