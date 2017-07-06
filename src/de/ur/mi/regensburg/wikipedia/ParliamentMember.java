package de.ur.mi.regensburg.wikipedia;

/**
 * Created by fon on 08.06.2017.
 *
 * Builder Pattern after http://www.javaspecialists.eu/archive/Issue163.html
 */
public class ParliamentMember {

    private final String federalState;
    private final String party;
    private final String firstName;
    private final String lastName;
    private final String yearOfBirth; //int?
    private final String electoralDistrict;
    private final String votesPercentage; //double?
    private final String kindOfMandate; //boolean?
    private final String photoURL;
    private final String comments;
    private final String boards;

    public static class Builder {
        //required parameters
        private final String federalState;
        private final String party;
        private final String firstName;
        private final String lastName;
        //optional parameters
        private String votesPercentage = ""; //double?
        private String kindOfMandate = ""; //enum?
        private String electoralDistrict = "";
        private String yearOfBirth =""; //int?
        private String photoURL = "";
        private String comments = "";
        private String boards = "";


        public Builder(String federalState, String party, String firstName, String lastName) {
            this.federalState = federalState;
            this.party = party;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder setVotesPercentage(String value) {
            votesPercentage = value;
            return this;
        }

        public Builder setKindOfMandate(String value) {
            kindOfMandate = value;
            return this;
        }

        public Builder setElectoralDistrict(String value) {
            electoralDistrict = value;
            return this;
        }

        public Builder setYearOfBirth (String value) {
            yearOfBirth = value;
            return this;
        }

        public Builder setPhotoURL (String value){
            photoURL = value;
            return this;
        }

        public Builder setComments(String value){
            comments = value;
            return this;
        }

        public Builder setBoards (String value){
            boards = value;
            return this;
        }


        public ParliamentMember build() {
            return new ParliamentMember(this);
        }

    }

    private ParliamentMember(Builder builder) {
        this.federalState = builder.federalState;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.party = builder.party;
        this.votesPercentage = builder.votesPercentage;
        this.kindOfMandate = builder.kindOfMandate;
        this.electoralDistrict = builder.electoralDistrict;
        this.yearOfBirth = builder.yearOfBirth;
        this.photoURL = builder.photoURL;
        this.comments = builder.comments;
        this.boards = builder.boards;
    }

    public String getFederalState(){ return federalState; }

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

    public String getVotesPercentage() {
        return votesPercentage;
    }

    public String getKindOfMandate(){
        return kindOfMandate;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public String getComments() {
        return comments;
    }

    public String getBoards() {
        return boards;
    }

    @Override
    public String toString() {
        return "ParliamentMember{" +
                "federalState='" + federalState + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", party='" + party + '\'' +
                ", electoralDistrict='" + electoralDistrict + '\'' +
                ", votesPercentage='" + votesPercentage + '\'' +
                ", kindOfMandate='" + kindOfMandate + '\'' +
                ", photoURL='" + photoURL + '\'' +
                ", comments='" + comments + '\'' +
                ", boards='" + boards + '\'' +
                '}';
    }

}
