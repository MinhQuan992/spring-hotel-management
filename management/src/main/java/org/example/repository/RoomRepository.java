package org.example.repository;
import org.example.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    public Optional<Room> findRoomById(Long id);

    @Override
    Page<Room> findAll(Pageable pageable);
    public void deleteRoomById(Long id);



}
