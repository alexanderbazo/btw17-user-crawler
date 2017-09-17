package de.ur.mi.regensburg.wikipedia;

/**
 * Created by Anna-Marie on 06.09.2017.
 */
public class BundestagCandidate {

    private final String party;
    private final String firstName;
    private final String lastName;
    private final String yearOfBirth;
    private final String electoralDistrict;
    private final FederalState federalState;
    private final String listRank;
    private final String candidateForWhichParliament;

    public static class Builder {
        //required parameters
        private final String party;
        private final String firstName;
        private final String lastName;
        private final String yearOfBirth;
        private final String candidateForWhichParliament;
        //optional parameters
        private FederalState federalState = FederalState.notDefined;
        private String electoralDistrict = "";
        private String listRank = "";

        public Builder(String party, String firstName, String lastName, String yearOfBirth ) {
            this.party = party;
            this.firstName = firstName;
            this.lastName = lastName;
            this.yearOfBirth = yearOfBirth;
            this.candidateForWhichParliament = "Bundestag";
        }

        public Builder setFederalState(FederalState state){
            federalState = state;
            return this;
        }

        public Builder setElectoralDistrict(String value) {
            electoralDistrict = value;
            return this;
        }

        public Builder setListRank(String value){
            listRank = value;
            return this;
        }

        public BundestagCandidate build() {
            return new BundestagCandidate(this);
        }

    }

    private BundestagCandidate (Builder builder) {
        this.federalState = builder.federalState;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.party = builder.party;
        this.electoralDistrict = builder.electoralDistrict;
        this.yearOfBirth = builder.yearOfBirth;
        this.listRank = builder.listRank;
        this.candidateForWhichParliament = builder.candidateForWhichParliament;
    }

    public FederalState getFederalState(){ return federalState; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public String getListRank(){
        return listRank;
    }

    public String getCandidateForWhichParliament(){
        return candidateForWhichParliament;
    }


    @Override
    public String toString() {
        return "ParliamentMember{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", party='" + party + '\'' +
                ", candidateForWhichParliament='" + candidateForWhichParliament + '\'' +
                ", federalState='" + federalState + '\'' +
                ", electoralDistrict='" + electoralDistrict + '\'' +
                ", listRank='" + listRank + '\'' +
                '}';
    }
}
