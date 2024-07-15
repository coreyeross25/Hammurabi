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

        int year = 1;
        int population = 100;
        int bushelsInStorage = 2800;
        int acresOwned = 1000;
        int landPrice = 19;


        while (year <= 10) {
            printSummary(year, 0, 0, bushelsInStorage, 0, population, acresOwned, landPrice);

            int acresToBuy = askHowManyAcresToBuy(landPrice, bushelsInStorage);


            int acresToSell = askHowManyAcresToSell(acresOwned);


            int bushelsFedToPeople = askHowMuchGrainToFeedPeople(bushelsInStorage);


            int acresToPlant = askHowManyAcresToPlant(acresOwned, population, bushelsInStorage);

            int plagueDeaths = plagueDeaths(population);
            int starvationDeaths = starvationDeaths(population, bushelsFedToPeople);
            boolean uprising = uprising(population, starvationDeaths);

            if (!uprising) {
                int immigrants = immigrants(population, acresOwned, bushelsInStorage);


                int harvestYield = harvest(acresToPlant);


                int ratsAte = grainEatenByRats(bushelsInStorage);


                landPrice = newCostOfLand();
                printSummary(year, plagueDeaths, immigrants, harvestYield, ratsAte,
                        population, acresOwned, landPrice);
            } else {
                System.out.println("O Great Hammurabi, You did terrible!");
                finalSummary(bushelsInStorage, population, acresOwned, landPrice);
                return;
            }
            year++;
        }
        finalSummary(bushelsInStorage, population, acresOwned, landPrice);
        scanner.close();

    }

    //other methods go here
    public int askHowManyAcresToBuy(int price, int bushels) {
        int acresTryingToBuy;
        while (true) {
            System.out.print("How many acres would you like to buy?");
            acresTryingToBuy = 0;
            try {
                acresTryingToBuy = scanner.nextInt();
                if (acresTryingToBuy <= 0) {
                    System.out.println("Please enter a number greater than 0.");
                    continue;
                }
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
        int acresTryingToSell;
        while (true) {
            System.out.print("How many acres would you like to sell?");
            acresTryingToSell = 0;
            try {
                acresTryingToSell = scanner.nextInt();
                if (acresTryingToSell > acresOwned) {
                    System.out.println("You cannot sell more acres than you currently own.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" is more than what you own! Please try again");
            }
            if (acresTryingToSell > 0) {
            }
            return acresTryingToSell;
        }

    }

    public int askHowMuchGrainToFeedPeople(int bushelsInStorage) {
        int grainToFeedThePeople;
        while (true) {
            System.out.print("How much grain do you want to allocate for feeding people? (You currently have " + bushelsInStorage + " bushels) ");
            grainToFeedThePeople = 0;
            try {
                grainToFeedThePeople = scanner.nextInt();
                if (grainToFeedThePeople > bushelsInStorage) {
                    System.out.println("You cannot give out more grain than you currently have.");
                    continue;
                }
                } catch (InputMismatchException e) {
                    System.out.println("\"" + scanner.next() + "\" You do not have enough grain to feed the people! Please try again");
                }
                if (grainToFeedThePeople > 0) {
                    break;
                }

                return grainToFeedThePeople;


            }
        return 0;
        }



    public int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
        int acresToPlant;
        while (true) {
            System.out.print("How much grain to feed the people?");
            acresToPlant = 0;
            try {
                acresToPlant = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" You do not have enough grain to feed the people! Please try again");
            }
            if (acresToPlant > 0) {
                break;
            }
        }
        return acresToPlant;
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
        return rand.nextInt(7) + 17;
    }

    void printSummary(int year, int starvationDeaths, int immigrants, int harvest, int RatsAte, int population,
                      int acresOwned, int newCostOfLand) {
        System.out.println("O great Hammurabi");
        System.out.printf("You are in year %d of your ten year rule.\n",year);
        System.out.printf("In the previous year %d people starved to death. \n", starvationDeaths);
        System.out.printf("In the previous year %d people enter the kingdom. \n", immigrants);
        System.out.printf("The population is now %d. \n", population);
        System.out.printf("We harvested %d bushels at %d bushels per acre. \n", harvest, harvest / acresOwned);
        System.out.printf("The city owns %d acres of land.\n", acresOwned);
        System.out.printf("Land is currently worth %d bushels per acre.\n", newCostOfLand);

    }


    void finalSummary(int harvest, int population, int acresOwned, int newCostOfLand) {
        double acresPerPerson = (double) acresOwned / population;

        System.out.println("\nYour ten year rule is over.");
        System.out.printf("You started with 100 people and ended with %d people.\n",population);
        System.out.printf("You owned %d acres of land.\n",acresOwned);
        System.out.printf("Land was worth %d bushels per acre at the end of your rule.\n",newCostOfLand);
        System.out.printf("You had %d bushels of grain left over in storage.\n",harvest);


        if (population <= 0) {
            System.out.println("Maybe pick a different profession! Ruling is not for you");
        } else if (acresPerPerson >= 10) {
            System.out.println("Woo Woo! Who is the man? Yes that is you");

    }}

}