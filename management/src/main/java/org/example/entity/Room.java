package org.example.entity;

import lombok.Data;
import org.example.common.Status;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private int roomNumber;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    public Room() {

    }
}
