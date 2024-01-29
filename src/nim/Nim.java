/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nim;

import java.util.Random;
import java.util.Scanner;

/*hi mr jones
Nyomi Bell-All Options
 95 points
*1. Who's First? Randomly decide who's first (5 points)
*2. Dignity (5 points)-finished
*3. Cheat Protection (15 points)-finished
*4.Two out of three? Allow the player to play as many times as they choose. (5 points)-finished
*5. Instructions (5 points)-finished but may need to simplify-finished
*6. Computer Opponent(20 Points)-finished 
*7. Fancy Display (10 points)-done
*8. Fancier Display (15 points)-finished
*9. Fanciest Display (20 points)-finished
/**
 *
 * @author omi
 */
public class Nim {

    static boolean game = true;
    static boolean playing = true;//while true program will loop until someone loses

    static String playerName = "";//human opponent name

    static int playerWins = 0;//human wins
    static int computerWins = 0;//computer wins

    static String playAgain = "";

    static Scanner keyboard = new Scanner(System.in);

    static int random;

    static int rowA = 3;
    static int rowB = 5;
    static int rowC = 7;

    static String player1Name = "";//player one name
    static String player2Name = "";//player two name 
    static String displayChoice = "";

    static String oldPileSubtract = "";

    /**
     * @param args the command line arguments
     */
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template 

        /**
         * @param args the command line arguments
     */
    public static void main(String[] args) {
//variables

//holds names so player can be randomly selected based on random num  chosen        
        int totalCounters; //variable to keep track of counters + determine when to grant mercy
        totalCounters = (rowA + rowB + rowC);//initialized w/ full pile amounts

        int pileSubtract = 0;//variable to store how many user wants  to subtract from piles

        Random rNumber = new Random();
        keyboard = new Scanner(System.in);//rnumber to determine player order
        game = true;//while true program will loop until someone decides not to play

//Start of game
        System.out.println("Welcome to \"Nim!\"");
        boolean wrongInput = true;
        System.out.println("Would you like instructions?");
        System.out.println("\nType \"y\" for yes or \"n\" for no.");
        System.out.print("\n>");
        String instructions;
        instructions = keyboard.nextLine();
        while (wrongInput) {
            if ((instructions.equalsIgnoreCase("y")) || (instructions.equalsIgnoreCase("n"))) {
                wrongInput = false;
            } else if (!(instructions.equalsIgnoreCase("y")) || (!instructions.equalsIgnoreCase("n"))) {
                System.out.println("Sorry!" + instructions + " is not a valid input...");
            }
        }
        if (instructions.equalsIgnoreCase("y")) {
            instructionsMethod();
        }
        System.out.println("\nWhich display would you like?\n");
        System.out.println("1. \"Basic Display\"");
        System.out.println("\nA: " + rowA + "\tB: " + rowB + "\tC: " + rowC + "\n");
        enter();
        System.out.println("\n2. \"Fancy Display\"");
        System.out.println("\nA: * * *");
        System.out.println("B: * * * * *");
        System.out.println("C: * * * * * * *");
        enter();
        System.out.println("\n\n3. \"Fancier Display\"");
        //FANCIER
        int greatestRow = 0;
        if ((rowA > rowB) && (rowA > rowC)) {
            greatestRow = rowA;
        } else if ((rowB > rowA) && (rowB > rowC)) {
            greatestRow = rowB;

        } else if ((rowC > rowA) && (rowC > rowB)) {
            greatestRow = rowC;

        } else if ((rowC > rowA) && (rowC == rowB)) {
            greatestRow = rowB;
        } else if ((rowB > rowC) && (rowB == rowA)) {
            greatestRow = rowB;
        } else if ((rowA > rowB) && (rowA == rowC)) {
            greatestRow = rowC;
        }
        System.out.print("");
        for (int i = 0; i < greatestRow; i++) {
            if (rowA > i) {
                System.out.print("*  ");
            } else if (rowA <= i) {
                System.out.print("   ");
            }
            if (rowB > i) {
                System.out.print("*  ");
            } else if (rowB <= i) {
                System.out.print("   ");
            }
            if (rowC > i) {
                System.out.print("*  ");
            } else if (rowC <= i) {
                System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println("");
        enter();
//Fanciest
        System.out.println("\n4. \"Fanciest Display\"");
        rowA = 3;
        rowB = 5;
        rowC = 7;
        greatestRow = 0;

        if ((rowB > rowA) && (rowB > rowC)) {
            greatestRow = rowB;

        } else if ((rowC > rowA) && (rowC > rowB)) {
            greatestRow = rowC;

        } else if ((rowC > rowA) && (rowC == rowB)) {
            greatestRow = rowB;
        } else if ((rowB > rowC) && (rowB == rowA)) {
            greatestRow = rowB;
        } else if ((rowA > rowB) && (rowA == rowC)) {
            greatestRow = rowC;
        }
        System.out.print("\n");
        for (int i = greatestRow; i > 0; i--) {
            if (rowA >= i) {
                System.out.print("*  ");
            } else if (rowA < i) {
                System.out.print("   ");
            }
            if (rowB >= i) {
                System.out.print("*  ");
            } else if (rowB < i) {
                System.out.print("   ");
            }
            if (rowC >= i) {
                System.out.print("*  ");
            } else if (rowC < i) {
                System.out.print("   ");
            }
            System.out.println();
        }
        System.out.print("\nA  B  C\n");
        wrongInput = true;
        while (wrongInput) {
            System.out.println("\n\nWhich display would you like? (Please type a number)");
            System.out.print("\n\n1. \"Basic\"\t2. \"Fancy\"\n3. \"Fancier\"\t4. \"Fanciest\"");
            System.out.print("\n\n>");
            displayChoice = keyboard.nextLine();
            System.out.print("\n");
            if ((displayChoice.equalsIgnoreCase("1")) || (displayChoice.equalsIgnoreCase("basic")) || (displayChoice.equalsIgnoreCase("2")) || (displayChoice.equalsIgnoreCase("fancy")) || (displayChoice.equalsIgnoreCase("3")) || (displayChoice.equalsIgnoreCase("fancier")) || (displayChoice.equalsIgnoreCase("4")) || (displayChoice.equalsIgnoreCase("fanciest"))) {
                wrongInput = false;
            } else if (!(displayChoice.equalsIgnoreCase("1")) || (displayChoice.equalsIgnoreCase("basic")) || (displayChoice.equalsIgnoreCase("2")) || (displayChoice.equalsIgnoreCase("fancy")) || (displayChoice.equalsIgnoreCase("3")) || (displayChoice.equalsIgnoreCase("fancier")) || (displayChoice.equalsIgnoreCase("4")) || (displayChoice.equalsIgnoreCase("fanciest"))) {
                System.out.println("Sorry! " + displayChoice + " is not a valid display choice...");
            }
        }
        String display = "";
        if (displayChoice.equalsIgnoreCase("1")) {
            display = "Basic";
        } else if (displayChoice.equalsIgnoreCase("2")) {
            display = "Fancy";
        } else if (displayChoice.equalsIgnoreCase("3")) {
            display = "Fancier";

        } else {
            display = "Fanciest";

        }

        System.out.println("You have chosen \"" + display + " Display!\"\n");
        wrongInput = true;//wrong input for computer or multiplayer choice
        String gameType = "";
        while (wrongInput) {
            System.out.println("Would you like to play against a \"person\" or a \"computer\"? (Please chose a number)\n");
            System.out.println("1.person\n2.computer");
            System.out.print("\n>");
            gameType = keyboard.nextLine();
            if ((gameType.equalsIgnoreCase("1")) || (gameType.equalsIgnoreCase("2"))) {
                wrongInput = false;
            } else if (!(gameType.equalsIgnoreCase("1")) || (!instructions.equalsIgnoreCase("2"))) {
                System.out.println("\nSorry!" + gameType + " is not a valid input...");
            }
        }
        if (gameType.equalsIgnoreCase("1")) {
            System.out.println("You have chosen \"Multiplayer Mode\"\n");
            multiPlayer();
        } else if (gameType.equalsIgnoreCase("2")) {
            System.out.println("You have chosen \"Computer Opponent Mode\"\n");

            System.out.print("\n\nEnter your name: ");
            playerName = keyboard.nextLine();
            game = true;//while true program will loop until someone decides not to play
            while (game) {
                playing = true;
                while (playing) {
                    random = 1 + rNumber.nextInt(2);
                    System.out.print("\n");
                    if (random == 1) {
                        System.out.println(playerName + ", you have been randomly selected to go first.");
                        humanFirst();
                    } else if (random == 2) {
                        System.out.println("I have been randomly selected to go first!");
                        computerFirst();
                    }
                }
            }
        }
    }//end of main method

    public static void computerFirst() {
        int pileSubtract = 0;//variable to store how many user wants  to subtract from piles

        int totalCounters; //variable to keep track of counters + determine when to grant mercy
        totalCounters = (rowA + rowB + rowC);//initialized w/ full pile amounts

        boolean cheating = true;
        boolean invalid = true;
        boolean invalidComputer = true;

        int computerSubtract;//number of counters computer takes from pile
        int computerPileNum;//random num determines which pile computer picks from

        Random rNumber = new Random();

        boolean player1Turn = true; //keep track of turns
        String playAgain = "";
        String pile = "";//variable to store user's pile choice
        while (playing) {
            boolean wrongInput = true;
            if (player1Turn) {//start of p1 turn
                while (invalidComputer) {
                    computerPileNum = 1 + rNumber.nextInt(3);
                    if ((computerPileNum == 1) && (rowA > 0)) {
                        displays();
                        System.out.println("\n");
                        System.out.println("I choose a pile A.");
                        computerSubtract = 1 + rNumber.nextInt(rowA);
                        System.out.println("I'm taking " + computerPileNum + " from pile A.");
                        rowA = rowA - computerPileNum;
                        invalidComputer = false;
                    } else if ((computerPileNum == 2) && (rowB > 0)) {
                        displays();

                        System.out.println("I choose pile B.");
                        computerSubtract = 1 + rNumber.nextInt(rowB);
                        System.out.println("I'm taking " + computerSubtract + " from pile B.");
                        rowB = rowB - computerSubtract;
                        invalidComputer = false;

                    } else if ((computerPileNum == 3) && (rowC > 0)) {
                        displays();

                        System.out.println("I choose pile C.");
                        computerSubtract = 1 + rNumber.nextInt(rowC);
                        System.out.println("I'm taking " + computerSubtract + " from pile C.");
                        rowC = rowC - computerSubtract;
                        invalidComputer = false;

                    }//end of computer  turn
                }//end of human first else if, end of computer turn            
            } else {
                while (invalid) {
                    displays();
                    System.out.print("\n" + playerName + ", choose a pile\n\n>");
                    pile = keyboard.nextLine();
                    if (((pile.equalsIgnoreCase("A")) && (rowA > 0)) || ((pile.equalsIgnoreCase("B")) && (rowB > 0)) || ((pile.equalsIgnoreCase("C")) && (rowC > 0))) {
                        invalid = false;
                    } else if ((pile.equalsIgnoreCase("A")) && (rowA == 0)) {
                        System.out.println("\nSorry! " + pile + " is not a valid pile, " + playerName + "\nPile " + pile + " is empty!");
                    } else if ((pile.equalsIgnoreCase("B")) && (rowB == 0)) {
                        System.out.println("\nSorry! " + pile + " is not a valid pile, " + playerName + "\nPile " + pile + " is empty!");
                    } else if ((pile.equalsIgnoreCase("C")) && (rowC == 0)) {
                        System.out.println("\nSorry! " + pile + " is not a valid pile, " + playerName + "\nPile " + pile + " is empty!");
                    } else if (!(pile.equalsIgnoreCase("A")) || (!pile.equalsIgnoreCase("B")) || (!pile.equalsIgnoreCase("C"))) {
                        System.out.println("\nSorry! " + pile + " is not a valid pile, " + playerName + "...");
                    }
                }
                while (cheating) {//testing to see if player 2 chooses a valid amount to subtract

                    System.out.print("\nHow many would you like to remove from pile " + pile + ", " + playerName + "?\n\n>");

                    oldPileSubtract = keyboard.nextLine();
                    if (isNumeric(oldPileSubtract)) {
                        pileSubtract = Integer.parseInt(oldPileSubtract);

                        if ((pile.equalsIgnoreCase("A")) && (rowA > 0) && (pileSubtract > 0) && (rowA >= pileSubtract)) {
                            rowA = rowA - pileSubtract;
                            cheating = false;
                        } else if ((pile.equalsIgnoreCase("A")) && (rowA > 0) && (pileSubtract < 0)) {//prevents player 1 from to taking a negative amount from pile A
                            System.out.println("\nNice try, " + playerName + ".\nAs I'm sure you know, " + pileSubtract + " is a negative number.");
                            System.out.println("You may not take a negative amount of counters-you must choose at least 1.");
                        } else if ((pile.equalsIgnoreCase("A")) && (rowA > 0) && (pileSubtract == 0)) {//prevents player 1 from to taking none from pile A
                            System.out.println("\nNice try, " + playerName + ".");
                            System.out.println("You may not take 0 counters-you must choose at least 1.");
                        } else if ((pile.equalsIgnoreCase("A")) && (rowA > 1) && (pileSubtract > rowA)) {//prevents player 2 from taking more than pile A has. which idk why you'd do that but
                            System.out.println("\nPile " + pile + " doesn't have " + pileSubtract + " counters, " + playerName + "-it only has " + rowA + " counters...Try Again.");
                        } else if ((pile.equalsIgnoreCase("A")) && (rowA == 1) && (pileSubtract > rowA)) {//prevents player one from taking more than pile Chas. which idk why you'd do that but
                            System.out.println("\nPile " + pile + " doesn't have " + pileSubtract + " counters, " + playerName + "-it only has " + rowA + " counter...Try Again.");
                        } else if ((pile.equalsIgnoreCase("B")) && (rowB > 0) && (pileSubtract > 0) && (rowB >= pileSubtract)) {
                            rowB = rowB - pileSubtract;
                            cheating = false;
                        } else if ((pile.equalsIgnoreCase("B")) && (rowB > 0) && (pileSubtract < 0)) {//prevents player 2 from to taking a negative amount from pile B
                            System.out.println("\nNice try, " + playerName + ".\nAs I'm sure you know, " + pileSubtract + " is a negative number.");
                            System.out.println("You may not take a negative amount of counters-you must choose at least 1.");
                        } else if ((pile.equalsIgnoreCase("B")) && (rowB > 0) && (pileSubtract == 0)) {//prevents player 1 from to taking none from pile B
                            System.out.println("\nNice try, " + playerName + ".");
                            System.out.println("You may not take 0 counters-you must choose at least 1.");
                        } else if ((pile.equalsIgnoreCase("B")) && (rowB > 1) && (pileSubtract > rowB)) {//prevents player 2 from taking more than pile B has. which idk why you'd do that but
                            System.out.println("\nPile " + pile + " doesn't have " + pileSubtract + " counters, " + playerName + "-it only has " + rowB + " counters...Try Again.");
                        } else if ((pile.equalsIgnoreCase("B")) && (rowB == 1) && (pileSubtract > rowB)) {//prevents player one from taking more than pile Chas. which idk why you'd do that but
                            System.out.println("\nPile " + pile + " doesn't have " + pileSubtract + " counters, " + playerName + "-it only has " + rowB + " counter...Try Again.");
                        } else if ((pile.equalsIgnoreCase("C")) && (rowC > 0) && (pileSubtract > 0) && (rowC >= pileSubtract)) {
                            rowC = rowC - pileSubtract;
                            cheating = false;
                        } else if ((pile.equalsIgnoreCase("C")) && (rowC > 0) && (pileSubtract < 0)) {//prevents player 2 from to taking a negative amount from pile C
                            System.out.println("Nice try, " + playerName + ".\nAs I'm sure you know, " + pileSubtract + " is a negative number.");
                            System.out.println("You may not take a negative amount of counters-you must choose at least 1.");
                        } else if ((pile.equalsIgnoreCase("C")) && (rowC > 0) && (pileSubtract == 0)) {//prevents player 2 from to taking none from pile C
                            System.out.println("Nice try, " + playerName + ".");
                            System.out.println("You may not take 0 counters-you must choose at least 1.");
                        } else if ((pile.equalsIgnoreCase("C")) && (rowC > 1) && (pileSubtract > rowC)) {//prevents player 2 from taking more than pile Chas. which idk why you'd do that but
                            System.out.println("Pile " + pile + " doesn't have " + pileSubtract + " counters, " + playerName + "-it only has " + rowC + " counters...Try Again.");
                        } else if ((pile.equalsIgnoreCase("C")) && (rowC == 1) && (pileSubtract > rowC)) {//prevents player 2 from taking more than pile Chas. which idk why you'd do that but
                            System.out.println("Pile " + pile + " doesn't have " + pileSubtract + " counters, " + playerName + "-it only has " + rowC + " counter...Try Again.");
                        }
                    } else {
                        System.out.println("Please chose a valid number");
                    }
                }
            }//end of human player 2nd to go turn 
            totalCounters = (rowA + rowB + rowC);

            if ((totalCounters == (1)) && (player1Turn) && random == 2) {
                displays();
//display();
                System.out.println("\nSorry, " + playerName + " you must take the remaining counter, so you lose.");
                System.out.println("\nI win!");
                computerWins++;
                while (wrongInput) {
                    System.out.println("\nWould you like to play again?");
                    System.out.println("\"y\" or \"n\"?");
                    System.out.print("\n>");
                    playAgain = keyboard.nextLine();
                    if ((playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                        wrongInput = false;
                    } else if (!(playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                        System.out.println("Sorry! " + playAgain + " is not a valid choice...");
                    }
                }
                System.out.println();
                if (playAgain.equalsIgnoreCase("n")) {
                    System.out.println(playerName + " won " + playerWins + " times.");
                    System.out.println("I won " + computerWins + " times.");
                    game = false;//ends game

                    if (playerWins > computerWins) {
                        System.out.println("You are the Nim Champion, " + playerName + "!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");

                        game = false;//ends game
                        playing = false;

                    } else if (computerWins > playerWins) {
                        System.out.println("I am the Nim Champion!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                        game = false;//ends game
                        playing = false;

                    } else {
                        System.out.println("It's a tie!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                        game = false;//ends game
                        playing = false;

                    }

                } else {
                    rowA = 3;
                    rowB = 5;
                    rowC = 7;
                    playing = false;
                }
            } else if ((totalCounters == (1)) && (!player1Turn) && random == 2) {
                displays();
//display();
                System.out.println("\nI must take the remaining counter, so I lose.\n");
                System.out.println("You win, " + playerName + "!");
                playerWins++;
                while (wrongInput) {
                    System.out.println("\nWould you like to play again?");
                    System.out.println("\"y\" or \"n\"?");
                    System.out.print("\n>");
                    playAgain = keyboard.nextLine();
                    if ((playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                        wrongInput = false;
                    } else if (!(playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                        System.out.println("Sorry! " + playAgain + " is not a valid choice...");
                    }
                }
                playAgain = keyboard.nextLine();
                System.out.println();
                if (playAgain.equalsIgnoreCase("n")) {
                    System.out.println(playerName + " won " + playerWins + " times.");
                    System.out.println("I won " + computerWins + " times.");
                    if (playerWins > computerWins) {
                        System.out.println("You are the Nim Champion, " + playerName + "!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                        game = false;//ends game
                        playing = false;

                    } else if (computerWins > playerWins) {
                        System.out.println("I am the Nim Champion!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                        game = false;//ends game
                        playing = false;

                    } else {
                        System.out.println("It's a tie!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                        game = false;//ends game
                        playing = false;
                    }
                } else {
                    rowA = 3;
                    rowB = 5;
                    rowC = 7;
                    playing = false;
                }
            } else if ((totalCounters == (0)) && (player1Turn) && random == 2) {
//display();
                System.out.println("I took the remaining counter, so I lose.\n");
                System.out.println("You win, " + playerName + "!");
                playerWins++;
                while (wrongInput) {
                    System.out.println("\nWould you like to play again?");
                    System.out.println("\"y\" or \"n\"?");
                    System.out.print("\n>");
                    playAgain = keyboard.nextLine();
                    if ((playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                        wrongInput = false;
                    } else if (!(playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                        System.out.println("Sorry! " + playAgain + " is not a valid choice...");
                    }
                }
                System.out.println();
                if (playAgain.equalsIgnoreCase("n")) {
                    System.out.println(playerName + " won " + playerWins + " times.");
                    System.out.println("I won " + computerWins + " times.");
                    game = false;//ends game
                    playing = false;

                    if (playerWins > computerWins) {
                        System.out.println("You are the Nim Champion, " + playerName + "!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");

                        game = false;//ends game
                        playing = false;
                    } else if (computerWins > playerWins) {
                        System.out.println("I am the Nim Champion!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                        game = false;//ends game
                        playing = false;

                    } else {
                        System.out.println("It's a tie!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                        game = false;//ends game
                        playing = false;

                    }
                } else {
                    rowA = 3;
                    rowB = 5;
                    rowC = 7;
                    playing = false;
                }
            } else if ((totalCounters == (0)) && (!player1Turn) && random == 2) {
                displays();
                System.out.println("\nSorry, " + playerName + " you took the remaining counter, so you lose.");
                System.out.println("I win!");
                computerWins++;
                while (wrongInput) {
                    System.out.println("\nWould you like to play again?");
                    System.out.println("\"y\" or \"n\"?");
                    System.out.print("\n>");
                    playAgain = keyboard.nextLine();
                    if ((playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                        wrongInput = false;
                    } else if (!(playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                        System.out.println("Sorry! " + playAgain + " is not a valid choice...");
                    }
                }
                System.out.println();
                if (playAgain.equalsIgnoreCase("n")) {
                    System.out.println(playerName + " won " + playerWins + " times.");
                    System.out.println("I won " + computerWins + " times.");
                    game = false;//ends game
                    playing = false;

                    if (playerWins > computerWins) {
                        System.out.println("You are the Nim Champion, " + playerName + "!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");

                        game = false;//ends game
                        playing = false;
                    } else if (computerWins > playerWins) {
                        System.out.println("I am the Nim Champion!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                        game = false;//ends game
                        playing = false;

                    } else {
                        System.out.println("It's a tie!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                        game = false;//ends game
                        playing = false;

                    }

                } else {
                    rowA = 3;
                    rowB = 5;
                    rowC = 7;
                    playing = false;//restarts game
                }
            }//end of play again stms
            player1Turn = !player1Turn;
            invalid = true;
            cheating = true;
            invalidComputer = true;
        }//end of while playing

    }//end of computerFirst method

    public static void humanFirst() {
        //^^ piles and initilization
        int pileSubtract = 0;//variable to store how many user wants  to subtract from piles
        int totalCounters; //variable to keep track of counters + determine when to grant mercy
        totalCounters = (rowA + rowB + rowC);//initialized w/ full pile amounts
        boolean cheating = true;//boolean to make sure user doesnt cheat
        boolean invalid = true;//boolean to make sure user chooses valid pile
        boolean invalidComputer = true;

        Random rNumber = new Random();
        int computerSubtract;//number of counters computer takes from pile
        int computerPileNum;//random num determines which pile computer picks from

        boolean player1Turn = true; //keep track of turns
        String playAgain = "";
        String pile = "";//variable to store user's pile choice

        while (playing) {
            boolean wrongInput = true;
            if (player1Turn) {
                while (invalid) {
                    displays();
                    System.out.print("\n" + playerName + ", choose a pile\n\n>");
                    pile = keyboard.nextLine();
                    if (((pile.equalsIgnoreCase("A")) && (rowA > 0)) || ((pile.equalsIgnoreCase("B")) && (rowB > 0)) || ((pile.equalsIgnoreCase("C")) && (rowC > 0))) {
                        invalid = false;
                    } else if ((pile.equalsIgnoreCase("A")) && (rowA == 0)) {
                        System.out.println("\nSorry! " + pile + " is not a valid pile, " + playerName + "\nPile " + pile + " is empty!");
                    } else if ((pile.equalsIgnoreCase("B")) && (rowB == 0)) {
                        System.out.println("\nSorry! " + pile + " is not a valid pile, " + playerName + "\nPile " + pile + " is empty!");
                    } else if ((pile.equalsIgnoreCase("C")) && (rowC == 0)) {
                        System.out.println("\nSorry! " + pile + " is not a valid pile, " + playerName + "\nPile " + pile + " is empty!");
                    } else if (!(pile.equalsIgnoreCase("A")) || (!pile.equalsIgnoreCase("B")) || (!pile.equalsIgnoreCase("C"))) {
                        System.out.println("\nSorry! " + pile + " is not a valid pile, " + playerName + "...");
                    }
                }
                while (cheating) {//testing to see if player 2 chooses a valid amount to subtract
                    System.out.print("\nHow many would you like to remove from pile " + pile + ", " + playerName + "?\n\n>");
                    oldPileSubtract = keyboard.nextLine();
                    if (isNumeric(oldPileSubtract)) {
                        pileSubtract = Integer.parseInt(oldPileSubtract);

                        if ((pile.equalsIgnoreCase("A")) && (rowA > 0) && (pileSubtract > 0) && (rowA >= pileSubtract)) {
                            rowA = rowA - pileSubtract;
                            cheating = false;
                        } else if ((pile.equalsIgnoreCase("A")) && (rowA > 0) && (pileSubtract < 0)) {//prevents player 1 from to taking a negative amount from pile A
                            System.out.println("\nNice try, " + playerName + ".\nAs I'm sure you know, " + pileSubtract + " is a negative number.");
                            System.out.println("You may not take a negative amount of counters-you must choose at least 1.");
                        } else if ((pile.equalsIgnoreCase("A")) && (rowA > 0) && (pileSubtract == 0)) {//prevents player 1 from to taking none from pile A
                            System.out.println("\nNice try, " + playerName + ".");
                            System.out.println("You may not take 0 counters-you must choose at least 1.");
                        } else if ((pile.equalsIgnoreCase("A")) && (rowA > 1) && (pileSubtract > rowA)) {//prevents player 2 from taking more than pile A has. which idk why you'd do that but
                            System.out.println("\nPile " + pile + " doesn't have " + pileSubtract + " counters, " + playerName + "-it only has " + rowA + " counters...Try Again.");
                        } else if ((pile.equalsIgnoreCase("A")) && (rowA == 1) && (pileSubtract > rowA)) {//prevents player one from taking more than pile Chas. which idk why you'd do that but
                            System.out.println("\nPile " + pile + " doesn't have " + pileSubtract + " counters, " + playerName + "-it only has " + rowA + " counter...Try Again.");
                        } else if ((pile.equalsIgnoreCase("B")) && (rowB > 0) && (pileSubtract > 0) && (rowB >= pileSubtract)) {
                            rowB = rowB - pileSubtract;
                            cheating = false;
                        } else if ((pile.equalsIgnoreCase("B")) && (rowB > 0) && (pileSubtract < 0)) {//prevents player 2 from to taking a negative amount from pile B
                            System.out.println("\nNice try, " + playerName + ".\nAs I'm sure you know, " + pileSubtract + " is a negative number.");
                            System.out.println("You may not take a negative amount of counters-you must choose at least 1.");
                        } else if ((pile.equalsIgnoreCase("B")) && (rowB > 0) && (pileSubtract == 0)) {//prevents player 1 from to taking none from pile B
                            System.out.println("\nNice try, " + playerName + ".");
                            System.out.println("You may not take 0 counters-you must choose at least 1.");
                        } else if ((pile.equalsIgnoreCase("B")) && (rowB > 1) && (pileSubtract > rowB)) {//prevents player 2 from taking more than pile B has. which idk why you'd do that but
                            System.out.println("\nPile " + pile + " doesn't have " + pileSubtract + " counters, " + playerName + "-it only has " + rowB + " counters...Try Again.");
                        } else if ((pile.equalsIgnoreCase("B")) && (rowB == 1) && (pileSubtract > rowB)) {//prevents player one from taking more than pile Chas. which idk why you'd do that but
                            System.out.println("\nPile " + pile + " doesn't have " + pileSubtract + " counters, " + playerName + "-it only has " + rowB + " counter...Try Again.");
                        } else if ((pile.equalsIgnoreCase("C")) && (rowC > 0) && (pileSubtract > 0) && (rowC >= pileSubtract)) {
                            rowC = rowC - pileSubtract;
                            cheating = false;
                        } else if ((pile.equalsIgnoreCase("C")) && (rowC > 0) && (pileSubtract < 0)) {//prevents player 2 from to taking a negative amount from pile C
                            System.out.println("Nice try, " + playerName + ".\nAs I'm sure you know, " + pileSubtract + " is a negative number.");
                            System.out.println("You may not take a negative amount of counters-you must choose at least 1.");
                        } else if ((pile.equalsIgnoreCase("C")) && (rowC > 0) && (pileSubtract == 0)) {//prevents player 2 from to taking none from pile C
                            System.out.println("Nice try, " + playerName + ".");
                            System.out.println("You may not take 0 counters-you must choose at least 1.");
                        } else if ((pile.equalsIgnoreCase("C")) && (rowC > 1) && (pileSubtract > rowC)) {//prevents player 2 from taking more than pile Chas. which idk why you'd do that but
                            System.out.println("Pile " + pile + " doesn't have " + pileSubtract + " counters, " + playerName + "-it only has " + rowC + " counters...Try Again.");
                        } else if ((pile.equalsIgnoreCase("C")) && (rowC == 1) && (pileSubtract > rowC)) {//prevents player 2 from taking more than pile Chas. which idk why you'd do that but
                            System.out.println("Pile " + pile + " doesn't have " + pileSubtract + " counters, " + playerName + "-it only has " + rowC + " counter...Try Again.");
                        }
                    } else {
                        System.out.println("Please chose a number");
                    }
                }
//end of human player 1st turn  
            } else {  //start of COMPUTER turn
                while (invalidComputer) {
                    computerPileNum = 1 + rNumber.nextInt(3);
                    if ((computerPileNum == 1) && (rowA > 0)) {
                        displays();
                        System.out.println("\nI choose a pile A.");
                        computerSubtract = 1 + rNumber.nextInt(rowA);
                        System.out.println("I'm taking " + computerSubtract + " from pile A.");
                        rowA = rowA - computerSubtract;
                        invalidComputer = false;
                    } else if ((computerPileNum == 2) && (rowB > 0)) {
                        displays();

                        System.out.println("\nI choose pile B.");
                        computerSubtract = 1 + rNumber.nextInt(rowB);
                        System.out.println("I'm taking " + computerSubtract + " from pile B.");
                        rowB = rowB - computerSubtract;
                        invalidComputer = false;

                    } else if ((computerPileNum == 3) && (rowC > 0)) {
                        displays();

                        System.out.println("\nI choose pile C.");
                        computerSubtract = 1 + rNumber.nextInt(rowC);
                        System.out.println("I'm taking " + computerSubtract + " from pile C.");
                        rowC = rowC - computerSubtract;
                        invalidComputer = false;

                    }//end of computer  turn
                }
            }//end of human first else if, end of computer turn
            totalCounters = (rowA + rowB + rowC);

            if ((totalCounters == (1)) && (player1Turn) && random == 1) {
                displays();
                System.out.println("\nI must take the remaining counter, so I lose.\n");
                System.out.println("\nYou win, " + playerName + "!");
                playerWins++;
                while (wrongInput) {
                    System.out.println("\nWould you like to play again?");
                    System.out.println("\"y\" or \"n\"?");
                    System.out.print("\n>");
                    playAgain = keyboard.nextLine();
                    if ((playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                        wrongInput = false;
                    } else if (!(playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                        System.out.println("Sorry! " + playAgain + " is not a valid choice...");
                    }
                }
                System.out.println();
                if (playAgain.equalsIgnoreCase("n")) {
                    System.out.println(playerName + " won " + playerWins + " times.");
                    System.out.println("I won " + computerWins + " times.");
                    game = false;//ends game
                    playing = false;

                    if (playerWins > computerWins) {
                        System.out.println("You are the Nim Champion, " + playerName + "!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                        game = false;//ends game
                        playing = false;

                    } else if (computerWins > playerWins) {
                        System.out.println("I am the Nim Champion!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                        game = false;//ends game
                        playing = false;

                    } else {
                        System.out.println("It's a tie!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                        game = false;//ends game
                        playing = false;

                    }

                } else {
                    rowA = 3;
                    rowB = 5;
                    rowC = 7;
                    playing = false;
                }
            } else if ((totalCounters == (1)) && (!player1Turn) && random == 1) {
                displays();
                System.out.println("\nSorry, " + playerName + " you must take the remaining counter, so you lose.");
                System.out.println("\nI win!");
                computerWins++;
                while (wrongInput) {
                    System.out.println("\nWould you like to play again?");
                    System.out.println("\"y\" or \"n\"?");
                    System.out.print("\n>");
                    playAgain = keyboard.nextLine();
                    if ((playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                        wrongInput = false;
                    } else if (!(playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                        System.out.println("Sorry! " + playAgain + " is not a valid choice...");
                    }
                }
                System.out.println();
                if (playAgain.equalsIgnoreCase("n")) {
                    System.out.println(playerName + " won " + playerWins + " times.");
                    System.out.println("I won " + computerWins + " times.");
                    game = false;//ends game
                    playing = false;

                    if (playerWins > computerWins) {
                        System.out.println("You are the Nim Champion, " + playerName + "!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");

                        game = false;//ends game
                        playing = false;
                    } else if (computerWins > playerWins) {
                        System.out.println("I am the Nim Champion!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                        game = false;//ends game
                        playing = false;
                    } else {
                        System.out.println("It's a tie!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                    }
                    game = false;//ends game
                    playing = false;

                } else {
                    rowA = 3;
                    rowB = 5;
                    rowC = 7;
                    playing = false;
                }
            } else if ((totalCounters == (0)) && (!player1Turn) && random == 1) {
                displays();
                System.out.println("I took the remaining counter, so I lose.\n");
                System.out.println("\nYou win, " + playerName + "!");
                playerWins++;
                while (wrongInput) {
                    System.out.println("\nWould you like to play again?");
                    System.out.println("\"y\" or \"n\"?");
                    System.out.print("\n>");
                    playAgain = keyboard.nextLine();
                    if ((playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                        wrongInput = false;
                    } else if (!(playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                        System.out.println("Sorry! " + playAgain + " is not a valid choice...");
                    }
                }
                System.out.println();
                if (playAgain.equalsIgnoreCase("n")) {
                    System.out.println(playerName + " won " + playerWins + " times.");
                    System.out.println("I won " + computerWins + " times.");
                    game = false;//ends game
                    playing = false;

                    if (playerWins > computerWins) {
                        System.out.println("You are the Nim Champion, " + playerName + "!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                        game = false;//ends game
                        playing = false;
                    } else if (computerWins > playerWins) {
                        System.out.println("I am the Nim Champion!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                        game = false;//ends game
                        playing = false;

                    } else {
                        System.out.println("It's a tie!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                        game = false;//ends game
                        playing = false;

                    }

                } else {
                    rowA = 3;
                    rowB = 5;
                    rowC = 7;
                    playing = false;
                }

            } else if ((totalCounters == (0)) && (player1Turn) && random == 1) {
                displays();
//display();
                System.out.println("\nSorry, " + playerName + " you took the remaining counter, so you lose.");
                System.out.println("\nI win!");
                computerWins++;
                System.out.println("\nWould you like to play again?");
                System.out.println("\"y\" or \"n\"?");
                System.out.print("\n>");
                playAgain = keyboard.nextLine();
                System.out.println();
                if (playAgain.equalsIgnoreCase("n")) {
                    System.out.println(playerName + " won " + playerWins + " times.");
                    System.out.println("I won " + computerWins + " times.");
                    game = false;//ends game
                    playing = false;

                    if (playerWins > computerWins) {
                        System.out.println("You are the Nim Champion, " + playerName + "!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");

                        game = false;//ends game
                        playing = false;
                    } else if (computerWins > playerWins) {
                        System.out.println("I am the Nim Champion!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                        game = false;//ends game
                        playing = false;

                    } else {
                        System.out.println("It's a tie!");
                        System.out.println("Thanks for playing with me, " + playerName + "!");
                        game = false;//ends game
                        playing = false;

                    }

                } else {
                    rowA = 3;
                    rowB = 5;
                    rowC = 7;
                    playing = false;//restarts game
                }
            }//end of play again loop
            player1Turn = !player1Turn;
            invalid = true;
            cheating = true;
            invalidComputer = true;
        }//end of playing loop
    }//end of humanFirst method

    public static void multiPlayer() {
        String firstInput;//first name that is typed into the program
        String secondInput;//first name that is typed into the program

        String player1Name = "";//player one name
        String player2Name = "";//player two name 

        boolean player1Turn = true; //keep track of turns
        String pile = "";//variable to store user's pile choice

         boolean cheatingP1 = true;
        boolean invalidP1 = true;

        boolean cheatingP2 = true;
        boolean invalidP2 = true;

        int pileSubtract = 0;
        int player1Wins = 0;
        int player2Wins = 0;
        int totalCounters = 0;
        Random rNumber = new Random();

        String playAgain = "";
        System.out.print("\nPlease enter one player's name: ");
        firstInput = keyboard.nextLine();
        System.out.print("\n");

        System.out.print("Please enter another player's name: ");
        secondInput = keyboard.nextLine();

        //random selection of who goes first
        while (game) {
            int random = 1 + rNumber.nextInt(2);
            System.out.print("\n");
            if (random == 1) {
                player1Name = firstInput;
                player2Name = secondInput;

            } else if (random == 2) {
                player2Name = firstInput;
                player1Name = secondInput;
            }

            System.out.println(player1Name + ", you have been randomly selected to go first.");
            playing = true;
            while (playing) {
                        boolean wrongInput = true;
                if (player1Turn) {//start of p1 turn
                    //testing to see if player 1 chooses a valid pile
                    while (invalidP1) {
                        System.out.println();
                        displays();
                        System.out.println();
                        System.out.print(player1Name + ", choose a pile\n\n>");
                        pile = keyboard.nextLine();
                        if (((pile.equalsIgnoreCase("A")) && (rowA > 0)) || ((pile.equalsIgnoreCase("B")) && (rowB > 0)) || ((pile.equalsIgnoreCase("C")) && (rowC > 0))) {
                            invalidP1 = false;
                        } else if ((pile.equalsIgnoreCase("A")) && (rowA == 0)) {
                            System.out.println("\nSorry! " + pile + " is not a valid pile, " + player1Name + "\nPile " + pile + " is empty!");
                        } else if ((pile.equalsIgnoreCase("B")) && (rowB == 0)) {
                            System.out.println("\nSorry! " + pile + " is not a valid pile, " + player1Name + "\nPile " + pile + " is empty!");
                        } else if ((pile.equalsIgnoreCase("C")) && (rowC == 0)) {
                            System.out.println("\nSorry! " + pile + " is not a valid pile, " + player1Name + "\nPile " + pile + " is empty!");
                        } else if (!(pile.equalsIgnoreCase("A")) || (!pile.equalsIgnoreCase("B")) || (!pile.equalsIgnoreCase("C"))) {
                            System.out.println("\nSorry! " + pile + " is not a valid pile, " + player1Name + "...");
                        }
                    }
                    while (cheatingP1) {//testing to see if player 2 chooses a valid amount to subtract
                        System.out.print("\nHow many would you like to remove from pile " + pile + ", " + player1Name + "?\n\n>");
                        oldPileSubtract = keyboard.nextLine();
                        if (isNumeric(oldPileSubtract)) {
                            pileSubtract = Integer.parseInt(oldPileSubtract);
                            if ((pile.equalsIgnoreCase("A")) && (rowA > 0) && (pileSubtract > 0) && (rowA >= pileSubtract)) {
                                rowA = rowA - pileSubtract;
                                cheatingP1 = false;
                            } else if ((pile.equalsIgnoreCase("A")) && (rowA > 0) && (pileSubtract < 0)) {//prevents player 1 from to taking a negative amount from pile A
                                System.out.println("\nNice try, " + player1Name + ".\nAs I'm sure you know, " + pileSubtract + " is a negative number.");
                                System.out.println("You may not take a negative amount of counters-you must choose at least 1.");
                            } else if ((pile.equalsIgnoreCase("A")) && (rowA > 0) && (pileSubtract == 0)) {//prevents player 1 from to taking none from pile A
                                System.out.println("\nNice try, " + player1Name + ".");
                                System.out.println("You may not take 0 counters-you must choose at least 1.");
                            } else if ((pile.equalsIgnoreCase("A")) && (rowA > 1) && (pileSubtract > rowA)) {//prevents player one from taking more than pile A has. which idk why you'd do that but
                                System.out.println("\nPile " + pile + " doesn't have " + pileSubtract + " counters, " + player1Name + "-it only has " + rowA + " counters...Try Again.");
                            } else if ((pile.equalsIgnoreCase("A")) && (rowA == 1) && (pileSubtract > rowA)) {//prevents player one from taking more than pile Chas. which idk why you'd do that but
                                System.out.println("\nPile " + pile + " doesn't have " + pileSubtract + " counters, " + player1Name + "-it only has " + rowA + " counter...Try Again.");
                            } else if ((pile.equalsIgnoreCase("B")) && (rowB > 0) && (pileSubtract > 0) && (rowB >= pileSubtract)) {
                                rowB = rowB - pileSubtract;
                                cheatingP1 = false;
                            } else if ((pile.equalsIgnoreCase("B")) && (rowB > 0) && (pileSubtract < 0)) {//prevents player 1 from to taking a negative amount from pile B
                                System.out.println("\nNice try, " + player1Name + ".\nAs I'm sure you know, " + pileSubtract + " is a negative number.");
                                System.out.println("You may not take a negative amount of counters-you must choose at least 1.");
                            } else if ((pile.equalsIgnoreCase("B")) && (rowB > 0) && (pileSubtract == 0)) {//prevents player 1 from to taking none from pile B
                                System.out.println("\nNice try, " + player1Name + ".");
                                System.out.println("You may not take 0 counters-you must choose at least 1.");
                            } else if ((pile.equalsIgnoreCase("B")) && (rowB > 1) && (pileSubtract > rowB)) {//prevents player one from taking more than pile B has. which idk why you'd do that but
                                System.out.println("\nPile " + pile + " doesn't have " + pileSubtract + " counters, " + player1Name + "-it only has " + rowB + " counters...Try Again.");
                            } else if ((pile.equalsIgnoreCase("B")) && (rowB == 1) && (pileSubtract > rowB)) {//prevents player one from taking more than pile Chas. which idk why you'd do that but
                                System.out.println("\nPile " + pile + " doesn't have " + pileSubtract + " counters, " + player1Name + "-it only has " + rowB + " counter...Try Again.");
                            } else if ((pile.equalsIgnoreCase("C")) && (rowC > 0) && (pileSubtract > 0) && (rowC >= pileSubtract)) {
                                rowC = rowC - pileSubtract;
                                cheatingP1 = false;
                            } else if ((pile.equalsIgnoreCase("C")) && (rowC > 0) && (pileSubtract < 0)) {//prevents player 1 from to taking a negative amount from pile C
                                System.out.println("Nice try, " + player1Name + ".\nAs I'm sure you know, " + pileSubtract + " is a negative number.");
                                System.out.println("You may not take a negative amount of counters-you must choose at least 1.");
                            } else if ((pile.equalsIgnoreCase("C")) && (rowC > 0) && (pileSubtract == 0)) {//prevents player 1 from to taking none from pile C
                                System.out.println("Nice try, " + player1Name + ".");
                                System.out.println("You may not take 0 counters-you must choose at least 1.");
                            } else if ((pile.equalsIgnoreCase("C")) && (rowC > 1) && (pileSubtract > rowC)) {//prevents player one from taking more than pile Chas. which idk why you'd do that but
                                System.out.println("Pile " + pile + " doesn't have " + pileSubtract + " counters, " + player1Name + "-it only has " + rowC + " counters...Try Again.");
                            } else if ((pile.equalsIgnoreCase("C")) && (rowC == 1) && (pileSubtract > rowC)) {//prevents player one from taking more than pile Chas. which idk why you'd do that but
                                System.out.println("Pile " + pile + " doesn't have " + pileSubtract + " counters, " + player1Name + "-it only has " + rowC + " counter...Try Again.");
                            }
                        } else {
                            System.out.println("\nPlease chose a  number");
                        }

                    }//end of player1 pile cheating loop
                } else {//end of p1 turn, start of p2 turn
                    while (invalidP2) {
                        System.out.println();
                        displays();
                        System.out.println();
                        System.out.print("\n" + player2Name + ", choose a pile\n\n>");
                        pile = keyboard.nextLine();
                        if (((pile.equalsIgnoreCase("A")) && (rowA > 0)) || ((pile.equalsIgnoreCase("B")) && (rowB > 0)) || ((pile.equalsIgnoreCase("C")) && (rowC > 0))) {
                            invalidP2 = false;
                        } else if ((pile.equalsIgnoreCase("A")) && (rowA == 0)) {
                            System.out.println("\nSorry! " + pile + " is not a valid pile, " + player2Name + "\nPile " + pile + " is empty!");
                        } else if ((pile.equalsIgnoreCase("B")) && (rowB == 0)) {
                            System.out.println("\nSorry! " + pile + " is not a valid pile, " + player2Name + "\nPile " + pile + " is empty!");
                        } else if ((pile.equalsIgnoreCase("C")) && (rowC == 0)) {
                            System.out.println("\nSorry! " + pile + " is not a valid pile, " + player2Name + "\nPile " + pile + " is empty!");
                        } else if (!(pile.equalsIgnoreCase("A")) || (!pile.equalsIgnoreCase("B")) || (!pile.equalsIgnoreCase("C"))) {
                            System.out.println("\nSorry! " + pile + " is not a valid pile, " + player2Name + "...");
                        }
                    }
                    while (cheatingP2) {//testing to see if player 2 chooses a valid amount to subtract
                        System.out.print("\nHow many would you like to remove from pile " + pile + ", " + player2Name + "?\n\n>");
                        oldPileSubtract = keyboard.nextLine();
                        if (isNumeric(oldPileSubtract)) {
                            pileSubtract = Integer.parseInt(oldPileSubtract);
                            if ((pile.equalsIgnoreCase("A")) && (rowA > 0) && (pileSubtract > 0) && (rowA >= pileSubtract)) {
                                rowA = rowA - pileSubtract;
                                cheatingP2 = false;
                            } else if ((pile.equalsIgnoreCase("A")) && (rowA > 0) && (pileSubtract < 0)) {//prevents player 1 from to taking a negative amount from pile A
                                System.out.println("\nNice try, " + player2Name + ".\nAs I'm sure you know, " + pileSubtract + " is a negative number.");
                                System.out.println("You may not take a negative amount of counters-you must choose at least 1.");
                            } else if ((pile.equalsIgnoreCase("A")) && (rowA > 0) && (pileSubtract == 0)) {//prevents player 1 from to taking none from pile A
                                System.out.println("\nNice try, " + player2Name + ".");
                                System.out.println("You may not take 0 counters-you must choose at least 1.");
                            } else if ((pile.equalsIgnoreCase("A")) && (rowA > 1) && (pileSubtract > rowA)) {//prevents player 2 from taking more than pile A has. which idk why you'd do that but
                                System.out.println("\nPile " + pile + " doesn't have " + pileSubtract + " counters, " + player2Name + "-it only has " + rowA + " counters...Try Again.");
                            } else if ((pile.equalsIgnoreCase("A")) && (rowA == 1) && (pileSubtract > rowA)) {//prevents player one from taking more than pile Chas. which idk why you'd do that but
                                System.out.println("\nPile " + pile + " doesn't have " + pileSubtract + " counters, " + player2Name + "-it only has " + rowA + " counter...Try Again.");
                            } else if ((pile.equalsIgnoreCase("B")) && (rowB > 0) && (pileSubtract > 0) && (rowB >= pileSubtract)) {
                                rowB = rowB - pileSubtract;
                                cheatingP2 = false;
                            } else if ((pile.equalsIgnoreCase("B")) && (rowB > 0) && (pileSubtract < 0)) {//prevents player 2 from to taking a negative amount from pile B
                                System.out.println("\nNice try, " + player2Name + ".\nAs I'm sure you know, " + pileSubtract + " is a negative number.");
                                System.out.println("You may not take a negative amount of counters-you must choose at least 1.");
                            } else if ((pile.equalsIgnoreCase("B")) && (rowB > 0) && (pileSubtract == 0)) {//prevents player 1 from to taking none from pile B
                                System.out.println("\nNice try, " + player2Name + ".");
                                System.out.println("You may not take 0 counters-you must choose at least 1.");
                            } else if ((pile.equalsIgnoreCase("B")) && (rowB > 1) && (pileSubtract > rowB)) {//prevents player 2 from taking more than pile B has. which idk why you'd do that but
                                System.out.println("\nPile " + pile + " doesn't have " + pileSubtract + " counters, " + player2Name + "-it only has " + rowB + " counters...Try Again.");
                            } else if ((pile.equalsIgnoreCase("B")) && (rowB == 1) && (pileSubtract > rowB)) {//prevents player one from taking more than pile Chas. which idk why you'd do that but
                                System.out.println("\nPile " + pile + " doesn't have " + pileSubtract + " counters, " + player2Name + "-it only has " + rowB + " counter...Try Again.");
                            } else if ((pile.equalsIgnoreCase("C")) && (rowC > 0) && (pileSubtract > 0) && (rowC >= pileSubtract)) {
                                rowC = rowC - pileSubtract;
                                cheatingP2 = false;
                            } else if ((pile.equalsIgnoreCase("C")) && (rowC > 0) && (pileSubtract < 0)) {//prevents player 2 from to taking a negative amount from pile C
                                System.out.println("Nice try, " + player2Name + ".\nAs I'm sure you know, " + pileSubtract + " is a negative number.");
                                System.out.println("You may not take a negative amount of counters-you must choose at least 1.");
                            } else if ((pile.equalsIgnoreCase("C")) && (rowC > 0) && (pileSubtract == 0)) {//prevents player 2 from to taking none from pile C
                                System.out.println("Nice try, " + player2Name + ".");
                                System.out.println("You may not take 0 counters-you must choose at least 1.");
                            } else if ((pile.equalsIgnoreCase("C")) && (rowC > 1) && (pileSubtract > rowC)) {//prevents player 2 from taking more than pile Chas. which idk why you'd do that but
                                System.out.println("Pile " + pile + " doesn't have " + pileSubtract + " counters, " + player2Name + "-it only has " + rowC + " counters...Try Again.");
                            } else if ((pile.equalsIgnoreCase("C")) && (rowC == 1) && (pileSubtract > rowC)) {//prevents player 2 from taking more than pile Chas. which idk why you'd do that but
                                System.out.println("Pile " + pile + " doesn't have " + pileSubtract + " counters, " + player2Name + "-it only has " + rowC + " counter...Try Again.");
                            }
                        } else {
                            System.out.println("Please chose a number");
                        }
                    }//end of player2 pile cheating loop
                }//end of p2 turn else if stmt
                totalCounters = (rowA + rowB + rowC);

                if ((totalCounters == (1)) && (!player1Turn)) {
                    System.out.println("\nSorry, " + player1Name + " you must take the remaining counter, so you lose. " + player2Name + ", you win!");
                    player2Wins++;
                    while (wrongInput) {
                        System.out.println("\nWould you like to play again?");
                        System.out.println("\"y\" or \"n\"?");
                        System.out.print("\n>");
                        playAgain = keyboard.nextLine();
                        if ((playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                            wrongInput = false;
                        } else if (!(playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                            System.out.println("Sorry! " + playAgain + " is not a valid choice...");
                        }
                    }
                    System.out.println();
                    if (playAgain.equalsIgnoreCase("n")) {
                        if (player1Wins == 1) {
                            System.out.println(player1Name + " won " + player1Wins + " time.");
                        } else {
                            System.out.println(player1Name + " won " + player1Wins + " times.");
                        }
                        if (player2Wins == 1) {
                            System.out.println(player2Name + " won " + player1Wins + " time.");
                        } else {
                            System.out.println(player2Name + " won " + player2Wins + " times.");
                        }
                        playing = false;
                        game = false;

                        if (player1Wins > player2Wins) {
                            System.out.println(player1Name + " is the Nim Champion!");
                            System.out.println("Thanks for Playing!");

                            playing = false;
                            game = false;
                        } else if (player2Wins > player1Wins) {
                            System.out.println(player2Name + " is the Nim Champion!");
                            System.out.println("Thanks for Playing!");
                        } else {
                            System.out.println("It's a tie!");
                            System.out.println("Thanks for Playing!");
                        }
                        playing = false;
                        game = false;
                    } else {
                        playing = false;
                        rowA = 3;
                        rowB = 5;
                        rowC = 7;

                    }
                } else if ((totalCounters == (1)) && (player1Turn)) {
                    System.out.println("\nSorry, " + player2Name + " you must take the remaining counter, so you lose.\n" + player1Name + ", you win!");
                    player1Wins++;
                    while (wrongInput) {
                        System.out.println("\nWould you like to play again?");
                        System.out.println("\"y\" or \"n\"?");
                        System.out.print("\n>");
                        playAgain = keyboard.nextLine();
                        if ((playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                            wrongInput = false;
                        } else if (!(playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                            System.out.println("Sorry! " + playAgain + " is not a valid choice...");
                        }
                    }
                    System.out.println();
                    if (playAgain.equalsIgnoreCase("n")) {
                        if (player1Wins == 1) {
                            System.out.println(player1Name + " won " + player1Wins + " time.");
                        } else {
                            System.out.println(player1Name + " won " + player1Wins + " times.");
                        }
                        if (player2Wins == 1) {
                            System.out.println(player2Name + " won " + player1Wins + " time.");
                        } else {
                            System.out.println(player2Name + " won " + player2Wins + " times.");
                        }
                        playing = false;
                        game = false;

                        if (player1Wins > player2Wins) {
                            System.out.println(player1Name + " is the Nim Champion!");
                            System.out.println("Thanks for Playing!");

                            playing = false;
                            game = false;
                        } else if (player2Wins > player1Wins) {
                            System.out.println(player2Name + " is the Nim Champion!");
                            System.out.println("Thanks for Playing!");
                            playing = false;
                            game = false;

                        } else {
                            System.out.println("It's a tie!");
                            System.out.println("Thanks for Playing!");
                        }
                        playing = false;
                        game = false;
                    } else {
                        playing = false;
                        rowA = 3;
                        rowB = 5;
                        rowC = 7;

                    }
                } else if ((totalCounters == (0)) && (player1Turn)) {
                    System.out.println("\nSorry, " + player1Name + " you took the remaining counter, so you lose. " + player2Name + ", you win!");
                    player2Wins++;
                    while (wrongInput) {
                        System.out.println("\nWould you like to play again?");
                        System.out.println("\"y\" or \"n\"?");
                        System.out.print("\n>");
                        playAgain = keyboard.nextLine();
                        if ((playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                            wrongInput = false;
                        } else if (!(playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                            System.out.println("Sorry! " + playAgain + " is not a valid choice...");
                        }
                    }
                    System.out.println();
                    if (playAgain.equalsIgnoreCase("n")) {
                        if (player1Wins == 1) {
                            System.out.println(player1Name + " won " + player1Wins + " time.");
                        } else {
                            System.out.println(player1Name + " won " + player1Wins + " times.");
                        }
                        if (player2Wins == 1) {
                            System.out.println(player2Name + " won " + player1Wins + " time.");
                        } else {
                            System.out.println(player2Name + " won " + player2Wins + " times.");
                        }
                        playing = false;
                        game = false;

                        if (player1Wins > player2Wins) {
                            System.out.println(player1Name + " is the Nim Champion!");
                            System.out.println("Thanks for Playing!");

                            playing = false;
                            game = false;
                        } else if (player2Wins > player1Wins) {
                            System.out.println(player2Name + " is the Nim Champion!");
                            System.out.println("Thanks for Playing!");
                        } else {
                            System.out.println("It's a tie!");
                            System.out.println("Thanks for Playing!");
                        }
                    } else {
                        playing = false;

                        rowA = 3;
                        rowB = 5;
                        rowC = 7;
                    }
                } else if ((totalCounters == (0)) && (!player1Turn)) {
                    System.out.println("\nSorry, " + player2Name + " you took the remaining counter, so you lose. " + player1Name + ", you win!");
                    player1Wins++;
                    while (wrongInput) {
                        System.out.println("\nWould you like to play again?");
                        System.out.println("\"y\" or \"n\"?");
                        System.out.print("\n>");
                        playAgain = keyboard.nextLine();
                        if ((playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                            wrongInput = false;
                        } else if (!(playAgain.equalsIgnoreCase("y")) || (playAgain.equalsIgnoreCase("n"))) {
                            System.out.println("Sorry! " + playAgain + " is not a valid choice...");
                        }
                    }
                    System.out.println();
                    if (playAgain.equalsIgnoreCase("n")) {
                        if (player1Wins == 1) {
                            System.out.println(player1Name + " won " + player1Wins + " time.");
                        } else {
                            System.out.println(player1Name + " won " + player1Wins + " times.");
                        }
                        if (player2Wins == 1) {
                            System.out.println(player2Name + " won " + player1Wins + " time.");
                        } else {
                            System.out.println(player2Name + " won " + player2Wins + " times.");
                        }

                        playing = false;
                        game = false;

                        if (player1Wins > player2Wins) {
                            System.out.println(player1Name + " is the Nim Champion!");
                            System.out.println("Thanks for Playing!");

                            playing = false;
                            game = false;
                        } else if (player2Wins > player1Wins) {
                            System.out.println(player2Name + " is the Nim Champion!");
                            System.out.println("Thanks for Playing!");
                        } else {
                            System.out.println("It's a tie!");
                            System.out.println("Thanks for Playing!");
                        }
                    } else {
                        playing = false;

                        rowA = 3;
                        rowB = 5;
                        rowC = 7;
                    }
                }//end of play again stmts
                player1Turn = !player1Turn;
                invalidP1 = true;
                cheatingP1 = true;
                cheatingP2 = true;
                invalidP2 = true;
            }//end of while playing
        }//end of while game
    }

    public static void instructionsMethod() {
        Scanner keyboard = new Scanner(System.in);//rnumber to determine player order
        boolean run;
        run = true;
        int rowA = 3;
        int rowB = 5;
        int rowC = 7;
        String example = "";

        System.out.println("\nHow to Play \"Nim\"\n");
        enter();
        System.out.println("\nObjective:");
        System.out.println("Don't get stuck with the last counter!\n");
        enter();
        System.out.println("\nIf you are playing against another person, you and your opponent will input your names.");
        System.out.println("The order of who goes first will be randomly determined.\n");
        System.out.println("Let's say the person who's chosen to go first is \"Player 1,\" and the person who's chosen to go second is \"Player 2.\"");
        System.out.println("To start the game, \"Player 1\" will pick a pile.\n");
        enter();
        System.out.println("\nThe piles will look like this:");
        System.out.println("\nA: " + rowA + "\tB: " + rowB + "\tC: " + rowC + "\n");
        enter();
        System.out.println("\nOr this:");

        System.out.println("\nA: * * *");
        System.out.println("B: * * * * *");
        System.out.println("C: * * * * * * *");
        enter();
        System.out.println("\nOr this:");
        //FANCIER 
        int greatestRow = 0;
        if ((rowA > rowB) && (rowA > rowC)) {
            greatestRow = rowA;
        } else if ((rowB > rowA) && (rowB > rowC)) {
            greatestRow = rowB;

        } else if ((rowC > rowA) && (rowC > rowB)) {
            greatestRow = rowC;

        } else if ((rowC > rowA) && (rowC == rowB)) {
            greatestRow = rowB;
        } else if ((rowB > rowC) && (rowB == rowA)) {
            greatestRow = rowB;
        } else if ((rowA > rowB) && (rowA == rowC)) {
            greatestRow = rowC;
        }
        System.out.print("");
        for (int i = 0; i < greatestRow; i++) {
            if (rowA > i) {
                System.out.print("*  ");
            } else if (rowA <= i) {
                System.out.print("   ");
            }
            if (rowB > i) {
                System.out.print("*  ");
            } else if (rowB <= i) {
                System.out.print("   ");
            }
            if (rowC > i) {
                System.out.print("*  ");
            } else if (rowC <= i) {
                System.out.print("  ");
            }
            System.out.println();
        }
        System.out.print("\nA  B  C\n\n");

        enter();
//Fanciest
        System.out.println("\nOrrrr this:");
        rowA = 3;
        rowB = 5;
        rowC = 7;

        if ((rowB > rowA) && (rowB > rowC)) {
            greatestRow = rowB;

        } else if ((rowC > rowA) && (rowC > rowB)) {
            greatestRow = rowC;

        } else if ((rowC > rowA) && (rowC == rowB)) {
            greatestRow = rowB;
        } else if ((rowB > rowC) && (rowB == rowA)) {
            greatestRow = rowB;
        } else if ((rowA > rowB) && (rowA == rowC)) {
            greatestRow = rowC;
        }
        System.out.print("\n");
        for (int i = greatestRow; i > 0; i--) {
            if (rowA >= i) {
                System.out.print("*  ");
            } else if (rowA < i) {
                System.out.print("   ");
            }
            if (rowB >= i) {
                System.out.print("*  ");
            } else if (rowB < i) {
                System.out.print("   ");
            }
            if (rowC >= i) {
                System.out.print("*  ");
            } else if (rowC < i) {
                System.out.print("   ");
            }
            System.out.println();
        }
        System.out.print("\nA  B  C\n\n");
        //System.out.println("As you can see, pile \"A\" has three counters, pile \"B\" has five, and pile \"C\" has six.");
        System.out.println("\nTo select a pile, simply type \"A\", \"B\", or \"C\"-capitalization does not matter.\n");
        enter();
        System.out.println("\nHere's an example:");
        System.out.println("\n*Example*\nPlayer 1, you have been randomly selected to go first.");
        System.out.println("\nA: " + rowA + "\tB: " + rowB + "\tC: " + rowC + "\n");
        System.out.println("Player 1, choose a pile.");
        System.out.println("\n>A");
        System.out.println("*End of Example*\n");
        enter();
        System.out.println("\nAfter you have chosen a pile, you will be asked to pick the number of counters you'd like to take from that pile.\n");
        enter();
        System.out.println("\nThen, Player 2 will choose a pile, and pick the number of counters they'd like to take from that pile.");
        System.out.println("Both players will take turns until there is only one counter left.\n");
        enter();
        System.out.println("\nThe player who takes the last counter loses.\n");
        enter();
        System.out.println("\nLEGAL moves include:\n");
        //1 counter legal
        System.out.println("1. Taking ONE counter from the pile");
        System.out.println("2. Taking the ENTIRE pile\n");
        boolean wrongInput = true;
        String exampleLegal = "";
        System.out.println();
        while (wrongInput) {
            System.out.println("Would you like to see an example?");
            System.out.println("\nType \"y\" for yes or \"n\" for no.");
            System.out.print("\n>");
            exampleLegal = keyboard.nextLine();
            System.out.print("\n");
            if ((exampleLegal.equalsIgnoreCase("y")) || (exampleLegal.equalsIgnoreCase("n"))) {
                wrongInput = false;
            } else if (!(exampleLegal.equalsIgnoreCase("y")) || (exampleLegal.equalsIgnoreCase("n"))) {
                System.out.println("Sorry! " + exampleLegal + " is not a valid choice...");
            }
        }
        if (exampleLegal.equalsIgnoreCase("y")) {
            boolean incorrectInput = true;
            String instructionsLegal = "";
            while (incorrectInput) {
                System.out.println("Would you like to see example \"1,\" \"2,\" \"both\" examples, or go \"back\" to the main instructions.");
                System.out.print("\n>");
                instructionsLegal = keyboard.nextLine();
                System.out.print("\n");
                if ((instructionsLegal.equalsIgnoreCase("1")) || (instructionsLegal.equalsIgnoreCase("both")) || (instructionsLegal.equalsIgnoreCase("2")) || (instructionsLegal.equalsIgnoreCase("back"))) {
                    incorrectInput = false;
                } else if (!(instructionsLegal.equalsIgnoreCase("1")) || (instructionsLegal.equalsIgnoreCase("both")) || (instructionsLegal.equalsIgnoreCase("2")) || (instructionsLegal.equalsIgnoreCase("back"))) {
                    System.out.println("Sorry! " + instructionsLegal + " is not a valid choice...");
                }
            }
            if (instructionsLegal.equalsIgnoreCase("1")) {
                System.out.println("Here's an example using the instance of Player 1's first turn-\n");
                //one counter legal
                System.out.println("*Example of taking one counter from the pile (LEGAL)*\nA: " + rowA + "\tB: " + rowB + "\tC: " + rowC + "\n");
                System.out.print("How many would you like to remove from pile A, Player one?\n");
                System.out.println("\n>1");
                System.out.println("\nA: " + (rowA - 1) + "\tB: " + rowB + "\tC: " + rowC);
                System.out.println("*End of Example*\n");
                enter();
            } else if (instructionsLegal.equalsIgnoreCase("2")) {
                System.out.println("Here's an example using the instance of Player 1's first turn-");
                //entire pile legal
                System.out.println("\n*Example of taking all of the counters from the pile (LEGAL)*");
                System.out.println("A: " + rowA + "\tB: " + rowB + "\tC: " + rowC + "\n");
                System.out.print("How many would you like to remove from pile A, Player one?\n");
                System.out.println("\n>3");
                System.out.println("\nA: " + (rowA - 3) + "\tB: " + rowB + "\tC: " + rowC);
                System.out.println("End of Example*\n");
                enter();
            } else if (instructionsLegal.equalsIgnoreCase("both")) {
                System.out.println("Here are some examples using Player 1's first turn-");
                //one counter legal
                System.out.println("\n*Example of taking one counter from the pile (LEGAL)*\nA: " + rowA + "\tB: " + rowB + "\tC: " + rowC + "\n");
                System.out.print("How many would you like to remove from pile A, Player one?\n");
                System.out.println("\n>1");
                System.out.println("\nA: " + (rowA - 1) + "\tB: " + rowB + "\tC: " + rowC);
                System.out.println("*End of Example*\n");
                enter();
                //entire pile legal
                System.out.println("\n*Example of taking all of the counters from the pile (LEGAL)*");
                System.out.println("A: " + rowA + "\tB: " + rowB + "\tC: " + rowC + "\n");
                System.out.print("How many would you like to remove from pile A, Player one?\n");
                System.out.println("\n>3");
                System.out.println("\nA: " + (rowA - 3) + "\tB: " + rowB + "\tC: " + rowC);
                System.out.println("End of Example*\n");
                enter();
                System.out.println();
            }
        }
        //illegal moves
        System.out.println("\nILLEGAL moves include:\n");
        System.out.println("1. Taking more than what is currently in the pile.");
        System.out.println("2. Not taking ANY counters from from the pile");
        System.out.println("3. Trying to take \"negative\" counters from the pile");
        System.out.println("4. Trying to take from piles that are empty\n");
        enter();
        boolean invalidInput = true;
        String instructionsIllegal = "";
        while (invalidInput) {
            System.out.println("Would you like to see an example?");
            System.out.println("Type \"y\" for yes, or \"n\" for no.");
            System.out.print("\n>");
            instructionsIllegal = keyboard.nextLine();
            if ((instructionsIllegal.equalsIgnoreCase("y")) || (instructionsIllegal.equalsIgnoreCase("n"))) {
                invalidInput = false;
            } else if (!(instructionsIllegal.equalsIgnoreCase("y")) || (instructionsIllegal.equalsIgnoreCase("n"))) {
                System.out.println("Sorry! " + instructionsIllegal + " is not a valid choice...");
            }
        }
        //> pile illegal
        if (instructionsIllegal.equalsIgnoreCase("y")) {

            do {
                System.out.println("\nType the number of which example you'd like to see first.");
                System.out.println("Type \"back\" to exit the instructions.\n");
                System.out.println("1. Taking more than what is currently in the pile.");
                System.out.println("2. Not taking ANY counters from from the pile");
                System.out.println("3. Trying to take \"negative\" counters from the pile");
                System.out.println("4. Trying to take from piles that are empty\n");
                System.out.print("\n>");
                wrongInput = true;
                while (wrongInput) {
                    example = keyboard.nextLine();
                    if ((example.equalsIgnoreCase("1")) || (example.equalsIgnoreCase("2")) || (example.equalsIgnoreCase("3")) || (example.equalsIgnoreCase("4"))) {
                        wrongInput = false;
                    } else if (!(example.equalsIgnoreCase("1")) || (example.equalsIgnoreCase("2")) || (example.equalsIgnoreCase("3")) || (example.equalsIgnoreCase("4"))) {
                        System.out.println("Sorry! " + example + " is not a valid choice...");
                    }
                }
                if (example.equalsIgnoreCase("1")) {
                    System.out.println("\n*Example of taking more than what's in the current pile (ILLEGAL)*");
                    System.out.println("A: " + rowA + "\tB: " + rowB + "\tC: " + rowC + "\n");
                    System.out.print("How many would you like to remove from pile A, Player one?");
                    System.out.println("\n\n>4");
                    System.out.println("\nPile A doesn't have 4 counters, Player 1-it only has 3 counters...Try Again.");
                    System.out.println("*End of Example*\n");
                    enter();
                } else if (example.equalsIgnoreCase("2")) {
                    //0 from pile illegal
                    System.out.println("\n*Example of not taking any counters from the  pile (ILLEGAL)*");
                    System.out.println("A: " + rowA + "\tB: " + rowB + "\tC: " + rowC + "\n");
                    System.out.print("How many would you like to remove from pile A, Player one?");
                    System.out.println("\n\n>0");
                    System.out.println("\nNice try, Player 1.");
                    System.out.println("You may not take 0 counters-you must choose at least 1.");
                    System.out.println("*End of Example*\n");
                    enter();
                } else if (example.equalsIgnoreCase("3")) {

                    //< 0 from pile illegal
                    System.out.println("\n*Example of trying to \"take\" negative counters from the pile (ILLEGAL)*");
                    System.out.println("A: " + rowA + "\tB: " + rowB + "\tC: " + rowC + "\n");
                    System.out.print("How many would you like to remove from pile A, Player one?");
                    System.out.println("\n\n>-1\n");
                    System.out.println("Nice try, Player 1.\nAs I'm sure you know, -1 is a negative number.");
                    System.out.println("You may not take a negative amount of counters-you must choose at least 1.");
                    System.out.println("*End of Example*\n");
                } else if (example.equalsIgnoreCase("4")) {
                    System.out.println("\n*Example of trying to \"take\" counters from an empty pile (ILLEGAL)*");
                    System.out.println("A: " + (rowA - 3) + "\tB: " + rowB + "\tC: " + rowC + "\n");
                    System.out.print("How many would you like to remove from pile A, Player one?");
                    System.out.println("\n\n>1\n");
                    System.out.println("\nSorry! Pile A is not a valid pile, Player 1\nPile A is empty!");
                    System.out.println("*End of Example*\n");
                } else if (example.equalsIgnoreCase("back")) {
                    run = false;
                }
            } while (run);
        } else {
            run = false;
        }
    }//instruction method

    public static void enter() {
        System.out.print("Press \"Enter\" to continue. ");
        String pressedKey;

        pressedKey = new Scanner(System.in).nextLine();

    }//end of enterKey method

    public static void displays() {
        if ((displayChoice.equalsIgnoreCase("1")) || (displayChoice.equalsIgnoreCase("basic"))) {
            System.out.println("\nA: " + rowA + "\tB: " + rowB + "\tC: " + rowC + "\n");//basic
        } else if ((displayChoice.equalsIgnoreCase("2")) || (displayChoice.equalsIgnoreCase("fancy"))) {//fancy
            int[] rowArray = {3, 5, 7};
            System.out.println();

            System.out.print("A: ");
            for (int i = 0; i < rowA; i++) {
                System.out.print("* ");
            }
            System.out.print("\nB: ");
            for (int i = 0; i < rowB; i++) {
                System.out.print("* ");
            }
            System.out.print("\nC: ");
            for (int i = 0; i < rowC; i++) {
                System.out.print("* ");
            }
            System.out.println();
        } else if ((displayChoice.equalsIgnoreCase("4")) || (displayChoice.equalsIgnoreCase("fanciest"))) {//fanciest
            int greatestRow = 0;

            if ((rowB > rowA) && (rowB > rowC)) {
                greatestRow = rowB;

            } else if ((rowC > rowA) && (rowC > rowB)) {
                greatestRow = rowC;

            } else if ((rowC > rowA) && (rowC == rowB)) {
                greatestRow = rowB;
            } else if ((rowB > rowC) && (rowB == rowA)) {
                greatestRow = rowB;
            } else if ((rowA > rowB) && (rowA == rowC)) {
                greatestRow = rowC;
            }
            System.out.print("\n");
            for (int i = greatestRow; i > 0; i--) {
                if (rowA >= i) {
                    System.out.print("*  ");
                } else if (rowA < i) {
                    System.out.print("   ");
                }
                if (rowB >= i) {
                    System.out.print("*  ");
                } else if (rowB < i) {
                    System.out.print("   ");
                }
                if (rowC >= i) {
                    System.out.print("*  ");
                } else if (rowC < i) {
                    System.out.print("   ");
                }
                System.out.println();
            }
            System.out.print("\nA  B  C\n");

        } else if ((displayChoice.equalsIgnoreCase("3")) || (displayChoice.equalsIgnoreCase("fancier"))) {//fancier
            int greatestRow = 0;
            if ((rowA > rowB) && (rowA > rowC)) {
                greatestRow = rowA;
            } else if ((rowB > rowA) && (rowB > rowC)) {
                greatestRow = rowB;

            } else if ((rowC > rowA) && (rowC > rowB)) {
                greatestRow = rowC;

            } else if ((rowC > rowA) && (rowC == rowB)) {
                greatestRow = rowB;
            } else if ((rowB > rowC) && (rowB == rowA)) {
                greatestRow = rowB;
            } else if ((rowA > rowB) && (rowA == rowC)) {
                greatestRow = rowC;
            }
            System.out.print("");
            for (int i = 0; i < greatestRow; i++) {
                if (rowA > i) {
                    System.out.print("*  ");
                } else if (rowA <= i) {
                    System.out.print("   ");
                }
                if (rowB > i) {
                    System.out.print("*  ");
                } else if (rowB <= i) {
                    System.out.print("   ");
                }
                if (rowC > i) {
                    System.out.print("*  ");
                } else if (rowC <= i) {
                    System.out.print("  ");
                }
                System.out.println();
            }
            System.out.print("\nA  B  C\n");
        }
    }//end of displays method    

    public static boolean isDouble(String text) {
        double newDouble = 0.0;
        try {
            newDouble = Double.valueOf(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }//end of isDouble method

    public static boolean isInteger(String text) {
        int newInt = 0;
        try {
            newInt = Integer.valueOf(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }//end of isInteger method

    public static boolean isNumeric(String text) {
        return (isDouble(text) || isInteger(text));
    }//end of isNumeric

}//end of class
