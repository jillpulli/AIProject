package src;

import java.util.ArrayList;
import java.io.*;
import java.util.Random;

public class Driver {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));



    public static void main(String args[]) throws IOException {
        //Gameboard setup
        //Make characters
        Character Jill = new Character("red", "brown:", "female", "green", "Jill");
        Character Sean = new Character("red", "green", "male", "green", "Sean");
        Character Becky = new Character("brown", "brown", "female", "blue", "Becky");
        Character Tom = new Character("brown", "green", "male", "blue", "Tom");
        Character Caroline = new Character("blonde", "blue", "female", "blue", "Caroline");
        Character Curtis = new Character("brown", "blue", "male", "red", "Curtis");
        Character Steph = new Character("brown", "brown", "female", "red", "Steph");

        //Add characters to ArrayList
        Roster people = new Roster();
        people.addChar(Jill);
        people.addChar(Sean);
        people.addChar(Becky);
        people.addChar(Tom);
        people.addChar(Caroline);
        people.addChar(Curtis);
        people.addChar(Steph);

        //create AI Object and copy Roster
        AI aibot = new AI(people);

        //create gameplay loop
        boolean noWinner = true;

        //create turn loop
        boolean turn = true;

        //Create Random number from array for user and computer
        Random rand = new Random();
        int computerNum = rand.nextInt(people.getSize());
        int userNum = rand.nextInt(people.getSize());

        //Set random number from array to specific character
        //call to isPlayer and isComputer from Character class to
        // set boolean switch to true to indicate if it belongs to user or computer
        people.getChar(computerNum).setAsComputer();
        people.getChar(userNum).setAsPlayer();

        //These values are for the buffered reader input for AI response
        String q = "";
        int answer = 2;


        //Create Menu and character names
        System.out.println("Welcome to Guess Who!");
        System.out.println("You will be assigned a random character from the list of created characters");
        System.out.println("You can either guess who the computer has, or ask a question");
        System.out.println("Once you have either made a guess or asked a question, you turn ends and the computer will go");
        System.out.println("Your goal is to guess who the computer has before it guesses your character first!");
        System.out.println("Good Luck!\n");
        System.out.println("\nYour character is: " + people.getChar(userNum).toString());

        System.out.println("//test this is the computer's character//");
        System.out.println(people.getChar(computerNum).toString());


        while (noWinner) {
            printMenu();
            do {


                String s = in.readLine().trim();
                int i = Integer.parseInt(s);


                //  System.out.print(i);
                // System.out.println("");

                switch (i) {
                    //Ask question
                    case 1:
                        displayQuestions();

                        String t = in.readLine().trim();
                        int j = Integer.parseInt(t);


                        switch (j) {
                            case 1:
                                //male?
                                if (people.getChar(computerNum).isGender("male")) {
                                    System.out.println("Yes!");
                                } else {
                                    System.out.println("No");
                                }
                                turn = false;
                                break;
                            case 2:
                                //female?
                                if (people.getChar(computerNum).isGender("female")) {
                                    System.out.println("Yes!");
                                } else {
                                    System.out.println("No");
                                }
                                turn = false;
                                break;
                            case 3:
                                //red hair?
                                if (people.getChar(computerNum).isHair("brown")) {
                                    System.out.println("Yes!");
                                } else {
                                    System.out.println("No");
                                }
                                turn = false;
                                break;
                            case 4:
                                //brown hair?
                                if (people.getChar(computerNum).isHair("red")) {
                                    System.out.println("Yes!");
                                } else {
                                    System.out.println("No");
                                }
                                turn = false;
                                break;
                            case 5:
                                //blonde hair?
                                if (people.getChar(computerNum).isHair("blonde")) {
                                    System.out.println("Yes!");
                                } else {
                                    System.out.println("No");
                                }
                                turn = false;
                                break;
                            case 6:
                                //brown eyes?
                                if (people.getChar(computerNum).isEye("green")) {
                                    System.out.println("Yes!");
                                } else {
                                    System.out.println("No");
                                }
                                turn = false;
                                break;
                            case 7:
                                //green eyes?
                                if (people.getChar(computerNum).isEye("blue")) {
                                    System.out.println("Yes!");
                                } else {
                                    System.out.println("No");
                                }
                                turn = false;
                                break;
                            case 8:
                                //blue eyes?
                                if (people.getChar(computerNum).isEye("brown")) {
                                    System.out.println("Yes!");
                                } else {
                                    System.out.println("No");
                                }
                                turn = false;
                                break;
                            case 9:
                                //green shirt?
                                if (people.getChar(computerNum).isShirt("green")) {
                                    System.out.println("Yes!");

                                } else {
                                    System.out.println("No");
                                }
                                turn = false;
                                break;
                            case 10:
                                //blue shirt?
                                if (people.getChar(computerNum).isShirt("blue")) {
                                    System.out.println("Yes!");
                                } else {
                                    System.out.println("No");
                                }

                                turn = false;
                                break;
                            case 11:
                                //red shirt?
                                if (people.getChar(computerNum).isShirt("red")) {

                                    System.out.println("Yes!");
                                } else {
                                    System.out.println("No");
                                    turn = false;
                                    break;
                                }
                        }

                        break;
                    //Guess computer's character
                    case 2:
                        System.out.println("Input the character that you believe the AI has\n First letter capitalized Please :)");
                        String guess = in.readLine().trim();
                        if (people.getChar(computerNum).isName(guess)) {
                            System.out.println("Congratulations! You guessed correctly!\n You win!!!\nThanks for Playing :D");
                            noWinner = false;
                        } else {
                            System.out.println("No, try again.");
                        }
                        break;
                    //See list of playable characters

                    case 3:
                        System.out.println(people.toString());

                        break;
                    //see ALL characters' attributes
                    case 4:
                        System.out.println(people.getAttributes());
                        break;
                    //See User's character and their attributes
                    case 5:
                        System.out.println(people.getMyCharacter());
                        break;
                    //Quit game
                    case 6:
                        System.out.println("Goodbye!");
                        turn = false;
                        noWinner = false;
                        break;

                }
            } while (turn);

            //AI takes turn
            //check for highest h value in Hashmap to ask question
            //If yes, remove appropriate characters from aiRoster
            //Delete question from Hashmap
            //get traits from remaining characters and update question values
            //If no, do same, but with opposite answers
            if (turn == false) {
                System.out.println("Is " + aibot.bestQuestion() + " true?" + "\nType '1' for yes and '0' for no");

                q = in.readLine().trim();
                answer = Integer.parseInt(q);



                if (answer == 1) {
                    aibot.activateBrain(1);
                } else {
                    aibot.activateBrain(0);
                }
                turn = true;

            }
        }
    }
    // Display main menu
    public static void printMenu(){
        System.out.println("Your game options are:");
        System.out.println("1. Ask Question (ends turn)");
        System.out.println("2. Guess Computer's character (ends turn)");
        System.out.println("3. See List of playable characters in game");
        System.out.println("4. See ALL Characters' attributes");
        System.out.println("5. See MY character and their attributes");
        System.out.println("6. Quit Game");

    }




//display list of possible questions that the user can ask the computer
    public static void displayQuestions() {
        System.out.println("1. Is your character male?");
        System.out.println("2. Is your character female?");
        System.out.println("3. Does your character have brown hair?");
        System.out.println("4. Does your character have red hair?");
        System.out.println("5. Does your character have blonde hair?");
        System.out.println("6. Does your character have green eyes?");
        System.out.println("7. Does your character have blue eyes?");
        System.out.println("8. Does your character have brown eyes?");
        System.out.println("9. Is your character wearing a green shirt?");
        System.out.println("10. Is your character wearing a blue shirt?");
        System.out.println("11. Is your character wearing a red shirt?");
    }

}
