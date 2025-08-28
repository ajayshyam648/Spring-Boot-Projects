package com.example.hotelmanagement.services;

import com.example.hotelmanagement.dtos.HotelDto;
import com.example.hotelmanagement.dtos.RoomDto;
import com.example.hotelmanagement.entities.Hotel;
import com.example.hotelmanagement.entities.Room;
import com.example.hotelmanagement.exception.ResourceNotFoundException;
import com.example.hotelmanagement.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel addHotel(HotelDto dto) {

        Hotel hotel = new Hotel();
        hotel.setAddress(dto.getAddress());
        hotel.setName(dto.getName());

        List<Room> rooms = new ArrayList<>();

        for(RoomDto r : dto.getRooms()){
            Room room = new Room();
            room.setRoomType(r.getRoomType());
            room.setRoomCount(r.getRoomCount());
            room.setId(r.getId());
            room.setHotel(hotel);

            rooms.add(room);
        }
        hotel.setRooms(rooms);

        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(String id, HotelDto dto) {
        Hotel hotel = new Hotel();
        hotel.setId(Long.valueOf(id));
        hotel.setAddress(dto.getAddress());
        hotel.setName(dto.getName());

        List<Room> rooms = new ArrayList<>();
        Room room = new Room();

        for(RoomDto r : dto.getRooms()){
            room.setRoomType(r.getRoomType().toString());
            room.setRoomCount(r.getRoomCount());
            room.setId(r.getId());
            room.setHotel(hotel);

            rooms.add(room);
        }
        hotel.setRooms(rooms);

        return hotelRepository.save(hotel);
    }

    public List<Hotel> getHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels;
    }

    public void deleteHotel(String id){
        if(!hotelRepository.existsById(Long.valueOf(id))){
            throw new ResourceNotFoundException("Hotel does not exist with id " + id);
        }
        hotelRepository.deleteById(Long.valueOf(id));
    }

    public Optional<Hotel> getHotel(String id) {
        if(!hotelRepository.existsById(Long.valueOf(id))){
            throw new ResourceNotFoundException("Hotel does not exist with id " + id);
        }
        return hotelRepository.findById(Long.valueOf(id));
    }
}
