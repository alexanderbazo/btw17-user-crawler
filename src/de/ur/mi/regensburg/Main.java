package de.ur.mi.regensburg;

import de.ur.mi.regensburg.wikipedia.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> rows = CSVReader.readCSV(";", Config.PATH_TO_STRUCTURE_CSV);

        /* //endg�ltige Version -> f�rs Tests evtl ausgegraut
       for(int i = 0; i < 16; i++){
            Parliament parliament;
            if(i == FederalState.BRE.ordinal()){
               parliament = new Parliament(FederalState.values()[i],  "table.sortable");
            }else{
               parliament = new Parliament(FederalState.values()[i],  "table.sortable tbody tr");
            }

            ArrayList<ParliamentMember> members = parliament.members(rows.get(i));
            for(ParliamentMember m: members) {
                System.out.println(m);
            }

        }
        */


        /* test-subject: electoral District
        result: not yet evaluated, probably mixed results
        TH:
        SH:
        SAH:
        SAC:
        SL:
        RP:
        NRW:
        NS:
        MVP:
        HE:
        HA:
        BRE:
        BRA:
        BER:
        BY:
        BW:



         */
        for(int i = 0; i < 16; i++){
            Parliament parliament;
            if(i == FederalState.BRE.ordinal()){
               parliament = new Parliament(FederalState.values()[i],  "table.sortable");
            }else{
               parliament = new Parliament(FederalState.values()[i],  "table.sortable tbody tr");
            }

            ArrayList<ParliamentMember> members = parliament.members(rows.get(i));
            for(ParliamentMember m: members) {
                System.out.println(m);
            }

        }


        /*//original version
        Parliament parliament = new Parliament(FederalState.BY);
        ArrayList<ParliamentMember> members = parliament.members();
        for(ParliamentMember m: members) {
            System.out.println(m);
        }
        */

        /*//test
        System.out.println(FederalState.BW.name());
        System.out.println(FederalState.BW.ordinal());
        */
    }
}
