package hammurabi;

import java.util.InputMismatchException;
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
                harvest = 3000, yield = 3, acres = harvest / yield, eaten = harvest - stores, landPrice = 19, fullPeople, temp;

        askHowManyAcresToBuy(landPrice, stores);

        // statements go after the declarations
    }

    //other methods go here
    public int askHowManyAcresToBuy(int price, int bushels) {
        int acresTryingToBuy;
        while (true) {
            System.out.print("How many acres would you like to buy?");
            acresTryingToBuy = 0;
            try {
                acresTryingToBuy = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
            if (acresTryingToBuy > 0) {
                break;
            }
        }
        return acresTryingToBuy;
    }

    public int askHowManyAcresToSell(int acresOwned) {
        return 0;
    }

    public int askHowMuchGrainToFeedPeople(int bushels) {
        return 0;
    }

    public int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
        return 0;
    }

    public int plagueDeaths(int population) {
        if (rand.nextInt(100) < 15) {
            return population / 2;
        }
        return 0;
    }

    public int starvationDeaths(int population, int bushelsFedToPeople) {
        int neededForSurvival = population * 20;
        if (bushelsFedToPeople < neededForSurvival) {
            return population - (bushelsFedToPeople / 20);
        }
        return 0;
    }

    public boolean uprising(int population, int howManyPeopleStarved) {
        double percentStarved = (double) howManyPeopleStarved / population * 100;

        if (percentStarved > 45.00) {
            return true;
        } else {
            return false;
        }

    }

    public int immigrants(int population, int acresOwned, int grainInStorage) {
        // this if statement checks to see if there is enough land and enough food to make sure each person gets 20 grains
        if (population < 0.5 * acresOwned && grainInStorage > population * 20) {
            return (20 * acresOwned + grainInStorage) / (100 * population) + 1;
        }
        return 0;
    }

    public int harvest(int acres) {
        int bushelsHarvested = rand.nextInt(6) + 1;
        return bushelsHarvested * acres;
    }

    public int grainEatenByRats(int bushels) {
        if (rand.nextInt(100) < 40) {
            int eaten = rand.nextInt(21) + 10;
            return bushels * eaten / 100;
        }
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