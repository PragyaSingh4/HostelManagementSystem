
package com.hostel.controller;

import com.hostel.entity.Room;
import com.hostel.service.RoomService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // Get all rooms
    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    // Get room by ID
    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Integer id) {
        return roomService.getRoomById(id).orElseThrow();
    }

    // Add room
    @PostMapping
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    // Update room
    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Integer id,
                           @RequestBody Room room) {
        return roomService.updateRoom(id, room);
    }

    // Delete room
    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable Integer id) {
        roomService.deleteRoom(id);
        return "Room deleted successfully!";
    }
}
