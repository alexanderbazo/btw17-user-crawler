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

        public static void writeHeader(BufferedWriter bw, String separator) throws IOException {
                String line = Config.HEADER_YEAR_OF_BIRTH + separator
                        + Config.HEADER_PARTY + separator
                        + Config.HEADER_LAST_NAME + separator
                        + Config.HEADER_FIRST_NAME + separator
                        + Config.HEADER_STATE + separator
                        + Config.HEADER_PARLIAMENT + separator
                        + Config.HEADER_COMMENTS + separator
                        + Config.HEADER_BOARDS + separator
                        + Config.HEADER_ELECTORAL_DISTRICT + separator
                        + Config.HEADER_KIND_OF_MANDATE + separator
                        + Config.HEADER_VOTES_PERCENTAGE + separator
                        + Config.HEADER_LIST_RANK + separator
                        + Config.HEADER_DISTRICT_RANK + separator
                        + Config.HEADER_PHOTO_URL + System.lineSeparator();
                if (bw != null) {
                        bw.write(line);
                } else {
                        System.out.println("BufferedReader is null");
                }
        }

        public static void writeHeaderForCandidateFile(BufferedWriter bw, String separator) throws  IOException {
            String line = Config.HEADER_YEAR_OF_BIRTH + separator
                    + Config.HEADER_PARTY + separator
                    + Config.HEADER_LAST_NAME + separator
                    + Config.HEADER_FIRST_NAME + separator
                    + Config.HEADER_CANDIDATE_WHICH_PARLIAMENT + separator
                    + Config.HEADER_STATE + separator
                    + Config.HEADER_ELECTORAL_DISTRICT + separator
                    + Config.HEADER_LIST_RANK + System.lineSeparator();
            if (bw != null) {
                bw.write(line);
            } else {
                System.out.println("BufferedReader is null");
            }
        }

        public static void writeLine(BufferedWriter bw, ParliamentMember member, String separator, char customquote) throws IOException {
                String line = Config.CSV_QUOTES +member.getYearOfBirth() +Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getParty() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getLastName() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getFirstName() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + Config.STATES_NAMES[member.getFederalState().ordinal()] + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getKindOfParliament() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getComments() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getBoards() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getElectoralDistrict() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getKindOfMandate() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getVotesPercentage() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getListRank() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getDistrictRank() + Config.CSV_QUOTES + separator
                        + Config.CSV_QUOTES + member.getPhotoURL() + Config.CSV_QUOTES + System.lineSeparator();
                if (bw != null) {
                    bw.write(line);
                } else {
                    System.out.println("BufferedReader is null");
                }
        }

    public static void writeLineForCandidateFile(BufferedWriter bw, BundestagCandidate member, String separator) throws IOException {
        String line = Config.CSV_QUOTES +member.getYearOfBirth() +Config.CSV_QUOTES + separator
                + Config.CSV_QUOTES + member.getParty() + Config.CSV_QUOTES + separator
                + Config.CSV_QUOTES + member.getLastName() + Config.CSV_QUOTES + separator
                + Config.CSV_QUOTES + member.getFirstName() + Config.CSV_QUOTES + separator
                + Config.CSV_QUOTES + member.getCandidateForWhichParliament() + Config.CSV_QUOTES + separator
                + Config.CSV_QUOTES + Config.STATES_NAMES[member.getFederalState().ordinal()] + Config.CSV_QUOTES + separator
                + Config.CSV_QUOTES + member.getElectoralDistrict() + Config.CSV_QUOTES + separator
                + Config.CSV_QUOTES + member.getListRank() + Config.CSV_QUOTES + System.lineSeparator();
        if (bw != null) {
            bw.write(line);
        } else {
            System.out.println("BufferedReader is null");
        }
    }
    }

