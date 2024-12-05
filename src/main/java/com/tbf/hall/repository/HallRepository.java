package com.tbf.hall.repository;

import com.tbf.hall.entity.Hall;
import com.tbf.hall.entitymapper.HallRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HallRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Hall> findHallByTheater(int theaterId) {
        String query = "SELECT h.hall_id, h.capacity, t.name AS theater_name, t.location AS theater_location" +
                "FROM hall h" +
                "JOIN theater t ON h.theater_id = t.theater_id" +
                "WHERE h.theater_id = :theater_id";

        Map<String, Object> params = new HashMap<>();
        params.put("theater_id", theaterId);
        return namedParameterJdbcTemplate.query(query, params, new HallRowMapper());
    }

    public boolean addHall(Hall hall) {
        String query = "INSERT INTO hall (hall_id, theater_id, capacity) " +
                "VALUES (:hall_id, :theater_id, :capacity)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("hall_id", hall.getHall_id());
        params.addValue("theater_id", hall.getTheater_id());
        params.addValue("capacity", hall.getCapacity());
        return namedParameterJdbcTemplate.update(query, params) != 0;
    }

}
