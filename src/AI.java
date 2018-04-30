package src;

import java.util.HashMap;
import java.security.Key;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Set;
import java.util.Random;

/**
 * Class AI controls all AI functionality
 * It creates its own version of Roster, stores a
 * list of questions in a HashMap, and performs mathematical calculations
 * to calculate heuristic values and updates the values and lists accordingly
 *
 * @Jill Pulicicchio
 * @date: 04.16.18
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
// Updates heuristic values of each item in the HashMap
    public void updateHvals(){
        for (String key : brain.keySet()) {
            Integer oldVal = brain.get(key);
            Integer newVal = oldVal - 1;
            brain.put(key, newVal);
        }
    }

    
	/*
	 * Compare question asked to questions stored in HashMap
	 * If user answers 'yes' to AI, all three possible questions
	 * in the same category are removed from the HashMap
	 * and the unrelated characters are removed from aiRoster.
	 *
	 * If the user answers 'no' just the question asked is
	 * removed along with the related character
	 */

    public void activateBrain(int response, String quest) {
            //if answer is yes
            if (response == 1) {
                if (quest.equals("red shirt") ) {

                    brain.remove("red shirt");
                    brain.remove("blue shirt");
                    aiRoster.removeCharWithShirt("blue");

                    brain.remove("green shirt");
                    aiRoster.removeCharWithShirt("green");
                }
                else if (quest.equals("green shirt")) {

                    brain.remove("green shirt");
                    brain.remove("blue shirt");
                    aiRoster.removeCharWithShirt("blue");

                    brain.remove("red shirt");
                    aiRoster.removeCharWithShirt("red");
                }
                else if (quest.equals("blue shirt"))
                {
                    brain.remove("blue shirt");


                    brain.remove("red shirt");
                    aiRoster.removeCharWithShirt("red");

                    brain.remove("green shirt");
                    aiRoster.removeCharWithShirt("green");
                }
                else if (quest.equals("brown hair")) {

                    brain.remove("brown hair");
              //      aiRoster.removeCharWithShirt("brown");


                    brain.remove("blonde hair");
                    aiRoster.removeCharWithHair("blonde");


                    brain.remove("red hair");
                    aiRoster.removeCharWithHair("red");

                } else if (quest.equals("blonde hair")) {

                    brain.remove("blonde hair");


                    brain.remove("brown hair");
                    aiRoster.removeCharWithHair("brown");


                    brain.remove("red hair");
                    aiRoster.removeCharWithHair("red");

                } else if (quest.equals("red hair")) {

                    brain.remove("red hair");

                    brain.remove("blonde hair");
                    aiRoster.removeCharWithHair("blonde");


                    brain.remove("brown hair");
                    aiRoster.removeCharWithHair("brown");

                } else if (quest.equals("brown eyes")) {


                    brain.remove("blue eyes");

                    brain.remove("blue eyes");
                    aiRoster.removeCharWithEyes("blue");

                    brain.remove("green eyes");
                    aiRoster.removeCharWithEyes("green");

                } else if (quest.equals("blue eyes")) {

                    brain.remove("blue eyes");

                    brain.remove("brown eyes");
                    aiRoster.removeCharWithEyes("brown");

                    brain.remove("green eyes");
                    aiRoster.removeCharWithEyes("green");

                } else if (quest.equals("green eyes")) {

                    brain.remove("green eyes");

                    brain.remove("brown eyes");
                    aiRoster.removeCharWithEyes("brown");

                    brain.remove("blue eyes");
                    aiRoster.removeCharWithEyes("blue");


                } else if (quest.equals("female")) {


                    brain.remove("male");
                    aiRoster.removeCharWithGender("male");

                    brain.remove("female");



                } else if (quest.equals("male")) {

                    brain.remove("female");
                    aiRoster.removeCharWithGender("female");

                    brain.remove("male");

                }

            } else {
                if(quest.equals("red shirt"))
                {
                    brain.remove("red shirt");
                    aiRoster.removeCharWithShirt("red");
                }

                else if(quest.equals("blue shirt"))
                {
                    brain.remove("blue shirt");
                    aiRoster.removeCharWithShirt("blue");
                }

                else if(quest.equals("green shirt"))
                {
                    brain.remove("green shirt");
                    aiRoster.removeCharWithShirt("green");
                }

                else if(quest.equals("blonde hair"))
                {
                    brain.remove("blonde hair");
                    aiRoster.removeCharWithHair("blonde");
                }

                else if(quest.equals("brown hair"))
                {
                    brain.remove("brown hair");
                    aiRoster.removeCharWithHair("brown");
                }

                else if(quest.equals("red hair"))
                {
                    brain.remove("red hair");
                    aiRoster.removeCharWithHair("red");

                }
                else if (quest.equals("brown eyes"))
                {
                    brain.remove("brown eyes");
                    aiRoster.removeCharWithEyes("brown");

                } else if (quest.equals("green eyes"))
                {
                    brain.remove("green eyes");
                    aiRoster.removeCharWithEyes("green");
                }
                else if (quest.equals("blue eyes"))
                {
                    brain.remove("blue eyes");
                    aiRoster.removeCharWithEyes("blue");
                }
                else if (quest.equals("female"))
                {
                    brain.remove("female");
                    brain.remove("male");
                    aiRoster.removeCharWithGender("female");

                } else if (quest.equals("male"))
                {
                    brain.remove("male");
                    brain.remove("female");
                    aiRoster.removeCharWithGender("male");
                }
            }

        updateHvals();
        questions.clear();
    }
}
