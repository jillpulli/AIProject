/**
    Class Roster organizes the characters into an ArrayList
    It has methods to use functions for the ArrayList outside of the class,
    methods to remove/access characters with specific traits (for AI)
    and print methods to display character attributes

  @author Rebecca Hedum
  @date 04.16.18

 **/

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

    public void removeChar(int ch){

        charList.remove(ch);
    }

    //Remove all characters with specific shirt color

    public void removeCharWithShirt(String shirt){
        for (int i = 0; i < charList.size(); i++) {
            if(charList.get(i).isShirt(shirt)){
                charList.remove(i);
            }
        }
    }
    //Remove all characters with specific gender

    public void removeCharWithGender(String gender){
        for (int i = 0; i < charList.size(); i++) {
            if(charList.get(i).isGender(gender)){
                charList.remove(i);
            }
        }
    }

    //Remove all character with specific eye color

    public void removeCharWithEyes(String eyes){
        for (int i = 0; i < charList.size(); i++) {
            if(charList.get(i).isEye(eyes)){
                charList.remove(i);
            }
        }
    }
    //Remove all characters with specific hair color

    public void removeCharWithHair(String hair){
        for (int i = 0; i < charList.size(); i++) {
            if(charList.get(i).isHair(hair)){
                charList.remove(i);
            }
        }
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
    public String getMyCharacter(int i) {
       String myChar = "";
        myChar += charList.get(i).getName() + " has attributes: " + "eye color " + charList.get(i).getEye() + ", hair color: " + charList.get(i).getHair() + ", shirt color: " + charList.get(i).getShirt() + ", and gender: " + charList.get(i).getGender() + "\n";

        return myChar;
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
