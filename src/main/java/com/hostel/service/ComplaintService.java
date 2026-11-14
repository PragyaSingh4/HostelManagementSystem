
package com.hostel.service;

import com.hostel.entity.Complaint;
import com.hostel.repository.ComplaintRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    public ComplaintService(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    public Complaint addComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public Optional<Complaint> getComplaintById(Integer id) {
        return complaintRepository.findById(id);
    }

    public Complaint updateComplaint(Integer id, Complaint updatedComplaint) {

        Complaint existingComplaint = complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        existingComplaint.setComplaintType(updatedComplaint.getComplaintType());
        existingComplaint.setDescription(updatedComplaint.getDescription());
        existingComplaint.setComplaintDate(updatedComplaint.getComplaintDate());
        existingComplaint.setStatus(updatedComplaint.getStatus());
        existingComplaint.setStudent(updatedComplaint.getStudent());

        return complaintRepository.save(existingComplaint);
    }

    public void deleteComplaint(Integer id) {

        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        complaintRepository.delete(complaint);
    }
}
