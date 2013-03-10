/** Defines a class for maintaining an array of destination objects
 * 
 * Use Java to sort through arrays and filter based on certain criteria 
 * 
 *FILENAME: VacationDestination.java
 * @author: Polina Soshnin
 * @version: September 18, 2012
 *LAST MODIFIED: March 9, 2013
 */
public class VacationDestination {
  
  private Destination[] destinations;  // array of School objects
  private int numDestinations;  // number of School objects stored in array
  

  /** constructor has a single input that is the size of the 
   *destinations array to be initialized
   */ public VacationDestination(int numDestinations) {
       this.numDestinations=0;
       destinations= new Destination[numDestinations];
       //initialize a destinations array of size numDestinations 
   }

  /** instance method creates a new destination object and adds it to the
   *VacationDestination object. If the array in the VacationDestination object is full,
   *method creates a new array twice the size of the existing array, 
   *copies over the elements from the existing array to the new array
   *and then adds the new Destination object
   *
   * @param name Name of destination
   * @param rateSafety Rating of safety for tourists
   * @param rateBudget Rating of feasibility 
   * @param rateClimate Rating of favorable climate
   * @param rateTrans Rating of tourist-friendly transporation
   * @param rateAccom Rating of typical accomodations
   * @param rateFam Rating of family-friendly vacation
   */
    public void addDestination(String name, int rateSafety, int rateBudget, int rateClimate,
     int rateTrans, int rateAccom, int rateFam) {
 
 if(numDestinations<destinations.length) {
     destinations[numDestinations]= new Destination(name, rateSafety, rateBudget, rateClimate, 
         rateTrans,  rateAccom, rateFam);
        numDestinations++; //update number of destinations
 } else {  
     Destination[] newDestination= new Destination[2*numDestinations];
     //creates new array twice size of existing array 
     for (int i=0; i<destinations.length; i++){
  newDestination[i]= destinations[i]; 
  //new array gets contents of old array
     }
     newDestination[numDestinations]=new Destination(name, rateSafety, rateBudget, rateClimate,
          rateTrans, rateAccom, rateFam);
     destinations=newDestination; //assigns new array to destinations array
     numDestinations++; //update number of destinations

     }
    }

  /**Prints information about all of the destination objects
   * in the destinations array
   */
  public void printVacationDestinations () {
    System.out.println("There are " + numDestinations + " vacation destinations in the database:");
    for (int i = 0; i < numDestinations; i++)
      System.out.println(destinations[i]);
    System.out.println();
  }
  
 
  /**Computes overallRating for each destination object
   */ 
    public void computeRatings(int rateSafety, int rateBudget, int rateClimate, 
          int rateTrans, int rateAccom, int rateFam) {
 //goes through all of the destination objects in the destination array and 
 //does a computeRating on them
  for(int i=0; i<numDestinations;i++) 
 destinations[i].computeRanking(rateSafety, rateBudget, rateClimate, rateTrans,
      rateAccom, rateFam);
       
    }


  /** Rank orders the destination objects in the destinations
   * array, either by a single factor or the overallRating as specified
   * by an input String, and prints the names of the destinations in order
   * from highest to lowest rank
   * 
   * @param rank Factor used to rank destinations
   */
    public void rankDestinations(String rank) {

 //from input, setRankValue
 int i; 
 for (i=0; i<numDestinations; i++) {
 if (rank.equals("safety")){
     destinations[i].setRankValue(destinations[i].getRateSafety());}
 if (rank.equals("budget")){
     destinations[i].setRankValue(destinations[i].getRateBudget());}
 if (rank.equals("climate")){
     destinations[i].setRankValue(destinations[i].getRateClimate());} 
 if(rank.equals("trans")){
     destinations[i].setRankValue(destinations[i].getRateTrans());}
 if(rank.equals("accom")) {
     destinations[i].setRankValue(destinations[i].getRateAccom());}
 if(rank.equals("fam")) {
     destinations[i].setRankValue(destinations[i].getRateFam());} 
 if(rank.equals("overall")) {
     destinations[i].setRankValue(destinations[i].getOverallRating());}
    }
 System.out.println("Ranking of destinations from highest to lowest using "+
      rank);
 sortArray(destinations);//sorts destinations
 
  for (int z = 0; z < numDestinations; z++)
      System.out.println(destinations[z].getName()); 
}

  /** Sorts the destination objects in the destinations array in 
   * order of increasing rankValue
   * 
   *@param Destination An array of destionation objects 
   */
    public void sortArray(Destination[] arrayA) {
 int minNum; //minimum rankValue
 int minIndex; //index of minimum rankValue
 int i,j;
 for (j=numDestinations-1; j>0;j--) {
     minIndex=0;
     minNum=arrayA[0].getRankValue(); 
     for(i=1;i<=j;i++)
  if(arrayA[i].getRankValue() < minNum) {
  minNum=arrayA[i].getRankValue();
  minIndex=i;
     }
     swap(arrayA, minIndex, j);
    }
    }
    
  /** exchanges the contents of arrayA[i] and arrayA[j]
   */
  private static void swap (Destination[] arrayA, int i, int j) {
    // exchanges the destinations at locations i and j in arrayA
    Destination temp = arrayA[i];
    arrayA[i] = arrayA[j];
    arrayA[j] = temp;
  }
  
  /** Provides code for testing the methods defined in the
   * VacationDestinations class for maintaining an array of Destionation objects
   */
  public static void main (String[] args) {
    VacationDestination myVacationSpots = new VacationDestination(10);
    // Disclaimer: The ratings here are somewhat arbitrary
    myVacationSpots.addDestination("Greece", 5, 10, 9, 10, 10, 7);
     myVacationSpots.addDestination("Hawaii", 9, 8, 5, 8, 10, 9);
     myVacationSpots.addDestination("Puerto Rico", 6, 9, 9, 7, 8, 6);
     myVacationSpots.addDestination("Thailand", 4, 6, 8, 9, 9, 9);
     myVacationSpots.addDestination("Ecuador", 9, 5, 8, 9, 9, 8);
     myVacationSpots.addDestination("Florida", 4, 7, 7, 7, 7, 7);
     myVacationSpots.addDestination("Egypt", 7, 5, 7, 8, 8, 8);
     myVacationSpots.addDestination("Mexico", 8, 4, 5, 8, 7, 10);
    int weightSafety = 5;
    int weightBudget = 5; 
    int weightClimate = 2;
    int weightTrans= 0;
    int weightAccom = 5;
    int weightFam = 4;
    myVacationSpots.computeRatings(weightSafety, weightBudget, weightClimate,
    weightTrans, weightAccom, weightFam);
    myVacationSpots.printVacationDestinations();


    //TESTING
    System.out.println("******************************************");
    System.out.println("***********TESTING************************");
    System.out.println("Tests all sort cases");
     myVacationSpots.rankDestinations("safety");
    System.out.println();
     myVacationSpots.rankDestinations("budget");
    System.out.println();
     myVacationSpots.rankDestinations("climate");
    System.out.println();
     myVacationSpots.rankDestinations("theory");
    System.out.println();
     myVacationSpots.rankDestinations("trans");
    System.out.println();
    myVacationSpots.rankDestinations("accom");
    System.out.println();
     myVacationSpots.rankDestinations("fam");
    System.out.println();
    System.out.println("****************************************************");
    System.out.println("Adds more destinations into array than there are indices");
    System.out.println("****************************************************");
     myVacationSpots.addDestination("Alaska", 6, 7, 1, 10, 3, 2);
     myVacationSpots.addDestination("Italy", 10, 10, 1, 1, 2, 6);
     myVacationSpots.addDestination("Sri Lanka", 8, 6, 5, 6, 4, 3);
     myVacationSpots.computeRatings(weightSafety, weightBudget, weightClimate,
    weightTrans, weightAccom, weightFam);
    myVacationSpots.printVacationDestinations();
    myVacationSpots.rankDestinations("safety");

  }

  
}