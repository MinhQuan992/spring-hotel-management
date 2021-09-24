package org.example.entity;

import lombok.Data;
import org.example.common.Status;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
