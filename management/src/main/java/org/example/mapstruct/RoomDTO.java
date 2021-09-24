package org.example.mapstruct;

import lombok.Data;
import org.example.config.CustomJsonRootName;

@Data
//@JsonRootName("room")  => works for a response with one object
@CustomJsonRootName(plural = "rooms", singular = "room")
public class RoomDTO {
    private int roomNumber;
    private String status;
}
