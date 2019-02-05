package com.amrita.task.repository;

import com.amrita.task.entity.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class ParkingRepository {

    @Autowired JdbcTemplate jdbcTemplate;

    private final String SQL_INSERT_PARKING = "insert into PARKING(id, color, level, size_of_car, status, vechicle_number) values(?,?,?,?,?,?)";

    private final String get_all_available_level= "select * from PARKING";

    private final String SQL_FIND_PARKING = "select * from PARKING where vechicle_number = ?";

    private final String SQL_DELETE_PARKING = "delete from PARKING where id = ?";

    private final String SQL_FIND_BY_COLOR = "select * from PARKING where color = ?";

    private final String SQL_FIND_BY_SIZE = "select * from PARKING where size_of_car = ?";

    private final String SQL_FIND_BY_DURATION = "select * from PARKING where created_at< ? and created_at>= ?";


    public boolean parkVechicle(Parking vechicle) {
        return jdbcTemplate.update(SQL_INSERT_PARKING, vechicle.getId(), vechicle.getColor(), vechicle.getLevel(),
            vechicle.getSizeOfCar(), vechicle.isStatus(), vechicle.getVechicleNumber()) > 0;
    }

    public List<Parking> getAllAvailableLevel() {
        return jdbcTemplate.query(get_all_available_level, new BeanPropertyRowMapper<Parking>(Parking.class));
    }

    public boolean deleteParkingDetails(Parking parking) {
        return jdbcTemplate.update(SQL_DELETE_PARKING, parking.getId())>0;
    }

    public Parking getParkingByVechicleNumber(String vechicleNumber) {
        return jdbcTemplate.queryForObject(SQL_FIND_PARKING, new Object[] {
            vechicleNumber
            },
            new BeanPropertyRowMapper<Parking>(Parking.class));
    }

    public List<Parking> getParkingByColor(String color) {
        return jdbcTemplate.query(SQL_FIND_BY_COLOR, new Object[] {
            color
        },
            new BeanPropertyRowMapper<Parking>(Parking.class));
    }

    public List<Parking> getParkingBysize(String size) {
        return jdbcTemplate.query(SQL_FIND_BY_SIZE, new Object[] {
            size
        },
            new BeanPropertyRowMapper<Parking>(Parking.class));
    }

    public List<Parking> getVechicleByDuration (Date start, Date end) {
        return jdbcTemplate.query(SQL_FIND_BY_DURATION, new Object[] {
            end,
            start
        },
            new BeanPropertyRowMapper<Parking>(Parking.class));
    }

}
