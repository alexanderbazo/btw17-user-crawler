package de.ur.mi.regensburg.wikipedia;

/**
 * Created by fon on 08.06.2017.
 */
public class ParliamentMember {

    private final String yearOfBirth;
    private final String party;
    private final String electoralDistrict;

    public ParliamentMember(String name, String yearOfBirth, String party, String electoralDistrict) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.party = party;
        this.electoralDistrict = electoralDistrict;
    }

    public String getName() {
        return name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getParty() {
        return party;
    }

    public String getElectoralDistrict() {
        return electoralDistrict;
    }

    private final String name;

    @Override
    public String toString() {
        return "ParliamentMember{" +
                "name='" + name + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", party='" + party + '\'' +
                ", electoralDistrict='" + electoralDistrict + '\'' +
                '}';
    }

}
