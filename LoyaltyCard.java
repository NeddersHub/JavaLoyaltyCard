/**
 * Represents a loyalty card for a fictional university
 * bookshop.
 * 
 * This class will be developed during subsequent homeworks.
 * 
 * Amended to include address functionality for the card.
 * 
 * @author A Maughan
 * @version 2.0
 */
public class LoyaltyCard
{
    private String title, firstName, lastName;       
    private LoyaltyCardAddress address;
    private String cardNumber;  
    private int points;    
    
    /**
     * Constructor for objects of class LoyaltyCard where they obtain 
     * a card without purchasing any book(s) at that point.
     * 
     * The number of points / spend should be set to 0.
     * 
     * @param theTitle      The customer's title
     * @param theFirstName  The customer's first name 
     * @param theLastName   The customer's last name
     * @param theCardNumber The number for this card
     * @param street        The street
     * @param town          The town
     * @param postcode      The postcode
     */
    public LoyaltyCard(String theTitle, String theFirstName, 
                          String theLastName, String street, 
                          String town, String postcode, 
                          String theCardNumber)
    {
        title = theTitle;       
        firstName = theFirstName;
        lastName = theLastName;
        address = new LoyaltyCardAddress(street, town, postcode);
        cardNumber = theCardNumber;
        points = 0;
    }
    
    /**
     * Constructor for objects of class Customer where they purchase 
     * a book(s) at the same time as they obtain their card.
     * 
     * @param theTitle      The customer's title
     * @param theFirstName  The customer's first name 
     * @param theLastName   The customer's last name
     * @param theCardNumber The number for this card
     * @param street        The street
     * @param town          The town
     * @param postcode      The postcode
     * @param thePoints     The number of points earned - could be zero.
     */
    public LoyaltyCard(String theTitle, String theFirstName, 
                          String theLastName, String street, 
                          String town, String postcode, 
                          String theCardNumber, int thePoints)
    {
        title = theTitle;
        firstName = theFirstName;
        lastName = theLastName;
        address = new LoyaltyCardAddress(street, town, postcode);
        cardNumber = theCardNumber;
        points = thePoints;               
    }
    
    // accessors   
    
    /**
     * Get the Customer's title
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Get the Customer's first name
     * 
     * @return the Customer's first name
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * Get the Customer's last name
     * 
     * @return the Customer's last name
     */
    public String getLastName()
    {
        return lastName;
    }
    
    /**
     * Return the Customer's address
     * 
     * @return the Customer's address
     */
    public String getAddress()
    {
        return address.getFullAddress();
    }
   
    /**
     * Get the Customer's card Number
     * 
     * @return the Customer's card number
     */
    public String getCardNumber()
    {
        return cardNumber;
    }    
      
    /**
     * Get the number of points earned
     * 
     * @param thePoints The number of points collected.
     * @return the number of points available.
     */
    public double getPoints()
    {
        return points;
    }
    
    /**
     * Record a new title
     * 
     * @param title the revised title
     */
    public void setTitle(String newTitle)
    {
        title = newTitle;
    }
    
    /**
     * Record a new firstName
     * 
     * @param newFirstName the revised first name
     */
    public void setFirstName(String newFirstName)
    {
        firstName = newFirstName;
    }
    
    /**
     * Record a new last name
     * 
     * @param newLastName the revised last name
     */
    public void setLastName(String newLastName)
    {
        lastName = newLastName;
    }
            
    /**
     * Record a new spend and add it to the current amount.
     * 
     * @param theSpend the amount spent
     */
    public void setRevisedPoints(int thePoints)
    {
        points = points + thePoints;
    }
        
    /**
     * Change the Customer's address
     * 
     * @param street the street
     * @param town the town
     * @param postcode the postcode
     */
    public void setAddress(String street, String town, String postcode)
    {
        address.setFullAddress(street, town, postcode);
    }
    
    /**
     * Print out Customer's address
     */
    public void printAddress()
    {
        address.printAddress();
    }
           
    /**
     * Output the Customer's details
     */
    public void printCustomerDetails()
    {
        System.out.println(title + " " + firstName + " " 
            + lastName + "\n" +getAddress() 
            + "\nCard Number: " + cardNumber 
            + "\nPoints available: " + points);
    }
} // end LoyaltyCard class
