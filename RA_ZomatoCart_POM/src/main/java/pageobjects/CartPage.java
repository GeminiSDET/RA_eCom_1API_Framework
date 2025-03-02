package pageobjects;

public class CartPage {

	  public double getDiscountedPrice(double cartValue, double offerValue, String offerType) {
	        if (offerType.equals("FLATX")) 
	        {
	            return cartValue - offerValue;
	        } 
	        else if (offerType.equals("FLATP")) 
	        {
	            return cartValue - (cartValue * offerValue / 100);
	        } 
	        else 
	        {
	            return cartValue;
	        }
	    }
}
