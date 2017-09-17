package de.ur.mi.regensburg.wikipedia;

/**
 * Created by Anna-Marie on 23.06.2017.
 *
 * Constants and config info
 */
public class Config {
    //To-Do: Überprüfen, ob tatsächlich überall neueste Daten? (Saarland, NRW!)
    public static final String PAGE_BW = "Liste_der_Mitglieder_des_Landtags_von_Baden-W%C3%BCrttemberg_(16._Wahlperiode)";
    public static final String PAGE_BY = "Liste_der_Mitglieder_des_Bayerischen_Landtags_(17._Wahlperiode)";
    public static final String PAGE_BER = "Liste_der_Mitglieder_des_Abgeordnetenhauses_von_Berlin_(18._Wahlperiode)";
    public static final String PAGE_BRA = "Liste_der_Mitglieder_des_Brandenburgischen_Landtages_(6._Wahlperiode)";
    public static final String PAGE_BRE = "Liste_der_Mitglieder_der_Bremischen_B%C3%BCrgerschaft_(19._Wahlperiode)";
    public static final String PAGE_HA = "Liste_der_Mitglieder_der_Hamburgischen_B%C3%BCrgerschaft_(21._Wahlperiode)";
    public static final String PAGE_HE = "Liste_der_Mitglieder_des_Hessischen_Landtags_(19._Wahlperiode)";
    public static final String PAGE_MVP = "Liste_der_Mitglieder_des_Landtages_Mecklenburg-Vorpommern_(7._Wahlperiode)";
    public static final String PAGE_NS = "Liste_der_Mitglieder_des_Nieders%C3%A4chsischen_Landtages_(17._Wahlperiode)";
    public static final String PAGE_NRW = "Liste_der_Mitglieder_des_Landtages_Nordrhein-Westfalen_(17._Wahlperiode)";
    public static final String PAGE_RP = "Liste_der_Mitglieder_des_Landtages_Rheinland-Pfalz_(17._Wahlperiode)";
    public static final String PAGE_SL = "Liste_der_Mitglieder_des_Saarl%C3%A4ndischen_Landtages_(16._Wahlperiode)";
    public static final String PAGE_SAC = "Liste_der_Mitglieder_des_S%C3%A4chsischen_Landtags_(6._Wahlperiode)";
    public static final String PAGE_SAH = "Liste_der_Mitglieder_des_Landtages_Sachsen-Anhalt_(7._Wahlperiode)";
    public static final String PAGE_SH_alt = "Liste_der_Mitglieder_des_Landtages_Schleswig-Holstein_(18._Wahlperiode)";
    public static final String PAGE_TH = "Liste_der_Mitglieder_des_Th%C3%BCringer_Landtags_(6._Wahlperiode)";
    public static final String PAGE_SH_neu = "Liste_der_Mitglieder_des_Landtages_Schleswig-Holstein_(19._Wahlperiode)";

    public static final String PAGE_BUNDESTAG = "Liste_der_Mitglieder_des_Deutschen_Bundestages_(18._Wahlperiode)";

    //Array to facilitate access to State-Pages, position in array is same as enum-ordinal of the state
    public static final String[] PAGES_FOR_STATES ={PAGE_BW, PAGE_BY, PAGE_BER, PAGE_BRA, PAGE_BRE, PAGE_HA, PAGE_HE, PAGE_MVP, PAGE_NS, PAGE_NRW, PAGE_RP, PAGE_SL, PAGE_SAC, PAGE_SAH, PAGE_SH_neu, PAGE_TH};

    //Path to CSV for structure info about webpages
    public static final String PATH_TO_STATE_STRUCTURE_CSV = "E:\\Anna-Marie\\Documents\\Studium\\TwitterSHK\\DataScraper\\btw17-user-crawler\\ConfigFileFederalStateScraper.csv";
    public static final String PATH_TO_BUNDESTAG_STRUCTURE_CSV = "E:\\Anna-Marie\\Documents\\Studium\\TwitterSHK\\DataScraper\\btw17-user-crawler\\ConfigFileBundestagScraper.csv";

    //image of none
    public static final String IMAGE_OF_NONE= "Image_of_none.svg";


    public static final int CONFIG_PHOTO = 0;
    public static final int CONFIG_NAME = 1;
    public static final int CONFIG_YEAR = 2;
    public static final int CONFIG_PARTY = 3;
    public static final int CONFIG_ELEC_DIS = 4;
    public static final int CONFIG_MANDATE_BW = 5;
    public static final int CONFIG_PERCENT = 6;
    public static final int CONFIG_SUBDISTRICT_BY = 7;
    public static final int CONFIG_MANDATE_BY = 8;
    public static final int CONFIG_MANDATE = 9;
    public static final int CONFIG_BOARDS = 10;
    public static final int CONFIG_COMMENTS = 11;
    public static final int CONFIG_LIST_RANK = 12;
    public static final int CONFIG_DISTRICT_RANK = 13;
    public static final int CONFIG_DISTRICT_NUM = 14;
    public static final int CONFIG_STATE = 15;


    public static final int MAX_MEMBER_ATTRIBUTES = 13;
    public static final String CSV_QUOTES ="\"";


    public static final String [] STATES_NAMES ={"Baden-Württemberg", "Bayern", "Berlin", "Brandenburg", "Bremen", "Hamburg", "Hessen", "Mecklenburg-Vorpommern", "Niedersachsen", "Nordrhein-Westfalen", "Rheinland-Pfalz", "Saarland", "Sachsen", "Sachsen-Anhalt", "Schleswig-Holstein", "Thüringen", ""};

    public static final int BUNDESTAG = 0;
    public static final int LANDTAG = 1;

    public static final String HEADER_YEAR_OF_BIRTH = "year.of.birth";
    public static final String HEADER_PARTY = "party";
    public static final String HEADER_LAST_NAME = "last.name";
    public static final String HEADER_FIRST_NAME = "first.name";
    public static final String HEADER_PARLIAMENT = "parliament";
    public static final String HEADER_STATE = "federal.state";
    public static final String HEADER_COMMENTS = "comments";
    public static final String HEADER_BOARDS = "boards";
    public static final String HEADER_ELECTORAL_DISTRICT = "electoral.district";
    public static final String HEADER_VOTES_PERCENTAGE = "votes.percentage";
    public static final String HEADER_KIND_OF_MANDATE = "kind.of.mandate";
    public static final String HEADER_LIST_RANK = "list.rank";
    public static final String HEADER_DISTRICT_RANK = "district.rank";
    public static final String HEADER_PHOTO_URL = "photo.url";

    public static final String HEADER_CANDIDATE_WHICH_PARLIAMENT = "candidate.for.which.parliament";




}
