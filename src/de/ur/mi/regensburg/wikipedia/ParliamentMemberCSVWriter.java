package de.ur.mi.regensburg.wikipedia;

/**
 * Created by Anna-Marie on 06.07.2017.
 * Code-base from http://www.mkyong.com/java/how-to-export-data-to-csv-file-java/
 *
 * writes CSV-Files from ParliamentMembers, Quotes serve to prevent column-errors (separator in data)
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
public class ParliamentMemberCSVWriter {

        private static final String DEFAULT_SEPARATOR = ",";

        public static void writeLine(BufferedWriter w, ParliamentMember member) throws IOException {
            writeLine(w, member, DEFAULT_SEPARATOR, ' ');
        }

        public static void writeLine(BufferedWriter w, ParliamentMember member, String separator) throws IOException {
            writeLine(w, member, separator, ' ');
        }


        public static void writeLine(BufferedWriter bw, ParliamentMember member, String separator, char customQuote) throws IOException {
                String line = member.getYearOfBirth() + separator
                        + Config.CSV_QUOTES + member.getParty() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getLastName() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getFirstName() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getFederalState() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getComments() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getBoards() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getElectoralDistrict() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getKindOfMandate() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getVotesPercentage() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getListRank() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getDistrictRank() + Config.CSV_QUOTES + System.lineSeparator();
                if (bw != null) {
                    bw.write(line);
                } else {
                    System.out.println("BufferedReader is null");
                }
        }
    }

