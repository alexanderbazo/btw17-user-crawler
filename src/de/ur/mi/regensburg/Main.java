package de.ur.mi.regensburg;

import de.ur.mi.regensburg.wikipedia.BavarianParliament;
import de.ur.mi.regensburg.wikipedia.ParliamentMember;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BavarianParliament parliament = new BavarianParliament();
        ArrayList<ParliamentMember> members = parliament.members();
        for(ParliamentMember m: members) {
            System.out.println(m);
        }
    }
}
