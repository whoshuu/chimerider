package com.example.chimerider;

import java.util.ArrayList;

public class Country {

    private String name;
    private String population;
    private String miles;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPopulation(String population) {
        this.name = population;
    }
    public String getPopulation() {
        return population;
    }
    public void setMiles(String miles) {
        this.miles = miles;
    }
    public String getMiles() {
        return miles;
    }
    
    public Country(String name, String population, String miles) {
        this.name = name;
        this.population = population;
        this.miles = miles;
    }

    public static ArrayList<Country> countryInfoGen(){
        ArrayList<Country> countryInfo = new ArrayList<Country>();
        countryInfo.add(new Country("Kenya","5.1M","56.7K"));
        countryInfo.add(new Country("Lesotho","2M","87.7K"));
        countryInfo.add(new Country("Nigeria","0.5M","125K"));
        countryInfo.add(new Country("Malawi","0.1M","211K"));
        return countryInfo;
    }
}
