package com.sindhu.flightReservation.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="FLIGHT")
public class Flight extends AbstractEntity{
	@Column(name="FLIGHT_NUMBER")
	private String flightNumber;
	@Column(name="OPERATING_AIRLINES")
	private String operatingAirLines;
	@Column(name="DEPARTURE_CITY")
	private String departureCity;
	@Column(name="ARRIVAL_CITY")
	private String arrivalCity;
	@Column(name="DATE_OF_DEPARTURE")
	private Date dateOfDeparture;
	@Column(name="ESTIMATED_DEPARTURE_TIME")
	private Timestamp estimatedDepartureTime;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOperatingAirLines() {
		return operatingAirLines;
	}

	public void setOperatingAirLines(String operatingAirLines) {
		this.operatingAirLines = operatingAirLines;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public Timestamp getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}

	public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", operatingAirLines=" + operatingAirLines + ", departureCity="
				+ departureCity + ", arrivalCity=" + arrivalCity + ", dateOfDeparture=" + dateOfDeparture
				+ ", estimatedDepartureTime=" + estimatedDepartureTime + "]";
	}

}
