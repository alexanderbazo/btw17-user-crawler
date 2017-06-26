package de.ur.mi.regensburg.wikipedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Anna-Marie on 25.06.2017.
 *
 */
public class CSVReader {
        public static ArrayList<String> readCSV(String separator, String pathToCSV) {
            ArrayList <String> rows = new ArrayList<String>();
            String line = "";
            try (BufferedReader br = new BufferedReader(new FileReader(pathToCSV))) {

                while ((line = br.readLine()) != null) {
                    rows.add(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            rows.remove(0);

            return rows;
        }
    }
