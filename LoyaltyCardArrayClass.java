
/**
 * This class utilises a simple array to hold Loyalty Cards
 * and enables the user to modify and search through the list.
 *
 * @author Nathan Edmond / w14025063
 * @version 1.0
 */
public class LoyaltyCardArrayClass
{
    public int currentIndex; //Tracks current index position
    private LoyaltyCard[] loyaltyCards; //Array to hold cards

    /**
     * Constructor for objects of class LoyaltyCardArrayClass
     * Instantiates the basic array and sets current index to 0
     * 
     * @param manNoOfLoyaltyCards Number of items the array can hold
     */
    public LoyaltyCardArrayClass(int maxNoOfLoyaltyCards)
    {
         loyaltyCards = new LoyaltyCard[maxNoOfLoyaltyCards];
         currentIndex = 0;
    }

    /**
     * This will add the chosen loyaltyCard at the 
     * currentIndex position
     *
     * @param  loyaltyCard The LoyaltyCard to be added
     */
    public void addLoyaltyCard(LoyaltyCard loyaltyCard)
    {
        if (currentIndex <= loyaltyCards.length)
        {
            loyaltyCards[currentIndex] = loyaltyCard;
            currentIndex ++;
        }
        else
        {
            System.out.println("Membership full. Could not add LoyaltyCard");
        }
    }

    /**
     * This gets the number of cards in the array
     * 
     * @return the number of cards in the array
     */
    public int getNumberOfLoyaltyCards()
    {
        return currentIndex;
    }
  
    /**
     * This gets the number of cards the array can hold 
     * 
     * @return The max capacity of the array
     */
    public int getCapacity()
    {
        return loyaltyCards.length;
    }
    
    /**
     * This will print out details of all loyalty cards
     * that are in the array
     */
    public void printAllLoyaltyCards()
    {   
        for (int i = 0 ; i< loyaltyCards.length ; i++)
        {
            if (loyaltyCards[i] != null){
                loyaltyCards[i].printCustomerDetails();
                System.out.println();
            }
        }
    }
    
    /**
     * This will print out details of one specific card given by the user
     * 
     * @param cardNumber The card number you want to print out details for
     * @return True if the cardnumber exists, false if not.
     */
    public boolean printLoyaltyCard(String cardNumber)
    {
       int index = 0;
       for (int i = 0 ; i< loyaltyCards.length ; i++)
       {
           if (loyaltyCards[i] != null && cardNumber.equals(loyaltyCards[i].getCardNumber()))
           {
               loyaltyCards[i].printCustomerDetails();
               return true;
           }
       }
       System.out.println("Loyalty card with card number: " +cardNumber+ " not found.");
       return false;
    }
    
    /**
     * Will remove a loyaltycard from the array based on a given cardnumber
     * 
     * @param cardNumber The card number which you want to remove
     * @return True if a card was removed, false if not
     */
    public boolean removeLoyaltyCard(String cardNumber)
    {
        for (int i = 0 ; i< loyaltyCards.length ; i++)
        {
           if (loyaltyCards[i] != null && cardNumber.equals(loyaltyCards[i].getCardNumber()))
           {
               int cardindex = search(cardNumber);
               squash(cardindex);
               return true;
           }
        }
        System.out.println("Card number with number " +cardNumber+ " not found.");
        return false;
    }
    
    /**
     * This will search the array and return the index for a given card number
     * 
     * @param cardNumber The cardnumber you want to find the index for
     * @return The index position of the card if found or -1 if it isn't found
     */
    public int search(String cardNumber)
    {
       int index = 0;
       for (int i=0; i< loyaltyCards.length; i++)
       {
           if (loyaltyCards[i] != null && cardNumber.equals(loyaltyCards[i].getCardNumber()))
           {
               System.out.println("found card in index: " +i);
               return i;
           }
       }
       System.out.println("couldnt find card with index: " + cardNumber);
       return -1;
    }
    
    /**
     * If there is a space from card removal this will squash
     * the empty cell
     * 
     * @param index The index position of the empty cell
     */
    public void squash(int index)
    {
        if ( index >= 0 )
        {
            for ( int i = index ; i < currentIndex - 1 ; i++)
            loyaltyCards[i]= loyaltyCards[i+1];
            loyaltyCards[currentIndex-1] = null;
            currentIndex--;
        }
    }
}
