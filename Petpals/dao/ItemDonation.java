package dao;

import java.time.LocalDate;
import java.time.LocalDateTime;

import entity.Donation;

public class ItemDonation extends Donation{
	private String item;
	private double item_quantity;

    public ItemDonation(String donorName,String item,int item_quantity,int donation_id,String donation_type,LocalDate donationDate) {
        super(donorName, donationDate,donation_id,donation_type);
        this.item_quantity = item_quantity;
        this.item=item;
    }

    @Override
    public void recordDonation() {
        System.out.println("Recording ItemDonation donation: " + this);
    }
    
    public String getItem() {
        return item;
    }
    public double getItemQuantity() {
        return item_quantity;
    }

    @Override
    public String toString() {
        return "ItemDonation [donorName=" + getDonorName() + ", donationDate=" + getDonationDate() + "]";
    }
}