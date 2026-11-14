package com.hostel.repository;

import java.util.List;
import com.hostel.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {

    List<Complaint> findByStatus(String status);
}
