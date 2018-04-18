package src;

import java.util.HashMap;
import java.security.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Set;
import java.util.Random;

/**
 * Class AI takes in a Roster of possible
 */
public class AI {
    Roster aiRoster;
    HashMap<String,Integer> brain;

    public AI(Roster newRoster) {
        brain = new HashMap<String, Integer>();
        brain.put("male",0);
        brain.put("female",0);
        brain.put("brown hair",1);
        brain.put("red hair",1);
        brain.put("blonde hair",1);
        brain.put("green eyes",1);
        brain.put("blue eyes",1);
        brain.put("brown eyes",1);
        brain.put("green shirt",1);
        brain.put("blue shirt",1);
        brain.put("red shirt",1);

        aiRoster = newRoster;
    }

    //returns the best question to ask user based off of lowest heuristic value
    public String bestQuestion(){
        Integer lowestHval = 100;
        ArrayList<String> questions = new ArrayList<>();
        String question ="";
        Iterator itty = brain.values().iterator();

        while(itty.hasNext()){
            Integer inty = (Integer)itty.next();
            if(inty < lowestHval){
                lowestHval = inty;
            }
        }
        for(String key: brain.keySet()) {
            if (brain.get(key).equals(lowestHval)) {
                questions.add(key);
            }
        }

        if (questions.size() > 1) {
            Random r = new Random();
            int index = r.nextInt(questions.size());
            return questions.get(index);
        }
        else {
            return questions.get(0);
        }
    }

    public void updateHvals(){
        for (String key : brain.keySet()) {
            brain.put(key, brain.get(key) + 1);
        }
    }

    public static void main(String args[]) {
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
        AI ai = new AI(people);
        String lowest = ai.bestQuestion();
        System.out.println(lowest);
    }


	/*

	 * get a character that matches character in question

	 */


    public void activateBrain(int response) {
        if (aiRoster.getSize() == 1) {
            aiRoster.getChar(0).getName();
        } else

        {
            if (response == 1) {
                if (brain.equals("red shirt")) {

                    brain.remove("blue shirt", brain.get("blue shirt"));
                    aiRoster.removeCharWithShirt("blue shirt");
                    brain.remove("green shirt", brain.get("green shirt"));
                    aiRoster.removeCharWithShirt("green shirt");
                }
                else if (brain.equals("green shirt")) {

                    brain.remove("blue shirt", brain.get("blue shirt"));
                    aiRoster.removeCharWithShirt("blue shirt");
                    brain.remove("red shirt", brain.get("red shirt"));
                    aiRoster.removeCharWithShirt("red shirt");
                }
                else if (brain.equals("red shirt"))
                {
                    brain.remove("blue shirt", brain.get("blue shirt"));
                    aiRoster.removeCharWithShirt("blue shirt");
                    brain.remove("green shirt", brain.get("green shirt"));
                    aiRoster.removeCharWithShirt("green shirt");
                }
                else if (brain.equals("brown hair")) {
                    brain.remove("blonde hair", brain.get("blonde hair"));
                    aiRoster.removeCharWithShirt("blonde hair");
                    brain.remove("red hair", brain.get("red hair"));
                    aiRoster.removeCharWithShirt("red hair");
                } else if (brain.equals("blonde hair")) {

                    brain.remove("brown hair", brain.get("brown hair"));
                    aiRoster.removeCharWithShirt("brown hair");
                    brain.remove("red hair", brain.get("red hair"));
                    aiRoster.removeCharWithShirt("red hair");

                } else if (brain.equals("red hair")) {
                    brain.remove("blonde hair", brain.get("blonde hair"));
                    aiRoster.removeCharWithShirt("blonde hair");
                    brain.remove("brown hair", brain.get("brown hair"));
                    aiRoster.removeCharWithShirt("brown hair");

                } else if (brain.equals("brown eyes")) {
                    brain.remove("blue eyes", brain.get("blue eyes"));
                    aiRoster.removeCharacterEye("blue");
                    brain.remove("green eyes", brain.get("green eyes"));
                    aiRoster.removeCharacterEye("green");
                } else if (brain.equals("blue eyes")) {
                    brain.remove("brown eyes", brain.get("brown eyes"));
                    aiRoster.removeCharacterEye("brown");
                    brain.remove("green eyes", brain.get("green eyes"));
                    aiRoster.removeCharacterEye("green");
                } else if (brain.equals("green eyes")) {
                    brain.remove("brown eyes", brain.get("brown eyes"));
                    aiRoster.removeCharacterEye("brown");
                    brain.remove("blue eyes", brain.get("blue eyes"));
                    aiRoster.removeCharacterEye("blue");


                } else if (brain.equals("female")) {
                    brain.remove("male", brain.get("male"));
                    aiRoster.removeCharacterGender("male");
                    brain.remove("female", brain.get("female"));
                    aiRoster.removeCharWithGender("female");


                } else if (brain.equals("male")) {
                    brain.remove("female", brain.get("female"));
                    aiRoster.removeCharWithGender("female");
                    brain.remove("male", brain.get("male"));
                    aiRoster.removeCharacterGender("male");
                }

            } else {
                if(brain.equals("red shirt"))
                {
                    brain.remove("red shirt", brain.get("red shirt"));
                    aiRoster.removeCharWithShirt("red shirt");
                }

                else if(brain.equals("blue shirt"))
                {
                    brain.remove("blue shirt", brain.get("blue shirt"));
                    aiRoster.removeCharWithShirt("blue shirt");
                }

                else if(brain.equals("green shirt"))
                {
                    brain.remove("green shirt", brain.get("green shirt"));
                    aiRoster.removeCharWithShirt("green shirt");
                }

                else if(brain.equals("blonde hair"))
                {
                    brain.remove("blonde hair", brain.get("blonde hair"));
                    aiRoster.removeCharWithShirt("blonde hair");
                }

                else if(brain.equals("brown hair"))
                {
                    brain.remove("brown hair", brain.get("brown hair"));
                    aiRoster.removeCharWithShirt("brown hair");
                }

                else if(brain.equals("red hair"))
                {
                    brain.remove("red hair", brain.get("red hair"));
                    aiRoster.removeCharWithShirt("red hair");

                }
                else if (brain.equals("brown eyes"))
                {
                    brain.remove("brown eyes", brain.get("brown eyes"));
                    aiRoster.removeCharacterEye("brown");
                } else if (brain.equals("green eyes"))
                {
                    brain.remove("green eyes", brain.get("green eyes"));
                    aiRoster.removeCharacterEye("green");
                }
                else if (brain.equals("blue eyes"))
                {
                    brain.remove("blue eyes", brain.get("blye eyes"));
                    aiRoster.removeCharacterEye("blue");
                }
                else if (brain.equals("female"))
                {
                    brain.remove("male", brain.get("male"));
                    aiRoster.removeCharWithGender("male");

                } else if (brain.equals("male"))
                {
                    brain.remove("female", brain.get("female"));
                    aiRoster.removeCharWithGender("female");
                }
            }
        }
        updateHvals();
    }


}
