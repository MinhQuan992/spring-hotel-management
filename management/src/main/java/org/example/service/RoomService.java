package org.example.service;

import org.example.common.Status;
import org.example.entity.Room;
import org.example.mapstruct.RoomDTO;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    public List<Room> getRooms();
    public Room addRoom(Room room);
    public Room updateRoom(Room newRoom);
    public void deleteRoom(Long id);
    public Optional<Room> getRoomById(Long id);
    public Status getRoomStatusById(Long id);
//    public Room convertRoomDTOToRoom(RoomDTO room);

}
