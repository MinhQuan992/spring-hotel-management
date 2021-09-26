package org.example.mapstruct;

import javax.annotation.Generated;
import org.example.entity.Room;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-22T20:56:36+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class RoomMapperImpl implements RoomMapper {

    @Override
    public RoomDTO roomToRoomDTO(Room room) {
        if ( room == null ) {
            return null;
        }

        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setRoomNumber( room.getRoomNumber() );
        if ( room.getStatus() != null ) {
            roomDTO.setStatus( room.getStatus().name() );
        }

        return roomDTO;
    }
}
