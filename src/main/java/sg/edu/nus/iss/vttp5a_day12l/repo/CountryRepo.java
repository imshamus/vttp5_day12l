package sg.edu.nus.iss.vttp5a_day12l.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_day12l.model.Country;

@Repository
public class CountryRepo {
    
    List<Country> countryList;

    public List<Country> getCountries(){
        
        countryList = new ArrayList<>();

        Country cty = new Country("SG", "Singapore", 10000);
        countryList.add(cty);
        
        cty = new Country("MY", "Malaysia", 9999);
        countryList.add(cty);
        
        cty = new Country("TH", "Thailand", 8888);
        countryList.add(cty);
        
        cty = new Country("KR", "Korea", 9023);
        countryList.add(cty);
        
        cty = new Country("JP", "Japan", 23094);
        countryList.add(cty);
        
        return countryList;
    }

    public Boolean createCountry(Country cty) {
        if (countryList == null) 
            countryList = new ArrayList<>();

        countryList.add(cty);
        return true;
    }

    
}
