package src;

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

    public boolean isHair(String h) {
        if (h.equals(hair)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isEye(String e) {
        if (e.equals(eye)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isShirt(String s) {
        if (s.equals(shirt)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isGender(String g) {
        if (g.equals(gender)) {
            return true;
        } else {
            return false;
        }

    }

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
