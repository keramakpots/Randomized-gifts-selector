package com.stopka.giftsrandomizer.web.response;

import com.stopka.giftsrandomizer.model.Lottery;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
public class PairsResponse extends ResponseEntity {
    private Lottery lottery;

    public PairsResponse(Lottery lottery) {
        super(HttpStatus.OK);
        lottery = lottery;
    }
}
