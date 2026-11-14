
package com.hostel.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "hostels")
public class Hostel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hostel_id")
    private Integer hostelId;

    @Column(name = "hostel_name")
    private String hostelName;

    @Column(name = "hostel_type")
    private String hostelType;

    @Column(name = "total_rooms")
    private Integer totalRooms;

    @Column(name = "warden_name")
    private String wardenName;

    @Column(name = "warden_phone")
    private String wardenPhone;

    public Integer getHostelId() {
        return hostelId;
    }

    public void setHostelId(Integer hostelId) {
        this.hostelId = hostelId;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public String getHostelType() {
        return hostelType;
    }

    public void setHostelType(String hostelType) {
        this.hostelType = hostelType;
    }

    public Integer getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(Integer totalRooms) {
        this.totalRooms = totalRooms;
    }

    public String getWardenName() {
        return wardenName;
    }

    public void setWardenName(String wardenName) {
        this.wardenName = wardenName;
    }

    public String getWardenPhone() {
        return wardenPhone;
    }

    public void setWardenPhone(String wardenPhone) {
        this.wardenPhone = wardenPhone;
    }
}
