package com.tbf.hall.entitymapper;

import com.tbf.hall.entity.Hall;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class HallRowMapper implements RowMapper<Hall> {

    @Override
    public Hall mapRow(ResultSet rs, int rowNum) throws SQLException {
        Hall hall = new Hall();
        hall.setHall_id(rs.getInt("hall_id"));
        hall.setTheater_id(rs.getString("theater_id"));
        hall.setCapacity(rs.getString("capacity"));
        return hall;
    }
}
