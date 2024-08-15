package com.solvd.laba.rbekrenov.travelagency.model.location;

public final class Country {
    public static final Country[] COUNTRIES = new Country[]{
            new Country("France", "FR"),
            new Country("Italy", "IT"),
            new Country("USA", "US"),
            new Country("Spain", "ES")
    };
    private final String name;
    private final String countryCode;

    private Country(String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    public static Country getCountryByCode(String code) {
        for(Country c : COUNTRIES){
            if(c.getCountryCode().equals(code)){
                return c;
            }
        }
        throw new RuntimeException("No country with this code");
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
