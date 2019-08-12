package com.example.demo.dto;

import com.example.demo.entity.District;
import com.example.demo.entity.Street;

import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.Set;

public class StreetDto {
    private Long id;
    @Size(min = 6, max = 50)
    private String name;
    private long createdAtMLS;
    private String createdAt;
    private long updatedAt;
    private String description;
    private int status;

    private Set<District> districts;
    private int district;

    public StreetDto() {
    }

    public StreetDto(Street street) {
        this.id = street.getId();
        this.name = street.getName();
        this.createdAtMLS = street.getCreatedAt();
        if (createdAtMLS > 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(street.getCreatedAt());
            this.createdAt = calendar.getTime().toString();
        }
        this.updatedAt = street.getUpdatedAt();
        this.description = street.getDescription();
        this.status = street.getStatus();
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
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

    public long getCreatedAtMLS() {
        return createdAtMLS;
    }

    public void setCreatedAtMLS(long createdAtMLS) {
        this.createdAtMLS = createdAtMLS;
    }

    public Set<District> getDistricts() {
        return districts;
    }

    public void setDistricts(Set<District> districts) {
        this.districts = districts;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }
}
