package de.ur.mi.regensburg;

import de.ur.mi.regensburg.wikipedia.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    /* CSV Writing test -> only one parliament in csv
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

    public static void main(String[] args) {
        ArrayList<String> rows = CSVReader.readCSV(Config.PATH_TO_STRUCTURE_CSV);
        FileWriter fw = null;
        BufferedWriter bw = null;
        String separator = ";";

        try {
            fw = new FileWriter("member.csv");
            bw = new BufferedWriter(fw);
        }catch (IOException e) {
            e.printStackTrace();
        }

        try{
            for (int i = 0; i < 16; i++) {
                Parliament parliament;
                if (i == FederalState.BRE.ordinal()) {
                    parliament = new Parliament(FederalState.values()[i], "table.sortable");
                } else {
                    parliament = new Parliament(FederalState.values()[i], "table.sortable tbody tr");
                }

                ArrayList<ParliamentMember> members = parliament.members(rows.get(i));

                for (int j = 0; j < members.size(); j++) {
                    ParliamentMember member = members.get(j);
                    ParliamentMemberCSVWriter.writeLine(bw, member, separator);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

        /*//original version
        Parliament parliament = new Parliament(FederalState.BY);
        ArrayList<ParliamentMember> members = parliament.members();
        for(ParliamentMember m: members) {
            System.out.println(m);
        }
        */