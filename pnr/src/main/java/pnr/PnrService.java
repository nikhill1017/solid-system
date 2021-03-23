package pnr;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import pnr.Passenger.Gender;
import pnr.Passenger.Status;

@Path("/pnr")
public class PnrService {
	@GET
	public PnrStatus check(@QueryParam("pnrNo") int pnrNo, @Context HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin","*");
		PnrStatus pnrStatus = new PnrStatus();
        pnrStatus.setPnrNo(pnrNo);
        pnrStatus.setTrainNo(12345);
        pnrStatus.setTravelDate(LocalDate.of(2021, 03, 18));
        
        List<Passenger> passengers = new ArrayList<>();
        Passenger p1 = new Passenger();
        p1.setName("Tanmay");
        p1.setGender(Gender.MALE);
        p1.setStatus(Status.CONFIRMED);
        
        Passenger p2 = new Passenger();
        p2.setName("Aditya");
        p2.setGender(Gender.MALE);
        p2.setStatus(Status.RAC);
        
        passengers.add(p1);
        passengers.add(p2);
        
        pnrStatus.setPassengers(passengers);
        
        return pnrStatus;
		
		
	}
}
