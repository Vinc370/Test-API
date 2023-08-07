package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_m_region")
public class Region {
    @Id
    private int region_id;
    private String name;
    private float latitude;
    private float longitude;

    public Region(){
        
    }

    public Region(int region_id, String name, float latitude, float longitude){
        setRegionID(region_id);
        setName(name);
        setLatitude(latitude);
        setLongitude(longitude);
    }

    public int getRegionID() {
        return region_id;
    }
    public void setRegionID(int region_id) {
        this.region_id = region_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getLatitude() {
        return latitude;
    }
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    public float getLongitude() {
        return longitude;
    }
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
