
package com.hostel.controller;

import com.hostel.entity.Complaint;
import com.hostel.service.ComplaintService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    // Get all complaints
    @GetMapping
    public List<Complaint> getAllComplaints() {
        return complaintService.getAllComplaints();
    }

    // Get complaint by ID
    @GetMapping("/{id}")
    public Complaint getComplaintById(@PathVariable Integer id) {
        return complaintService.getComplaintById(id).orElseThrow();
    }

    // Add complaint
    @PostMapping
    public Complaint addComplaint(@RequestBody Complaint complaint) {
        return complaintService.addComplaint(complaint);
    }

    // Update complaint
    @PutMapping("/{id}")
    public Complaint updateComplaint(
            @PathVariable Integer id,
            @RequestBody Complaint complaint) {

        return complaintService.updateComplaint(id, complaint);
    }

    // Delete complaint
    @DeleteMapping("/{id}")
    public String deleteComplaint(@PathVariable Integer id) {

        complaintService.deleteComplaint(id);

        return "Complaint deleted successfully!";
    }
}
