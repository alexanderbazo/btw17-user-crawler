package de.ur.mi.regensburg.wikipedia;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by Anna-Marie on 06.09.2017.
 */
public class CandidatesList extends Page {

    public CandidatesList(String page, String contentSelector) {
        super(page, Language.DE, false, true, contentSelector);
    }

    public ArrayList<BundestagCandidate> members() {
        if(!isLoaded()) {
            this.fetchDocument();
        }
        if(getDocument() == null) {
            return null;
        }

        //ArrayList<Integer> formattedInfos = reformatInfoRow(posOfInfosRow);

        ArrayList<BundestagCandidate> candidatesList = new ArrayList<>();
        Element table;
        table = getContentElements().first();
        Elements rows = table.getElementsByClass("tablesaw").select("tbody tr");
        for(Element el: rows) {
            Elements names = el.select("th");
            Elements cells = el.select("td");
            if(cells.size() == 0 && names.size() == 0) {
                continue;
            }
            BundestagCandidate.Builder builder = getMemberBuilder(cells, names);
            addRestOfInfos(cells, builder);
            BundestagCandidate candidate = builder.build();

            candidatesList.add(candidate);

        }
        return candidatesList;
    }

    private BundestagCandidate.Builder getMemberBuilder(Elements cells, Elements name){
        String names = name.text();
        String[] candidateNames = names.split(",");
        String yearOfBirth = cells.eq(0).text();
        String firstName = "";
        String lastName = "";
        if(candidateNames!=null && candidateNames.length>1){
            firstName = candidateNames[0].trim();
            lastName = candidateNames[1].trim();
        }
        String party = cells.eq(1).text();
        return new BundestagCandidate.Builder(party, firstName, lastName, yearOfBirth);
    }

    private void addRestOfInfos(Elements cells, BundestagCandidate.Builder builder){
        String infos = cells.eq(2).text();
        String[] splitInfos = infos.split("und");
        if(splitInfos.length > 1){
            setElectoralDistrict(splitInfos[0], builder);
            String stateInfos = splitInfos[1];
            setStateAndListRank(stateInfos, builder);
        }else {
            if(splitInfos[0].contains("Wahlkreis")){
                setElectoralDistrict(splitInfos[0], builder);
            }else if(splitInfos[0].contains("Land")){
                setStateAndListRank(splitInfos[0], builder);
            }
        }


    }

    private void setElectoralDistrict(String district,BundestagCandidate.Builder builder){
        builder.setElectoralDistrict(district.trim());
    }

    private void setStateAndListRank (String stateInfos, BundestagCandidate.Builder builder){
        String[] splitStateInfos = stateInfos.split("\\(Platz");
        String state = splitStateInfos[0].substring(5).trim();
        builder.setFederalState(getState(state));
        String listRank = splitStateInfos[1];
        listRank = listRank.replace(')', ' ').trim();
        builder.setListRank(listRank);
    }

    private FederalState getState(String stateStr){
        for (int i = 0; i < Config.STATES_NAMES.length; i++) {
            if (Config.STATES_NAMES[i].equals(stateStr)) {
                return FederalState.values()[i];
            }else if (stateStr.contains("ringen")){
                return FederalState.TH;
            }else if (stateStr.contains("Baden-W")){
                return FederalState.BW;
            }
        }
        return null;
    }

}

