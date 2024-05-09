package apis.heroku;

import lombok.Data;

@Data


public class PayloadPojo  {
	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositpaid;
	private PayloadBookingdatesPojo bookingdates;
	private String additionalneeds;
}