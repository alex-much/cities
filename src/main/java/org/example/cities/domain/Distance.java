package org.example.cities.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Distance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String from_city;
    private String to_city;
    private Float distance;

    public Distance() {
    }

    public Distance(String from_city, String to_city, Float distance) {
        this.from_city = from_city;
        this.to_city = to_city;
        this.distance = distance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom_city() {
        return from_city;
    }

    public void setFrom_city(String from_city) {
        this.from_city = from_city;
    }

    public String getTo_city() {
        return to_city;
    }

    public void setTo_city(String to_city) {
        this.to_city = to_city;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }
}
