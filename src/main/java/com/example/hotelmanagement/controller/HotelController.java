package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.dtos.HotelDto;
import com.example.hotelmanagement.entities.Hotel;
import com.example.hotelmanagement.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody HotelDto hotel) {
        Hotel newHotel = hotelService.addHotel(hotel);
        return ResponseEntity.ok(newHotel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable String id, @RequestBody HotelDto dto) {
        Hotel hotel = hotelService.updateHotel(id, dto);
        return ResponseEntity.ok(hotel);
    }
}
