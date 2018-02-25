
package Game;
/**
 * Class DeckOfCards
 * File Name : DeckOfCards.java
 * Description : A class that contains a deck of card with size
 *                 of 52 cards (13 from each suit)
 * Date : 02/27/2016
 * @author Natasha Efendy
 */

public class DeckOfCards 
{
    private final int SIZE = 52;
    private int[] cards;
    private int counter = 0;
    
    
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : DeckOfCards()
     * Description: default constructor
     * Returns : none
     * Date: 02/27/2016
     * @param None
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
    public DeckOfCards()
    {
        initializeCards();
    }
    
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : initializeCards()
     * Description: create each individual card numbers
     * Returns : none
     * Date: 02/27/2016
     * @param none
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 
    private void initializeCards()
    {
        cards  =  new int[SIZE];
        
        for(int i = 0; i<52;i++)
            cards[i] = i+1;
        
    }
    
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : getCard()
     * Description: returns random card from deck
     * Returns : randomizeCards()
     * Date: 02/27/2016
     * @param none
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 
    public int getCard()
    {
        return randomizeCards();
    }
    
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : randomizeCards()
     * Description: get a random card from deck
     * Returns : int index
     * Date: 02/27/2016
     * @param none
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 
    private int randomizeCards()
    {

        int random = (int)(Math.random()*(SIZE-counter-1)+0);
        int index = cards[random];
        swap(cards,random,counter);
        counter++;  
        
        return index;
    }
    
    
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : swap()
     * Description: swap position of two cards
     * Date: 02/27/2016
     * Returns : none
     * @param None
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */
    private void swap (int[] myArray ,int index, int n)
    {
        int temp = myArray[myArray.length - 1 - n];
        myArray[myArray.length - 1 - n] = myArray[index];
        myArray[index] = temp;
    }
         
    
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : toNumber
     * Description: return the rank of each card
     * Date: 02/27/2016
     * Returns : int card
     * @param int card
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */
    public int toNumber(int card)
    {
   
      if(card > 13)
      {
           do
           {
               card -= 13;
           }while (card > 13);
           
           return card;  
      }
      else
          return card; //cards that are <= 13 returns itself
      
    }
    
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : resetDeck()
     * Description: reset deck to its original order 
     * Date: 02/27/2016
     * Returns : none
     * @param None
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */
    public void resetDeck()
    {
        //reset counter for random
        counter  = 0;
        
        //return deck to original arrangement
        //'put back' cards that are taken at random
        selectionSort(cards);
    }
    
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : selectionSort()
     * Description: sort an array in ascending order
     * Returns : none
     * Date: 02/27/2016
     * @param int[] num
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 
    private void selectionSort(int[] deck)
    {
	for(int i = deck.length - 1; i >= 0; i--)		
	{
		int high = i;				
		for(int j = i; j >= 0; j--)		
								
		{
			if(deck[j] > deck[high])	
				high = j;		
		}
		//swap cards!
		int temp = deck[i];
		deck[i] = deck[high];
		deck[high] = temp;
	}

    }
}
