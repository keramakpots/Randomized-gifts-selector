package com.stopka.giftsrandomizer.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class Lottery {

    private Long lotteryId;
    private List<Person> participants;
    private BigDecimal amount;
    private Long id;

}
