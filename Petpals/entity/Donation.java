package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Donation {
	    private String donorName;
	    private LocalDate donationDate;
	    private int donation_id;
	    private String donation_type;

	    public Donation(String donorName, LocalDate donationDate2,int donation_id,String donation_type) {
	        this.donorName = donorName;
	        this.donationDate = donationDate2;
	        this.donation_id=donation_id;
	        this.donation_type=donation_type;
	    }


	    public String getDonorName() {
	        return donorName;
	    }

	    public LocalDate getDonationDate() {
	        return donationDate;
	    }
	    public double getDonation_id() {
	        return donation_id;
	    }
	    
	    public String getDonation_type(){
	    	return donation_type;
	    }
	    
	    public abstract void recordDonation();

}