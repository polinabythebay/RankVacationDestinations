/** Defines a class of destination objects that store information
 * about individual vacation destinations
 *
 *FILENAME: Destination.java
 * @author: Polina Soshnin
 * @version: September 18, 2012
 *LAST MODIFIED: March 9, 2013
*/

public class Destination {  

  // ratings are assumed to be an integer from 1 to 10
  private String name;         // name of destination
  private int rateSafety;       // rating of safety 
  private int rateBudget;       // rating of budget accomodation
  private int rateClimate;      // rating of warm vs cold climate
  private int rateTrans;      // rating of transporation 
  private int rateAccom;      // rating of quality of standard accomodations/hotel 
  private int rateFam;        // rating of how family friendly desination is
  private int overallRating;   // overall rating that uses all six factors
  private int rankValue;       // value used to rank destinations, based on one
                               // factor or all factors combined
 
  /** 7-argument constructor has inputs that correspond to the first
   *7 instance variables of the Destination class to create a Destination object
   */
    public Destination(String name, int rateSafety, int rateBudget, int rateClimate, 
    int rateTrans, int rateAccom, int rateFam){
 this.name= name; //instance var name gets param name
 this.rateSafety=rateSafety;
 this.rateBudget=rateBudget;
 this.rateClimate=rateClimate;
 this.rateTrans=rateTrans;
 this.rateAccom=rateAccom;
 this.rateFam=rateFam;
 this.overallRating=0; //initialized to zero
 this.rankValue=0; //initialized to zero

    }
 
  //Each return the value of one instance variable

  public String getName () {
    return name;
  }

  public int getRateSafety () {
    return rateSafety;
  }

  public int getRateBudget () {
    return rateBudget;
  }

  public int getRateClimate () {
    return rateClimate;
  }

  public int getRateTrans () {
    return rateTrans;
  }

  public int getRateAccom () {
    return rateAccom;
  }

  public int getRateFam () {
    return rateFam;
  }

  public int getOverallRating () {
    return overallRating;
  }

  public int getRankValue () {
    return rankValue;
  }
  
  //Sets the rankValue instance variable to a new value

  public void setRankValue (int newValue) {
    rankValue = newValue;
  }

  /** Returns a String containing the information
   * stored in a single destination object
   */
  public String toString () {
    String S = "\n Name: " + name;
    S = S + "\n Rating of safety: " + rateSafety;
    S = S + "\n Rating of budget: " + rateBudget;
    S = S + "\n Rating of climate: " + rateClimate;
    S = S + "\n Rating of transportation: " + rateTrans;
    S = S + "\n Rating of accomodations: " + rateAccom;
    S = S + "\n Rating of family friendliness: " + rateFam;
    S = S + "\n Overall rating: " + overallRating;
    S = S + "\n Current rank value: " + rankValue;
    return S;
  }
 
  /** Computes overallRating for a destination that considers 
   * all six factors, given input weights for the individual factors
   */
    public void computeRanking(int safeWeight, int budgetWeight, int climateWeight, 
         int transWeight, int accomWeight, 
          int famWeight){

 overallRating=(rateSafety*safeWeight)+(rateBudget*budgetWeight)+
     (rateClimate*climateWeight)+(rateTrans*transWeight)+
     (rateAccom*accomWeight)+(rateFam*famWeight);

    }

 
 
}
