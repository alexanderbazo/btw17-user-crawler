package de.ur.mi.regensburg;

import de.ur.mi.regensburg.wikipedia.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    /* currently no test
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
        String path = Config.PATH_TO_STATE_STRUCTURE_CSV;

        ArrayList<String> rows = CSVReader.readCSV(path);
        FileWriter fw = null;
        BufferedWriter bw = null;
        String separator = ";";
        String fileName = "landtagParliamentMembers.csv";

        try {
            fw = new FileWriter(fileName);
            bw = new BufferedWriter(fw);
        }catch (IOException e) {
            e.printStackTrace();
        }

        try{
            for (int i = 0; i < 16; i++) {
                Parliament parliament = initParliament(Config.LANDTAG, i);

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

    private static Parliament initParliament(int kindOfParliament, int stateOrdinal ) {
        Parliament parliament;
        if (kindOfParliament == Config.LANDTAG){
            if (stateOrdinal == FederalState.BRE.ordinal()) {
                parliament = new Parliament(Config.PAGES_FOR_STATES[stateOrdinal], "table.sortable", FederalState.values()[stateOrdinal]);
            } else {
                parliament = new Parliament(Config.PAGES_FOR_STATES[stateOrdinal], "table.sortable tbody tr", FederalState.values()[stateOrdinal]);
            }
        }else{
            parliament = new Parliament(Config.PAGE_BUNDESTAG, "table.sortable tbody tr");
        }

        return parliament;
    }


    /*
    try {
            fw = new FileWriter(fileName);
            bw = new BufferedWriter(fw);
        }catch (IOException e) {
            e.printStackTrace();
        }

        try{
            for (int i = 0; i < 16; i++) {
                Parliament parliament;
                if (i == FederalState.BRE.ordinal()) {
                    parliament = new Parliament(Config.PAGES_FOR_STATES[FederalState.values()[i].ordinal()], "table.sortable");
                } else {
                    parliament = new Parliament(Config.PAGES_FOR_STATES[FederalState.values()[i].ordinal()], "table.sortable tbody tr");
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
     */

}

