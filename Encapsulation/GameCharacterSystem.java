import java.util.ArrayList;
import java.util.List;

interface PlayableCharacter {
    void performSpecialMove();
}

abstract class Character implements PlayableCharacter {
    String name;
    int HP;
    int MP;
    int AP;
    int DP;
    float speed;
    int level;

    Character (String name, int HP, int MP, int AP, int DP, float speed, int level) {
        this.name = name;
        this.HP = HP;
        this.MP = MP;
        this.AP = AP;
        this.DP = DP;
        this.speed = speed;
        this.level = level;
    }

    public abstract void attack();
    public abstract void defend();

    public void showStats() {
        System.out.println("==== Character Stats ====\n");
        System.out.println("      Name   : " + name);
        System.out.println("      HP     : " + HP);
        System.out.println("      MP     : " + MP);
        System.out.println("      AP     : " + AP);
        System.out.println("      DP     : " + DP);
        System.out.println("      Speed  : " + speed);
        System.out.println("      Level  : " + level + "\n");
    }
}

class Warrior extends Character {
    Warrior (String name, int HP, int MP, int AP, int DP, float speed, int level) {
        super(name, HP, MP, AP, DP, speed, level);
    }

    @Override
    public void attack() {
        System.out.println("⚔ " + name + " attacks with sword with AP : " + AP);
    }

    @Override
    public void defend() {
        if (HP > 50)
            System.out.println("🛡️ ️" + name + " defends with a shield and HP decreases by : " + (HP-30));
        else
            System.out.println("☠️ " + name + " Dies !!");
    }

    @Override
    public void performSpecialMove() {
        System.out.println(name + " uses Santoryu and deals a damage of : " + (AP*3));
    }
}

class Archer extends Character {
    Archer (String name, int HP, int MP, int AP, int DP, float speed, int level) {
        super(name, HP, MP, AP, DP, speed, level);
    }

    @Override
    public void attack() {
        System.out.println("🏹 " + name + " attacks with Arrow with AP : " + AP);
    }

    @Override
    public void defend() {
        if (HP > 40)
            System.out.println("🛡️ ️" + name + " defends with a shield and HP decreases by : " + (HP-40));
        else
            System.out.println("☠️ " + name + " Dies !!");
    }

    @Override
    public void performSpecialMove() {
        System.out.println(name + " uses Kaen Boshi and deals a damage of : " + (AP*2.5));
    }
}


class Mage extends Character {
    Mage (String name, int HP, int MP, int AP, int DP, float speed, int level) {
        super(name, HP, MP, AP, DP, speed, level);
    }

    @Override
    public void attack() {
        System.out.println("🧙‍♂️ " + name + " attacks with Magic with AP : " + AP);
    }

    @Override
    public void defend() {
        if (HP > 25)
            System.out.println("🛡️ ️" + name + " defends with a shield and HP decreases by : " + (HP-25));
        else
            System.out.println("☠️ " + name + " Dies !!");
    }

    @Override
    public void performSpecialMove() {
        System.out.println(name + " uses Thunderbolt and deals a damage of : " + (AP*4));
    }
}

public class GameCharacterSystem {
    public static void main(String[] args) {
        List<Character> characterList = new ArrayList<>();

        Character w = new Warrior("Zoro",140,0,45,20,25,7);
        Character a = new Archer("Ussop",30,0,30,20,15,4);
        Character m = new Mage("Nami",60,90,15,20,10,4);

        characterList.add(w);
        characterList.add(a);
        characterList.add(m);

        for (Character ch : characterList) {
            System.out.println("--------------------------------------");
            ch.showStats();
            ch.attack();
            ch.defend();
            ch.performSpecialMove();
            System.out.println("--------------------------------------\n");
        }
    }

}