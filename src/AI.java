package src;

import java.security.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Set;
import java.util.Random;

public class AI {
    Roster aiRoster;
    HashMap<String,Integer> brain;

    public AI(Roster newRoster) {
        brain = new HashMap<String, Integer>();
        brain.put("male",0);
        brain.put("female",0);
        brain.put("Does your character have brown hair?",1);
        brain.put("Does your character have red hair?",1);
        brain.put("Does your character have blonde hair?",1);
        brain.put("Does your character have green eyes?",1);
        brain.put("Does your character have blue eyes?",1);
        brain.put("Does your character have brown eyes?",1);
        brain.put("Is your character wearing a green shirt?",1);
        brain.put("Is your character wearing a blue shirt?",1);
        brain.put("Is your character wearing a red shirt?",1);

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
}
