package src;

import java.util.HashMap;

public class AI {
    Roster aiRoster;
    HashMap<String,int> possQuestions;

    public AI(possChars Roster) {
        possQuestions = new HashMap<String, Int>();
        possQuestions.put("Is your character male?",1);
        possQuestions.put("Is your character female?",1);
        possQuestions.put("Does your character have brown hair?",0);
        possQuestions.put("Does your character have red hair?",0);
        possQuestions.put("Does your character have blonde hair?",0);
        possQuestions.put("Does your character have green eyes?",0);
        possQuestions.put("Does your character have blue eyes?",0);
        possQuestions.put("Does your character have brown eyes?",0);
        possQuestions.put("Is your character wearing a green shirt?",0);
        possQuestions.put("Is your character wearing a blue shirt?",0);
        possQuestions.put("Is your character wearing a red shirt?",0);

        aiRoster = possChars;
    }

    public String getHighestHval(){
        hvals = possQuestions.values();
        for(i = 0; i < hvals){}
    }

}
