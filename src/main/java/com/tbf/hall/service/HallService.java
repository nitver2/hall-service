package com.tbf.hall.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.tbf.hall.entity.Hall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.tbf.hall.repository.HallRepository;

import java.util.List;

@Service
public class HallService {

    private static final Logger logger = LoggerFactory.getLogger(HallService.class);

    @Autowired
    private HallRepository hallRepository;

    public boolean addHall(Hall hall) {
        return hallRepository.addHall(hall);
    }

    public List<Hall> findHallByTheater(int theaterId) {
        return hallRepository.findHallByTheater(theaterId);
    }

}
