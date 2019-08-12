package com.example.demo.entity;

import com.example.demo.dto.StreetDto;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private long createdAt;
    private long updatedAt;
    private String description;
    private int status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="district_id")
    private District district;

    public Street() {
    }

    public Street(String name, String description, int status) {
        this.name = name;
        this.createdAt = Calendar.getInstance().getTimeInMillis();
        this.updatedAt = Calendar.getInstance().getTimeInMillis();
        this.description = description;
        this.status = 1;
    }

    public Street(StreetDto streetDto) {
        this.id = streetDto.getId();
        this.name = streetDto.getName();
        this.description = streetDto.getDescription();
        this.createdAt = streetDto.getCreatedAtMLS();
        this.updatedAt = Calendar.getInstance().getTimeInMillis();
        this.status = streetDto.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
