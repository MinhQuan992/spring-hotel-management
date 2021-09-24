package org.example.repository;

import org.example.common.Status;
import org.example.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    public Optional<Room> findRoomById(Long id);

    public List<Room> findAll(Pageable pageable);
    public void deleteRoomById(Long id);
    public List<Room> findAll();


}
