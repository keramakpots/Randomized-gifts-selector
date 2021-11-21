package com.stopka.giftsrandomizer.repository;

import com.stopka.giftsrandomizer.model.Lottery;
import org.springframework.data.repository.CrudRepository;

public interface LotteryRepository extends CrudRepository<Lottery, Long> {
}
