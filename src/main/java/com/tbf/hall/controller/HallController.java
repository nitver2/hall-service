package com.tbf.hall.controller;

import com.tbf.hall.entity.Hall;
import com.tbf.hall.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hall")
public class HallController {

    @Autowired
    private HallService hallService;

    @GetMapping("/{theaterId}")
    public List<Hall> getHalls(@PathVariable String city,
                               @PathVariable int theaterId) {
        return hallService.findHallByTheater(theaterId);
    }

    @PostMapping("")
    public boolean addHall(@RequestBody Hall hall) {
        return hallService.addHall(hall);
    }

}
