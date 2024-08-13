package com.solvd.laba.rbekrenov.travelagency.pojo.location;

public class Country {
    public static final Country[] COUNTRIES = new Country[]{
            new Country("France", "FR"),
            new Country("Italy", "IT"),
            new Country("USA", "US"),
            new Country("Spain", "ES")
    };
    private String name;
    private String countryCode;

    public static Country getCountryByCode(String code) {
        for(Country c : COUNTRIES){
            if(c.getCountryCode().equals(code)){
                return c;
            }
        }
        throw new RuntimeException("No country with this code");
    }

    public Country(String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
