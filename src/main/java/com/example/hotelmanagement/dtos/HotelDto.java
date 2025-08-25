package com.example.hotelmanagement.dtos;

import com.example.hotelmanagement.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {

    private String name;

    private Address address;

    private List<RoomDto> rooms;
}
