package de.ur.mi.regensburg.wikipedia;


import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Parliament extends Page {
    private FederalState state;

    public Parliament(FederalState state, String contentSelector) {
        super(Config.PAGES_FOR_STATES[state.ordinal()], Language.DE, contentSelector);
        this.state = state;
    }

    public ArrayList<ParliamentMember> members(String posOfInfosRow ) {
        if(!isLoaded()) {
            this.fetchDocument();
        }
        if(getDocument() == null) {
            return null;
        }


        ArrayList<Integer> formattedInfos = reformatInfoRow(posOfInfosRow);

        ArrayList<ParliamentMember> parliament = new ArrayList<>();
        Elements rows;
        if(state== FederalState.BRE) {
            rows = getContentElements().eq(1).select("tbody tr");
        }else{
            rows = getContentElements();
    }
        for(Element el: rows) {
            Elements cells = el.select("td");
            if(cells.size() == 0) {
                continue;
            }

            ParliamentMember.Builder builder = getMemberBuilder(formattedInfos, cells);
            addPhotoUrl(formattedInfos, cells, builder);
            addYearOfBirth(formattedInfos, cells, builder);
            addElectoralDistrictAndKindOfMandate(formattedInfos, cells, builder);
            addVotesPercentage(formattedInfos, cells, builder);
            addComments(formattedInfos, cells, builder);
            addBoards(formattedInfos, cells, builder);
            addListRank(formattedInfos, cells, builder);
            addDistrictRank(formattedInfos, cells, builder);

            ParliamentMember member = builder.build();
            parliament.add(member);
        }
        return parliament;
    }


    private ArrayList<Integer> reformatInfoRow(String posOfInfosRow){
        String[] infos = posOfInfosRow.split(";");
        ArrayList<Integer> formattedInfos = new ArrayList<>();

        for (String info: infos){
            if (info.equals("x")) {
                formattedInfos.add(-1);
            }else{
                int posOfInfo = Integer.parseInt(info) -1;
                formattedInfos.add(posOfInfo);
            }
        }
        return formattedInfos;
    }

    private ParliamentMember.Builder getMemberBuilder(ArrayList<Integer> formattedInfos, Elements cells){
        String federalState = state.name();
        String names = cells.eq(formattedInfos.get(Config.CONFIG_NAME)).select("a").text();
        String firstName = getFirstName(separateNames(names));
        String lastName = getLastName(separateNames(names));
        String party = cells.eq(formattedInfos.get(Config.CONFIG_PARTY)).text();
        return new ParliamentMember.Builder(federalState, party, firstName, lastName);
    }

    private String[]separateNames(String names){
        return names.split("(?<= )");
    }

    private String getFirstName(String[] names){
        int len = names.length;
        String firstName="";
        if (len>1){
            for (int i = 0; i < len-1; i++){
                firstName = firstName + names[i];
            }
            return firstName.trim();
        }
        return names[0].trim();
    }

    private String getLastName ( String[] names){
        return names[names.length-1].trim();
    }
    private void addPhotoUrl(ArrayList<Integer> formattedInfos, Elements cells, ParliamentMember.Builder builder){
        if(formattedInfos.get(Config.CONFIG_PHOTO) != -1){
            String photoUrl = cells.eq(formattedInfos.get(Config.CONFIG_PHOTO)).select("a img").attr("src");
            if(!photoUrl.contains(Config.IMAGE_OF_NONE)) {
                builder.setPhotoURL(photoUrl);
            }
        }
    }

    private void addYearOfBirth(ArrayList<Integer> formattedInfos, Elements cells, ParliamentMember.Builder builder) {
        if(formattedInfos.get(Config.CONFIG_YEAR) != -1) {
            String yearOfBirth = cells.eq(formattedInfos.get(Config.CONFIG_YEAR)).text();
            if(state==FederalState.NRW){
                String[] numbers = yearOfBirth.split("[0-9]{5,}.."); //sieht aus wie whitespace, wird aber nicht als solcher erkannt, auch nicht von trim...
                if(numbers.length > 1) {
                    yearOfBirth = numbers[1];
                }
            }
            builder.setYearOfBirth(yearOfBirth);
        }
    }

    private void addElectoralDistrictAndKindOfMandate(ArrayList<Integer> formattedInfos, Elements cells, ParliamentMember.Builder builder){
        if(formattedInfos.get(Config.CONFIG_ELEC_DIS) != -1) {
            String electoralDistrict;
            if (state == FederalState.BY) {
                electoralDistrict = cells.eq(formattedInfos.get(Config.CONFIG_ELEC_DIS)).select("a").text() + " " + cells.eq(formattedInfos.get(Config.CONFIG_SUBDISTRICT_BY)).select("a").text();
            } else if (formattedInfos.get(Config.CONFIG_DISTRICT_NUM ) != -1) {
                electoralDistrict =  cells.eq(formattedInfos.get(Config.CONFIG_ELEC_DIS)).text() + " " + cells.eq(formattedInfos.get(Config.CONFIG_DISTRICT_NUM )).text();
            } else {
                electoralDistrict = cells.eq(formattedInfos.get(Config.CONFIG_ELEC_DIS)).text();
            }

            if(electoralDistrict.contains("!")){
                electoralDistrict = electoralDistrict.split("!")[1];
            }
            if(state==FederalState.HE && electoralDistrict.contains("Wahlkreis")){
                electoralDistrict = electoralDistrict.split("Wahlkreis")[1];
            }
            builder.setElectoralDistrict(electoralDistrict.trim());
            String kindOfMandate = getKindOfMandate(formattedInfos, cells, electoralDistrict);
            builder.setKindOfMandate(kindOfMandate);
        }
    }

    //To-Do: Verbalisieren der Zahlen -> no magic numbers
    private String getKindOfMandate(ArrayList<Integer> formattedInfos, Elements cells, String electoralDistrict){
        String mandate;
        if(electoralDistrict.equals("Listenmandat")||electoralDistrict.equals("Landesliste")){
            mandate = "Landesliste";
        }else if(state == FederalState.BW){
            mandate = cells.eq(formattedInfos.get(Config.CONFIG_MANDATE_BW)).text();
        }else if(state == FederalState.BY){
            if((cells.eq(formattedInfos.get(Config.CONFIG_MANDATE_BY)).text()).equals("ja")){
                mandate ="Direktmandat";
            }else{
                mandate="Landesliste";
            }
        }else if (state == FederalState.BRE){
            mandate = "keine Infos";
        }else if(state== FederalState.BER){
            if(electoralDistrict.contains("Bezirksliste")){
                mandate = electoralDistrict;
            }else if(electoralDistrict.equals("Landesliste")){
                mandate="Landesliste";
            }else{
                mandate = "Direktmandat";
            }
        }else if(electoralDistrict.equals("")){
            mandate="Landesliste";
        }else{
            mandate = "Direktmandat";
        }
        return mandate;
    }

    private void addVotesPercentage(ArrayList<Integer> formattedInfos, Elements cells, ParliamentMember.Builder builder){
        if(formattedInfos.get(Config.CONFIG_PERCENT) != -1){
            String votesPercentage = cells.eq(formattedInfos.get(Config.CONFIG_PERCENT)).text();
            builder.setVotesPercentage(votesPercentage);
        }
    }

    private void addComments(ArrayList<Integer> formattedInfos, Elements cells, ParliamentMember.Builder builder){
        if(formattedInfos.get(Config.CONFIG_COMMENTS) != -1) {
            String comments = cells.eq(formattedInfos.get(Config.CONFIG_COMMENTS)).text();
            builder.setComments(comments);
        }
    }

    private void addBoards(ArrayList<Integer> formattedInfos, Elements cells, ParliamentMember.Builder builder){
        if(formattedInfos.get(Config.CONFIG_BOARDS) != -1){
            String boards = cells.eq(formattedInfos.get(Config.CONFIG_BOARDS)).text();
            builder.setBoards(boards);
        }
    }

    private void addListRank(ArrayList<Integer> formattedInfos, Elements cells, ParliamentMember.Builder builder){
        if(formattedInfos.get(Config.CONFIG_LIST_RANK) != -1){
            String listRank = cells.eq(formattedInfos.get(Config.CONFIG_LIST_RANK)).text();
            if(listRank.equals("-")){
                listRank = "";
            }
            builder.setListRank(listRank);
        }
    }

    private void addDistrictRank(ArrayList<Integer> formattedInfos, Elements cells, ParliamentMember.Builder builder){
        if(formattedInfos.get(Config.CONFIG_DISTRICT_RANK) != -1){
            String districtRank = cells.eq(formattedInfos.get(Config.CONFIG_DISTRICT_RANK)).text();
            if(districtRank.equals("-")){
                districtRank = "";
            }
            builder.setDistrictRank(districtRank);
        }
    }

}


