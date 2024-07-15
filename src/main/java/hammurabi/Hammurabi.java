package hammurabi;

import java.util.Random;         // imports go here
import java.util.Scanner;

public class Hammurabi {         // must save in a file named hammurabi.Hammurabi.java
    Random rand = new Random();  // this is an instance variable
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { // required in every Java program
        new Hammurabi().playGame();
    }


    void playGame() {
        // declare local variables here: grain, population, etc.
        int totalDeaths = 0, percentDied = 0, year = 0, population = 95, stores = 2800, immigrants = 5, deaths,
                harvest = 3000, yield = 3, acres = harvest / yield, eaten = harvest - stores, landPrice, fullPeople, temp;



        // statements go after the declarations
    }

    //other methods go here
    public int askHowManyAcresToBuy(int price, int bushels){
        return 0;
    }

    public int askHowManyAcresToSell(int acresOwned){
        return 0;
    }

    public int askHowMuchGrainToFeedPeople(int bushels){
        return 0;
    }

    public int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
        return 0;
    }

    public int plagueDeaths(int population){
        if (rand.nextInt(100) < 15) {
            return population / 2;
        }
            return 0;
    }

    public int starvationDeaths(int population, int bushelsFedToPeople) {
        return 0;
    }

    public boolean uprising(int population, int howManyPeopleStarved) {
        return true;
    }

    public int immigrants(int population, int acresOwned, int grainInStorage) {
        return 0;
    }

    public int harvest(int acres){
        return 0;
    }

    public int grainEatenByRats(int bushels){
        return 0;
    }

    public int newCostOfLand() {
        return 0;
    }

    void printSummary() {

    }

    void finalSummary() {

    }






}