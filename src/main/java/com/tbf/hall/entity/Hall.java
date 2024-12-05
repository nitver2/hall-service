package com.tbf.hall.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Hall implements Serializable {

    private int hall_id;
    private String theater_id;
    private String capacity;
}
