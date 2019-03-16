package com.sindhu.flightReservation.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sindhu.flightReservation.Repos.FlightRepository;
import com.sindhu.flightReservation.Repos.PassengerRepository;
import com.sindhu.flightReservation.Repos.ReservationRepository;
import com.sindhu.flightReservation.dto.ReservationRequest;
import com.sindhu.flightReservation.entities.Flight;
import com.sindhu.flightReservation.entities.Passenger;
import com.sindhu.flightReservation.entities.Reservation;
import com.sindhu.flightReservation.util.EmailUtil;
import com.sindhu.flightReservation.util.PDFGenerator;


@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Value("${com.sindhu.flightReservation.Itinerary.dir}")
	private String Itinerary_Dir ;

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;;
	
	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	PDFGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Override
	public Reservation bookFlight(ReservationRequest reservationRequest) {
	/*
		// Make Payment 
		// For making payment we use @Transactional annotation from spring framework (org.springframework.transaction.annotation) for the class where we make transactions.
		// There are 4 properties for the Bank transactions. Namely, ACID Properties i.e., Automicity, Consistency, Isolation, Durability
		// Automicity means either transaction should happen in both the banks i.e., from one bank account to another or it should happen at all.
		// Consistency means database should be consistent after the transaction i.e., for eg: 500$ should be deducted from one bank account and added to another account after the transaction in database.
		// Isolation means if there are multiple transactions happening from one account then each transaction should be isolate from another 
		// Durability means once the transactional is done then changes in database should be durable.
 	*/
		LOGGER.info("Inside bookFlight()");
		Long flightId = reservationRequest.getFlightId();
		LOGGER.info("Fetching Flight for FlightId: "+flightId);
		Flight flight = flightRepository.findById(flightId).get();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(reservationRequest.getPassengerFirstName());
		passenger.setLastName(reservationRequest.getPassengerLastName());
		passenger.setMiddleName(reservationRequest.getPassengerMiddleName());
		passenger.setEmail(reservationRequest.getPassengerEmail());
		passenger.setPhone(reservationRequest.getPassengerPhone());
		LOGGER.info("Saving the Passenger: "+passenger);
		passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setCheckedIn(false);
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		LOGGER.info("Saving the reservation: "+reservation);
		Reservation savedReservation = reservationRepository.save(reservation);
		
		String filePath = Itinerary_Dir+savedReservation.getId()+".pdf";
		LOGGER.info("Generating the PDF for Itinerary ");
		pdfGenerator.generateItinerary(savedReservation, filePath);
		LOGGER.info("Emailing the Itinerary");
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		return savedReservation;
	}

}
