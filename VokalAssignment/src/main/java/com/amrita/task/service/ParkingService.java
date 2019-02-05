package com.amrita.task.service;

import com.amrita.task.entity.Parking;
import com.amrita.task.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class ParkingService {

    @Autowired ParkingRepository parkingRepository;

    public List<Parking> getAllBookedLevel() {
        List<Parking> response = new ArrayList<>();
        try {
            response = parkingRepository.getAllAvailableLevel();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public Map<String, Object> parkVechicle(Parking vechicle) {
        Map<String, Object> response = new HashMap<>();
        try {
            boolean mark = parkingRepository.parkVechicle(vechicle);
            if (mark == true){
                response.put("status", 1);
                response.put("message", "PARKED");
            }else {
                response.put("status", 0);
                response.put("message", "Not Parked");
            }
        }catch (Exception e) {
            e.printStackTrace();
            response.put("status", 0);
            response.put("message", "Something went wrong");
        }
        return response;
    }

    public Map<String, Object> UnPark(String vechicleNumber) {
        Map<String, Object> response = new HashMap<>();
        Parking park = parkingRepository.getParkingByVechicleNumber(vechicleNumber);
        try {
            boolean mark = parkingRepository.deleteParkingDetails(park);
            if(mark == true){
                response.put("Status", 1);
                response.put("message", park.toString() + "-->UNPARKED");
            }
            else
            {
                response.put("Status", 0);
                response.put("message", "Cant be unparked");
            }
        }catch (Exception e) {
            e.printStackTrace();
            response.put("Status", 0);
            response.put("message", "something went wrong");
        }

        return response;
    }

    public Parking getVechicleByVechicleNumber(String vechicleNumber) {
        Parking park;
        try {
            park = parkingRepository.getParkingByVechicleNumber(vechicleNumber);
            return park;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new Parking();
    }

    public List<Parking> getVechiclesByColor(String color) {
        List<Parking> response = new ArrayList<>();
        try {
            response = parkingRepository.getParkingByColor(color);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return response;
    }

    public List<Parking> getVechiclesByType(String type) {
        List<Parking> response = new ArrayList<>();
        try {
            response = parkingRepository.getParkingBysize(type);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public List<Parking> getVechicleByDuration(String start, String end) {
        Date startdate = getDateFromParseDateStringTwo(start);
        Date enddate = getDateFromParseDateStringTwo(end);
        List<Parking> response = new ArrayList<>();
        try {
            response = parkingRepository.getVechicleByDuration(startdate, enddate);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public static Date getDateFromParseDateStringTwo(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
        Date date = new Date();

        try {
            date = simpleDateFormat.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(11, 5);
            calendar.add(12, 30);
            calendar.set(14, 0);
            date = calendar.getTime();
        } catch (ParseException var4) {
            var4.printStackTrace();
        }

        return date;
    }

}
