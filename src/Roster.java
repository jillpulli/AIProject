package src;

import java.util.ArrayList;

public class Roster {

    private ArrayList<Character> charList;



    public Roster() {
        charList = new ArrayList<>();
    }



    public void addChar(Character ch){

        charList.add(ch);
    }

    public void removeChar(Character ch){

        charList.remove(ch);
    }


    public int getSize() {

        return charList.size();
    }

    //Return character from specified index
    public Character getChar(int i) {
        return charList.get(i);
    }



    //get attributes of each playable character
    public String getAttributes() {

        String attributes = "";

        for(int i = 0; i < charList.size(); i++) {
            attributes += charList.get(i).getName() + " has attributes: " + "eye color " + charList.get(i).getEye() + ", hair color: " + charList.get(i).getHair() + ", shirt color: " + charList.get(i).getShirt() + ", and gender: " + charList.get(i).getGender() + "\n";

        }
        return attributes;
    }
    //get attributes of Player's character
    public String getMyCharacter() {
        String myChar = "";
        for(int i = 0; i< charList.size(); i++) {

            if(charList.get(i).isMyCharacter()){
                myChar += charList.get(i).getName() + " has attributes: " + "eye color " + charList.get(i).getEye() + ", hair color: " + charList.get(i).getHair() + ", shirt color: " + charList.get(i).getShirt() + ", and gender: " + charList.get(i).getGender() + "\n";
            }
        }
        return myChar;
    }



    public void removeCharacterHair(String charhair) {
        for(int i = 0; i < charList.size(); i++ ){
            if(!charList.get(i).isHair(charhair)){
               charList.remove(i);
            }
        }
    }

    public void removeCharacterGender(String chargen) {
        for(int i = 0; i < charList.size(); i++ ){
            if(!charList.get(i).isGender(chargen)){
                charList.remove(i);
            }
        }
    }

    public void removeCharacterShirt(String charshirt) {
        for(int i = 0; i < charList.size(); i++ ){
            if(!charList.get(i).isShirt(charshirt)){
                charList.remove(i);
            }
        }
    }

    public void removeCharacterEye(String chareye) {
        for(int i = 0; i < charList.size(); i++ ){
            if(!charList.get(i).isEye(chareye)){
                charList.remove(i);
            }
        }
    }

    public String toString()
    {
        String showItems="";

        if(charList.size() == 1){
            showItems = "The character is " + charList.get(0).toString();
        }
        else
        {
            showItems = "The characters are: ";
        for(int i = 0; i<charList.size(); i++) {
            if (charList.size() - 1 == i) {
                showItems += "and " + charList.get(i).toString();
            } else {
                showItems += charList.get(i).toString() + ", ";
            }
        }
        }

        return  showItems;
    }



}
