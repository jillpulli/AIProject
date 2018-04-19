package src;

/**
 * Class Character stores all of the characteristics of each individual character.
 * Contains appropriate getters and setters for each of the traits,
 * as well boolean checks for the AI to use.
 *
 * @author Curtis Baillie
 * @date 04.16.18
 */
public class Character {

    private String hair;
    private String eye;
    private String gender;
    private String shirt;
    private String name;
    private boolean isPlayer;
    private boolean isComputer;

    public Character(String hair, String eye, String gender, String shirt, String name) {
        this.hair = hair;
        this.eye = eye;
        this.gender = gender;
        this.shirt = shirt;
        this.name = name;
        isPlayer = false;
        isComputer = false;
    }

    public void setAsPlayer(){
        isPlayer = true;
    }

    public boolean isMyCharacter() {
        return isPlayer;
    }

    public boolean isComputerCharacter() {
        return isComputer;
    }

    public void setAsComputer() {
        isComputer = true;
    }

    public String getHair(){
        return hair;
    }

    public String getEye() {
        return eye;
    }

    public String getGender() {
        return gender;
    }

    public String getShirt() {
        return shirt;
    }

    public String getName() {
        return name;
    }

    //Returns true if character has specific hair color
    public boolean isHair(String h) {
        if (h.equals(hair)) {
            return true;
        } else {
            return false;
        }

    }
    //Returns true if character has specific eye color
    public boolean isEye(String e) {
        if (e.equals(eye)) {
            return true;
        } else {
            return false;
        }

    }
    //Returns true if character has specific shirt color
    public boolean isShirt(String s) {
        if (s.equals(shirt)) {
            return true;
        } else {
            return false;
        }

    }

    //Returns true if character has specific gender
    public boolean isGender(String g) {
        if (g.equals(gender)) {
            return true;
        } else {
            return false;
        }

    }

    //Returns true if character has specific name
    public boolean isName(String n) {
        if (n.equals(name)) {
            return true;
        } else {
            return false;
        }

    }

    public String toString() {
        return name;
    }
}
