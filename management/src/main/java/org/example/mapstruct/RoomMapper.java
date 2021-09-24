package org.example.mapstruct;

import org.example.entity.Room;
import org.mapstruct.Mapper;

@Mapper
public interface RoomMapper {

    public  RoomDTO roomToRoomDTO(Room room);

}
