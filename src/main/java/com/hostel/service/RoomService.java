
package com.hostel.service;

import com.hostel.entity.Room;
import com.hostel.repository.RoomRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    public Optional<Room> getRoomById(Integer id) {
        return roomRepository.findById(id);
    }
    public Room updateRoom(Integer id, Room updatedRoom) {

        Room existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
        existingRoom.setRoomType(updatedRoom.getRoomType());
        existingRoom.setCapacity(updatedRoom.getCapacity());
        existingRoom.setOccupied(updatedRoom.getOccupied());
        existingRoom.setPrice(updatedRoom.getPrice());
        existingRoom.setStatus(updatedRoom.getStatus());
        existingRoom.setHostel(updatedRoom.getHostel());

        return roomRepository.save(existingRoom);
    }
    public void deleteRoom(Integer id) {

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        roomRepository.delete(room);
    }

}
