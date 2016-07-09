package com.nickjwpark.pokemon;

/**
 * Created by Nick on 7/9/16.
 */
public class Pokemon {

    public String name = "";
    public String attack = "";
    public String cry = "";
    public int health = 1;
    public int power = 1;
    public int defense = 1;

    public Pokemon(String name_i) {
        name = name_i;
    }

    public Pokemon(String name_i, String attack_i, String cry_i) {
        name = name_i;
        attack = attack_i;
        cry = cry_i;
    }

    public Pokemon(String name_i, String attack_i, String cry_i, int health_i, int power_i, int defense_i) {
        name = name_i;
        attack = attack_i;
        cry = cry_i;
        health = health_i;
        power = power_i;
        defense = defense_i;
    }

    public String introduce(){
        String introduction = "" + cry + "! This is " + name + ", attacks with " + attack + ". Power: " + power + " Defense: " + defense + " Health: " + health;
        return introduction;
    }

    public void setCry(String cry_i) {
        cry = cry_i;
        LogLibrary.print(name + "'s new cry is '" + cry + "'");
    }

    public String cry() {
        LogLibrary.print(cry);
        return cry;
    }

    public void setAttack(String attack_i) {
        attack = attack_i;
        LogLibrary.print(name + "'s new attack is " + attack);
    }

    public String getAttack() {
        return attack;
    }

    public void setName(String name_i) {
        LogLibrary.print(name + "'s new name is " + name_i);
        name = name_i;
    }

    public String getName() {
        return name;
    }

    public int health_upgrade(int upgrade){
        health = health + upgrade;
        LogLibrary.print(name+"'s new health is "+ health);
        return health;
    }

    public int power_upgrade(int upgrade){
        power = power + upgrade;
        LogLibrary.print(name+"'s new attack power is "+ power);
        return power;
    }

    public int defense_upgrade(int upgrade){
        defense = defense + upgrade;
        LogLibrary.print(name+"'s new defense is "+ defense);
        return defense;
    }

    public int attack(){
        LogLibrary.print("" + cry + "! " + name +" attacked with "+ attack + " for " + power + " damage!");
        return power;
    }

    public int attacked(int damage){
        health = health - (damage - defense);
        LogLibrary.print("" + cry + "... " + name + " was attacked with " + damage + "damage, but with defense of "+
                defense + ", reduced damage to " + (damage - defense) + " and now has " + health +
                " health left!");
        return health;
    }
}
