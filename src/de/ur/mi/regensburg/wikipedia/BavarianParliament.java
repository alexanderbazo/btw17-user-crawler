package de.ur.mi.regensburg.wikipedia;


import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class BavarianParliament extends Page {

    public BavarianParliament() {
        super("Liste_der_Mitglieder_des_Bayerischen_Landtags_(17._Wahlperiode)", Language.DE, "table.wikitable tbody tr");
    }

    public ArrayList<ParliamentMember> members() {
        if(!isLoaded()) {
            this.fetchDocument();
        }
        if(getDocument() == null) {
            return null;
        }
        ArrayList<ParliamentMember> parliament = new ArrayList<ParliamentMember>();
        Elements rows = getContentElements();
        for(Element el: rows) {
            Elements cells = el.select("td");
            if(cells.size() == 0) {
                continue;
            }
            String name = cells.eq(0).text();
            String yearOfBirth = cells.eq(1).text();
            String party = cells.eq(2).text();
            String electoralDistrict = cells.eq(4).text();
            ParliamentMember member = new ParliamentMember(name, yearOfBirth, party, electoralDistrict);
            parliament.add(member);
        }
        return parliament;
    }
}


