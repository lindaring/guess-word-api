package com.lindaring.guess.service;

import com.lindaring.guess.model.Pos;
import com.lindaring.guess.repository.PosRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class PosServ {

    @Autowired
    PosRepo posRepo;

    /**
     * Get the part of speech by name.
     *
     * @param pos the part of speech object with either id or name defined.
     * @return the part of speech.
     */
    public Pos getPartOfSpeech(Pos pos) {
        if (pos.getPosId() != 0) {
            return posRepo.findOne(pos.getPosId());
        } else if (!StringUtils.isEmpty(pos.getName())) {
            List<Pos> list = posRepo.findByName(pos.getName().toLowerCase());
            return !list.isEmpty() ? list.get(0) : null;
        }
        return null;
    }
}
