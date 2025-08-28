package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.dtos.HotelDto;
import com.example.hotelmanagement.entities.Hotel;
import com.example.hotelmanagement.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getHotels();
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Hotel>> getHotelById(@PathVariable String id) {
        Optional<Hotel> hotel = hotelService.getHotel(id);
        return ResponseEntity.ok(hotel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable String id) {
        hotelService.deleteHotel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
