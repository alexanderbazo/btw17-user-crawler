package de.ur.mi.regensburg;

import de.ur.mi.regensburg.wikipedia.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        FileWriter fw = null;
        BufferedWriter bw = null;
        String separator = ";";
        String fileName = "BundestagCandidates.csv";

        try {
            fw = new FileWriter(fileName);
            bw = new BufferedWriter(fw);
        }catch (IOException e) {
            e.printStackTrace();
        }

        try{
            ParliamentMemberCSVWriter.writeHeaderForCandidateFile(bw, separator);
            for (int i = 'a'; i <= 'z'; i++) {
                if(i != 'x') {
                    String page = ((char) i) + ".html";
                    CandidatesList candidates = new CandidatesList(page, "main figure");

                    ArrayList<BundestagCandidate> members = candidates.members();


                    for (int j = 0; j < members.size(); j++) {
                        BundestagCandidate member = members.get(j);
                        ParliamentMemberCSVWriter.writeLineForCandidateFile(bw, member, separator);
                    }
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


    /*// use this to scrape from wikipedia
    public static void main(String[] args) {
        //String path = Config.PATH_TO_BUNDESTAG_STRUCTURE_CSV;
        String path = Config.PATH_TO_STATE_STRUCTURE_CSV;

        ArrayList<String> rows = CSVReader.readCSV(path);
        FileWriter fw = null;
        BufferedWriter bw = null;
        String separator = ";";
        String fileName = "landtagParliamentMembers.csv";
        //String fileName= "bundestagParliamentMembers.csv";

        try {
            fw = new FileWriter(fileName);
            bw = new BufferedWriter(fw);
        }catch (IOException e) {
            e.printStackTrace();
        }

        try{
            ParliamentMemberCSVWriter.writeHeader(bw, separator);
            for (int i = 0; i < 16; i++) {
                Parliament parliament = initParliament(Config.LANDTAG, i);


                ArrayList<ParliamentMember> members = parliament.members(rows.get(i));


                for (int j = 0; j < members.size(); j++) {
                    ParliamentMember member = members.get(j);
                    ParliamentMemberCSVWriter.writeLine(bw, member, separator);
                }
            }

            /*
            Parliament parliament = initParliament(Config.BUNDESTAG, 17);
            ParliamentMemberCSVWriter.writeHeader(bw, separator);

                ArrayList<ParliamentMember> members = parliament.members(rows.get(0));
                for (int j = 0; j < members.size(); j++) {
                    ParliamentMember member = members.get(j);
                    ParliamentMemberCSVWriter.writeLine(bw, member, separator);
                    System.out.println(member);
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
            parliament = new Parliament(Config.PAGE_BUNDESTAG, "table.sortable tbody tr", FederalState.notDefined);
        }

        return parliament;
    }

*/
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

