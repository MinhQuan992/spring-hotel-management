package org.example.mapstruct;

import org.example.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RoomMapper {

    public  RoomDTO roomToRoomDTO(Room room);

//    public  Room roomDTOToRoom(RoomDTO roomDTO);

}
