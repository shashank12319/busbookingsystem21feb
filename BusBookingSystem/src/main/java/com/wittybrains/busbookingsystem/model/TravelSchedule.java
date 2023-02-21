package com.wittybrains.busbookingsystem.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table(name="travelschedule")
//public class TravelSchedule {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long scheduleId;
////    @ManyToOne
////    private Driver driver;
//    @ManyToOne
//    private Bus bus;
//    
//    private String source;
//    private String destination;
//    private Double fareAmount;
//    private LocalDateTime estimatedArrivalTime;
//    private LocalDateTime estimatedDepartureTime;
//    
//	public Long getScheduleId() {
//		return scheduleId;
//	}
//	public void setScheduleId(Long scheduleId) {
//		this.scheduleId = scheduleId;
//	}
//	public Bus getBus() {
//		return bus;
//	}
//	public void setBus(Bus bus) {
//		this.bus = bus;
//	}
//	public String getSource() {
//		return source;
//	}
//	public void setSource(String source) {
//		this.source = source;
//	}
//	public String getDestination() {
//		return destination;
//	}
//	public void setDestination(String destination) {
//		this.destination = destination;
//	}
//	public Double getFareAmount() {
//		return fareAmount;
//	}
//	public void setFareAmount(Double fareAmount) {
//		this.fareAmount = fareAmount;
//	}
//	public LocalDateTime getEstimatedArrivalTime() {
//		return estimatedArrivalTime;
//	}
//	public void setEstimatedArrivalTime(LocalDateTime estimatedArrivalTime) {
//		this.estimatedArrivalTime = estimatedArrivalTime;
//	}
//	public LocalDateTime getEstimatedDepartureTime() {
//		return estimatedDepartureTime;
//	}
//	public void setEstimatedDepartureTime(LocalDateTime estimatedDepartureTime) {
//		this.estimatedDepartureTime = estimatedDepartureTime;
//	}
//	
//    
//}
@Entity
@Table(name="travelschedule")
public class TravelSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @ManyToOne
    private Bus bus;

    //@ManyToOne
    private String source;

    //@ManyToOne
    private String destination;

    private Double fareAmount;
    private LocalDateTime estimatedArrivalTime;
    private LocalDateTime estimatedDepartureTime;

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getFareAmount() {
        return fareAmount;
    }

    public void setFareAmount(Double fareAmount) {
        this.fareAmount = fareAmount;
    }

    public LocalDateTime getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(LocalDateTime estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    public LocalDateTime getEstimatedDepartureTime() {
        return estimatedDepartureTime;
    }

    public void setEstimatedDepartureTime(LocalDateTime estimatedDepartureTime) {
        this.estimatedDepartureTime = estimatedDepartureTime;
    }
}
