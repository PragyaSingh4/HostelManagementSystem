package com.hostel.repository;

import java.util.Optional;
import com.hostel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    Optional<Room> findByRoomNumber(String roomNumber);
}
