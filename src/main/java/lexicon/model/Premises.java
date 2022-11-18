package lexicon.model;

public enum Premises {
    PLACE_1("Spanga Vardcentral"), PLACE_2("Vallingby Vardcentral");

    private String address;

    Premises(String address){
        this.address = address;
    }

    private String getAddress(){
        return address;
    }
}
