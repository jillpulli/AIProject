package src;

import java.util.HashMap;
import java.security.Key;
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
    ArrayList<String> questions = new ArrayList<>();



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
            Integer oldVal = brain.get(key);
            Integer newVal = oldVal - 1;
            brain.put(key, newVal);
        }
    }

    public void testHash() {
        System.out.println("Before removal");
        for( String s : brain.keySet() ) {
            System.out.println( s );
        }
    }

    public void setupAI() {
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
       // System.out.println(lowest);
    }


	/*

	 * get a character that matches character in question

	 */


    public void activateBrain(int response) {
        if (aiRoster.getSize() == 1) {
            aiRoster.getChar(0).getName();
        } else

        {
            //if answer is yes
            if (response == 1) {
                if (brain.containsKey("red shirt") ) {

                    brain.remove("red shirt");


                    brain.remove("blue shirt");
                    aiRoster.removeCharWithShirt("blue");

                    brain.remove("green shirt");
                    aiRoster.removeCharWithShirt("green");
                }
                else if (brain.containsKey("green shirt")) {

                    brain.remove("green shirt");


                    brain.remove("blue shirt");
                    aiRoster.removeCharWithShirt("blue");

                    brain.remove("red shirt");
                    aiRoster.removeCharWithShirt("red");
                }
                else if (brain.containsKey("blue shirt"))
                {
                    brain.remove("blue shirt");


                    brain.remove("red shirt");
                    aiRoster.removeCharWithShirt("red");

                    brain.remove("green shirt");
                    aiRoster.removeCharWithShirt("green");
                }
                else if (brain.containsKey("brown hair")) {

                    brain.remove("brown hair");
              //      aiRoster.removeCharWithShirt("brown");


                    brain.remove("blonde hair");
                    aiRoster.removeCharWithHair("blonde");


                    brain.remove("red hair");
                    aiRoster.removeCharWithHair("red");

                } else if (brain.containsKey("blonde hair")) {

                    brain.remove("blonde hair");


                    brain.remove("brown hair");
                    aiRoster.removeCharWithHair("brown");


                    brain.remove("red hair");
                    aiRoster.removeCharWithHair("red");

                } else if (brain.containsKey("red hair")) {

                    brain.remove("red hair");

                    brain.remove("blonde hair");
                    aiRoster.removeCharWithHair("blonde");


                    brain.remove("brown hair");
                    aiRoster.removeCharWithHair("brown");

                } else if (brain.containsKey("brown eyes")) {


                    brain.remove("blue eyes");

                    brain.remove("blue eyes");
                    aiRoster.removeCharWithEyes("blue");

                    brain.remove("green eyes");
                    aiRoster.removeCharWithEyes("green");

                } else if (brain.containsKey("blue eyes")) {

                    brain.remove("blue eyes");

                    brain.remove("brown eyes");
                    aiRoster.removeCharWithEyes("brown");

                    brain.remove("green eyes");
                    aiRoster.removeCharWithEyes("green");

                } else if (brain.containsKey("green eyes")) {

                    brain.remove("green eyes");

                    brain.remove("brown eyes");
                    aiRoster.removeCharWithEyes("brown");

                    brain.remove("blue eyes");
                    aiRoster.removeCharWithEyes("blue");


                } else if (brain.containsKey("female")) {


                    brain.remove("male");
                    aiRoster.removeCharWithGender("male");

                    brain.remove("female");



                } else if (brain.containsKey("male")) {

                    brain.remove("female");
                    aiRoster.removeCharWithGender("female");

                    brain.remove("male");

                }

            } else {
                if(brain.containsKey("red shirt"))
                {
                    brain.remove("red shirt");
                    aiRoster.removeCharWithShirt("red");
                }

                else if(brain.containsKey("blue shirt"))
                {
                    brain.remove("blue shirt");
                    aiRoster.removeCharWithShirt("blue");
                }

                else if(brain.containsKey("green shirt"))
                {
                    brain.remove("green shirt");
                    aiRoster.removeCharWithShirt("green");
                }

                else if(brain.containsKey("blonde hair"))
                {
                    brain.remove("blonde hair");
                    aiRoster.removeCharWithHair("blonde");
                }

                else if(brain.containsKey("brown hair"))
                {
                    brain.remove("brown hair");
                    aiRoster.removeCharWithHair("brown");
                }

                else if(brain.containsKey("red hair"))
                {
                    brain.remove("red hair");
                    aiRoster.removeCharWithHair("red");

                }
                else if (brain.containsKey("brown eyes"))
                {
                    brain.remove("brown eyes");
                    aiRoster.removeCharWithEyes("brown");

                } else if (brain.containsKey("green eyes"))
                {
                    brain.remove("green eyes");
                    aiRoster.removeCharWithEyes("green");
                }
                else if (brain.containsKey("blue eyes"))
                {
                    brain.remove("blue eyes");
                    aiRoster.removeCharWithEyes("blue");
                }
                else if (brain.containsKey("female"))
                {
                    brain.remove("female");
                    aiRoster.removeCharWithGender("female");

                } else if (brain.containsKey("male"))
                {
                    brain.remove("male");
                    aiRoster.removeCharWithGender("male");
                }
            }
        }
        updateHvals();
        //questions.clear();
    }


}
