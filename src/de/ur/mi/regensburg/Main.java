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
        TH: passt -> bei leeren Einträgen directMandate=false
        SH: passt -> Bei "Listenmandat" directMandate=false
        SAH: passt -> Bei "Listenmandat" directMandate=false
        SAC:passt-> bei leeren Einträgen directMandate = false
        SL: passt -> bei "Landesliste" directMandate = false;
        RP: passt -> bei leeren Einträgen directMandate = false (list nicht immer true, Nachrücker...)
        NRW:passt -> bei "Landesliste" directMandate= false
        NS:passt -> bei "Landesliste" directMandate = false
        MVP:passt -> bei "Landesliste" directMandate= false;
        HE: Wahlkreis vor Wahlkreisname weg -> bei "Landesliste" directMandate = false;
        HA:passt-> bei leer oder - directMandate = false;
        BRE: passt -> Zahlen durch Bremen bzw. Bremerhaven ersetzen
        BRA:passt -> leere Einträge directMandate = false
        BER:passt -> "Landesliste" directMandate=false, Liste -> Landesliste, Bezirksliste
        BY: passt -> direkt Mandat nach entsprechender Spalte ja-> true
        BW: passt -> es gibt nicht Direkt/List, sondern 1./2. -> nach entsprechender Spalte



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
