package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.common.Status;
import org.example.entity.Room;
import org.example.exception.BadRequest;
import org.example.exception.NotFound;
import org.example.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.*;
import java.util.List;


@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class RoomResource {
    private final RoomService roomService;

    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> getRooms()
    {
        List<Room> roomList = roomService.getRooms();
        return new ResponseEntity<>(roomList, HttpStatus.OK);
    }
//    note: @Valid must be next to BindingResult
    @PostMapping
    public ResponseEntity<Room> saveRoom(@Valid @RequestBody Room room, BindingResult bindingResult)
    {

//        don't need covert from room to roomDTO because we defined mapstruct between room and roomDTO
        if(bindingResult.hasErrors())
            throw new BadRequest();
        roomService.addRoom(room);
        return new ResponseEntity<>(room, HttpStatus.OK);

    }

    @PutMapping("{id}")
    public ResponseEntity<Room> updateRoom(@Valid @RequestBody Room room, BindingResult bindingResult, @PathVariable Long id)
    {

        if(bindingResult.hasErrors())
            throw new BadRequest();

        Optional<Room> updatedRoom = roomService.getRoomById(id);
        if(!updatedRoom.isPresent())
            throw new NotFound();

        room.setId(id);
        Room newRoom = roomService.updateRoom(room);

        return new ResponseEntity<>(newRoom, HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, String>> deleteRoom(@PathVariable Long id)
    {
        roomService.deleteRoom(id);
        Map<String, String> result = new HashMap<>();
        result.put("message: ", "success deleted");

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("status/{id}")
    public ResponseEntity<Map<String, Status>> getRoomStatus(@PathVariable Long id)
    {
        Status status = roomService.getRoomStatusById(id);
        Map<String, Status> resultMap = new HashMap<>();
        resultMap.put("status: ", status);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }


}
