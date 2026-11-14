
package com.hostel.service;

import com.hostel.entity.Hostel;
import com.hostel.repository.HostelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostelService {

    private final HostelRepository hostelRepository;

    public HostelService(HostelRepository hostelRepository) {
        this.hostelRepository = hostelRepository;
    }

    public Hostel addHostel(Hostel hostel) {
        return hostelRepository.save(hostel);
    }

    public List<Hostel> getAllHostels() {
        return hostelRepository.findAll();
    }

    public Optional<Hostel> getHostelById(Integer id) {
        return hostelRepository.findById(id);
    }

    public Hostel updateHostel(Integer id, Hostel updatedHostel) {

        Hostel existingHostel = hostelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hostel not found"));

        existingHostel.setHostelName(updatedHostel.getHostelName());
        existingHostel.setHostelType(updatedHostel.getHostelType());
        existingHostel.setTotalRooms(updatedHostel.getTotalRooms());
        existingHostel.setWardenName(updatedHostel.getWardenName());
        existingHostel.setWardenPhone(updatedHostel.getWardenPhone());

        return hostelRepository.save(existingHostel);
    }

    public void deleteHostel(Integer id) {

        Hostel hostel = hostelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hostel not found"));

        hostelRepository.delete(hostel);
    }
}
