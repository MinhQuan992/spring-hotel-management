package org.example.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.common.Status;
import org.example.entity.Room;
import org.example.exception.InternalServerError;
import org.example.exception.NotFound;
import org.example.mapstruct.RoomDTO;
import org.example.mapstruct.RoomMapper;
import org.example.repository.RoomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;
    @Override
    public List<RoomDTO> getRooms() {


        log.info("getting all rooms");
        try {

            List<Room> list = roomRepository.findAll();

            return list.stream().map(roomMapper::roomToRoomDTO).collect(Collectors.toList());

        }
        catch (Exception ex)
        {
            throw new InternalServerError();
        }

    }

    @Override
    public List<Room> getRooms(int pageNumber, int limit) {
        log.info("getting all rooms following page number and limit");
        try {
            Page<Room> rooms = roomRepository.findAll(PageRequest.of(pageNumber,limit, Sort.by("roomNumber").ascending()));
            System.out.println("total rooms at current page: " + rooms.getSize());
            System.out.println("total rooms: " + rooms.getTotalElements());
            System.out.println("total pages: " + rooms.getTotalPages());
            return rooms.getContent();
        }
        catch (Exception ex)
        {
            throw new InternalServerError();
        }
    }

    @Override
    public Room addRoom(Room room) {
        log.info("adding a room");
        try {
            return roomRepository.save(room);
        }
        catch (Exception ex)
        {
            throw new InternalServerError();
        }

    }

    @Override
    public Room updateRoom(Room newRoom) {
        log.info("updating a room");
        try {
            return roomRepository.save(newRoom);
        }
        catch (Exception ex)
        {
            throw new InternalServerError();
        }

    }

    @Override
    public void deleteRoom(Long id) {
        log.info("deleting a room with id: {}", id);
        try {
            roomRepository.deleteRoomById(id);
        }
        catch (Exception ex)
        {
            throw new InternalServerError();
        }
    }

    @Override
    public Optional<Room> getRoomById(Long id) {
        try {
            log.info("getting a room by id: {}", id);
           return roomRepository.findRoomById(id);

        }
        catch (Exception ex)
        {
            throw new InternalServerError();
        }
    }

    @Override
    public Status getRoomStatusById(Long id) {
        log.info("getting room status by id: {}",id);
        Optional<Room> room = getRoomById(id);
        if(room.isPresent())
            return room.get().getStatus();

        throw new NotFound();
    }
}
