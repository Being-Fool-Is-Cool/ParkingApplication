package com.amrita.task.controller;

import com.amrita.task.entity.Parking;
import com.amrita.task.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/parkingcontroller")
public class ParkingController {

    @Autowired ParkingService parkingService;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<Parking> getAll() {
        return parkingService.getAll();
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public String getHello() {
        return "hello World";
    }

    @RequestMapping(value = "/parkVechicle", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> parkVechicle(@RequestBody Parking vechicle) {
        return parkingService.parkVechicle(vechicle);
    }

    @RequestMapping(value = "/unpark", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> unPark(@RequestParam("vechicleNumber") String vechicleNumber) {
        return parkingService.UnPark(vechicleNumber);
    }

    @RequestMapping(value = "/getVechicleByVechicleNumber", method = RequestMethod.GET, consumes = "application/json")
    public Parking getVechicleByVechicleNumber(@RequestParam("vechicleNumber") String vechicleNumber) {
        return parkingService.getVechicleByVechicleNumber(vechicleNumber);
    }

    @RequestMapping(value = "/getVechiclesByColor", method = RequestMethod.GET, consumes = "application/json")
    public List<Parking> getVechiclesByColor(@RequestParam("color") String color) {
        return parkingService.getVechiclesByColor(color);
    }

    @RequestMapping(value = "/getVechiclesByType", method = RequestMethod.GET, consumes = "application/json")
    public List<Parking> getVechiclesByTypegetVechiclesByType(@RequestParam("type") String type) {
        return parkingService.getVechiclesByType(type);
    }

    @RequestMapping(value = "/getVechicleByDuration", method = RequestMethod.GET, consumes = "application/json")
    public List<Parking> getVechicleByDuration(@RequestParam("start") String start, @RequestParam("end") String end) {
        return parkingService.getVechicleByDuration(start, end);
    }



}
