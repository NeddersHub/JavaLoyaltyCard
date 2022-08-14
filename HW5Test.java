/**
 * Class to test Homework 5
 * 
 * @author Nathan Edmond 
 * @version (a version number or a date)
 */
public class HW5Test
{    
    private int mark;
    private String name, id;
    private LoyaltyCardArrayClass members;
    private int numberOfCreatedCards;

    /**
     * Constructor for objects of class HW5Test
     * 
     * @param name the student's name
     * @param id the student's id
     */
    public HW5Test(String name, String id)
    {
        this.name = name;
        this.id = id;
        mark = 0;
        numberOfCreatedCards = 0;
        runTests();
    }
    
    /*
     * reset variables to allow run tests to be run twice.
     */
    private void reset()
    {
        mark = 0;
        numberOfCreatedCards = 0;
    }
    
    /**
     * Run the various tests
     */
    public void runTests()
    {
        // print header
        System.out.println("Name: " + name + "\tID: " + id + "\n");
        
        reset();
        testCreateArray();
        testAddLoyaltyCard();
        testCapacity();
        testNumberOfElements();
        testValidSearch();
        testInvalidSearch();
        testRemoveValidLoyaltyCard();
        testRemoveInvalidLoyaltyCard();
        testValidPrintLoyaltyCard();
        testInvalidPrintLoyaltyCard();
        testPrintAllLoyaltyCards();
        
        System.out.println("Name: " + name + "\tID: " + id 
                           + "\t\tFinal Calculated Mark: "+mark+"\n");
        System.out.println("Up to 3 additional marks: Maximum of 12 marks. "                    
                    + "\nStudent should now print the contents of the terminal window.");        
    }
      
    /**
     * Instantiate a simple array of size 3
     */
    public void testCreateArray()
    {
        members = new LoyaltyCardArrayClass(3);    
    }
    
    /**
     * Create 3 cards
     * One mark for each
     */
    public void testAddLoyaltyCard()
    {
        try
        {
            members.addLoyaltyCard(new LoyaltyCard ("Dr","Ann", "Archer", 
                                          "1 Amble Way", "Amble", "AA1 1AA"
                                          ,"1000"));
            System.out.println("Archer added. Mark so far: " + (++mark));
            numberOfCreatedCards++;
        
            members.addLoyaltyCard(new LoyaltyCard ("Ms", "Barbara", "Bach", 
                                          "2 Blyth Boulevard", "Blyth", "BB2 2BB",
                                          "1001"));
            System.out.println("Bach added. Mark so far: " + (++mark));
            numberOfCreatedCards++;
        
            members.addLoyaltyCard(new LoyaltyCard ("Mr", "Colin", "Cowdry",
                                          "3 Carlisle Crecent", "Carlisle", "CC3 3CC",
                                           "1002"));
            System.out.println("Cowdry added. Mark so far: " + (++mark));
            numberOfCreatedCards++;
        }
        catch (Exception e)
        {
            System.out.println("An exception was raised in testAddLoyaltyCard. Current mark ="+mark);
        }
    }
    
    /**
     * Test capacity - one mark
     */
    public void testCapacity()
    {
        try
        {
            if(members.getCapacity() == numberOfCreatedCards)
            { 
                System.out.println("Capacity correct(" + (members.getCapacity()) 
                                   + "). Mark so far: " + (++mark));
            }
            else
            {
            System.out.println("Capacity incorrect(" + (members.getCapacity()) + "). No Mark!");
            }
        }
        catch(Exception e)
        {
            System.out.println("An exception was raised in testCapacity. Current mark ="+mark);
        }
    }
    
    /**
     * Test number of elements populated
     */    
    public void testNumberOfElements()
    {
        // Test for correct number of loyalty cards
        try
        {
            if(members.getNumberOfLoyaltyCards() == numberOfCreatedCards)
            { 
                System.out.println("Number of elements correct(" 
                          + (members.getNumberOfLoyaltyCards()) + "). Mark so far: " + (++mark));
            }
            else
            {
                System.out.println("Number of elements incorrect(" 
                          + (members.getNumberOfLoyaltyCards()) + "). No Mark!");
            }
        }
        catch(Exception e)
        {
            System.out.println("An exception was raised in testNumberOfElements. "
                                 + "Current mark = "+mark);
        }
    }
    
    /**
     * Test valid search
     */
    public void testValidSearch()
    {
        try
        {
            int searchValue = members.search("1002");
            if(searchValue == 2)
            { 
                System.out.println("testValidSearch returned correct value: " 
                              + searchValue + ".  Mark so far: " + (++mark));
            }
            else
            {
                System.out.println("testValidSearch returned incorrect value:"
                              + searchValue + ".  No Mark!");
            }
        }
        catch(Exception e)
        {
            System.out.println("An exception was raised in testValidSearch. Current mark = "+mark);
        }        
    }
    
    /**
     * Test invalid search
     */
    public void testInvalidSearch()
    {
        try
        {
            int searchValue = members.search("1234");
            if(searchValue == -1)
            { 
                System.out.println("testInvalidSearch returned correct value:" 
                              + searchValue + ".  Mark so far: " + (++mark));
            }
            else
            {
                System.out.println("testInvalidSearch returned incorrect value:" + searchValue + ".  No Mark!");
            }
        }
        catch(Exception e)
        {
            System.out.println("An exception was raised in testInvalidSearch. Current mark ="+mark);
        }        
    }
       
    /**
     * Test removal of a valid loyalty card
     */
    public void testRemoveValidLoyaltyCard()
    {
        try
        {
            members.removeLoyaltyCard("1002");
            System.out.println("TestRemoveValidLoyaltyCard - Number of loyalty cards now:" 
                                   + members.getNumberOfLoyaltyCards());
        
            if(members.getNumberOfLoyaltyCards() == numberOfCreatedCards -1)
            { 
                System.out.println("Removal suceeded. Mark so far: " + (++mark));
                numberOfCreatedCards--;
            }
            else
            {
                System.out.println("removal incorrect. No Mark!");
            }
        }
        catch(Exception e)
        {
            System.out.println("An exception was raised in testRemoveValidLoyaltyCard. "
                                + "Current mark ="+mark);
        }
    }
    
    /**
     * Test removal of a invalid loyalty card
     */
    public void testRemoveInvalidLoyaltyCard()
    {
        try
        {
            System.out.println("\ntestRemoveInvalidLoyaltyCard:");
            members.removeLoyaltyCard("999");
        
            if(members.getNumberOfLoyaltyCards() == numberOfCreatedCards)
            { 
            
                System.out.println("Number of cards still:" 
                                + members.getNumberOfLoyaltyCards()+". Mark so far: " + (++mark));
            }
            else
            {
                System.out.println("removal incorrect. No Mark!");
            }
        }
        catch(Exception e)
        {
            System.out.println("An exception was raised in testRemoveInvalidLoyaltyCard. "
                                + "Current mark ="+mark);
        }
    }
    
    /**
     * Test printing of valid loyalty card
     */
    public void testValidPrintLoyaltyCard()
    {
        try
        {
             System.out.println("\ntestValidPrintLoyaltyCard:");        
             System.out.println("Output should be:\nMs Barbara Bach\n2 Blyth Boulevard\n"
                                + "Blyth\nBB2 2BB\nCard Number: 1001\n"
                                + "Points available: 0\n\nACTUAL OUTPUT:");
             members.printLoyaltyCard("1001");
             System.out.println("ADD ONE MARK IF CORRECT.");       
        }
        catch(Exception e)
        {
            System.out.println("An exception was raised in testValidPrintLoyaltyCard. "
                                + "Current mark ="+mark);
        }     
    }
    
    public void testInvalidPrintLoyaltyCard()
    {
        try
        {
            System.out.println("\ntestInvalidPrintLoyaltyCArd");
            System.out.println("Output should be:\nLoyalty card with card number: 1003 not found.\n"
                                + "\n\nACTUAL OUTPUT:");
            members.printLoyaltyCard("1003");
            System.out.println("ADD ONE MARK IF CORRECT.");
        }
        catch(Exception e)
        {
            System.out.println("An exception was raised in testInvalidPrintLoyaltyCard. "
                               + "Current mark ="+mark);
        }
    }
    
    /**
     * Test printing of valid loyalty cards
     */
    public void testPrintAllLoyaltyCards()
    {
        try
        {
            System.out.println("\n************* Name: " + name + "\tID: " + id + " ****************");
            System.out.println("\ntestPrintAllLoyaltyCards\nOutput should be:\n");
            System.out.println("Dr Ann Archer\n1 Amble Way\nAmble\nAA1 1AA\nCard Number: "
                              + "1000\nNumber of points: 0\n\n"
                              + "Ms Barbara Bach\n2 Blyth Boulevard\nBlyth\nBB2 2BB\nCard Number: "
                              + "1001\nNumber of points: 0\n\nACTUAL OUTPUT:");
            members.printAllLoyaltyCards();
            System.out.println("ADD ONE MARK IF CORRECT.");
        }
        catch(Exception e)
        {
            System.out.println("An exception was raised in testPrintAllLoyaltyCards. "
                                + "Current mark ="+mark);
        }
    
    System.out.println("************************* Testing complete *************************\n");
    } 
} // end class
