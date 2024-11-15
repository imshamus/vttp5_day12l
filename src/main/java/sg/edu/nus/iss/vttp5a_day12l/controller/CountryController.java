package sg.edu.nus.iss.vttp5a_day12l.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.vttp5a_day12l.model.Country;
import sg.edu.nus.iss.vttp5a_day12l.service.CountryService;

@Controller
@RequestMapping("/countries")
public class CountryController 
{
    @Autowired
    CountryService countryService;

    @ResponseBody // Used to send data (like JSON) directly in the response body, commonly in API controllers.
    @GetMapping("")
    public List<Country> countries(Model nodel)
    {
        return countryService.getCountries();
    }
    
     @GetMapping("/list")
    public String displayCountryList(Model model) {
        List<Country> countries = countryService.getCountries();
        model.addAttribute("countries", countries);

        return "countrylist";
    }


    @GetMapping("/list/filter")
    public String displayCountryList(@RequestParam("population") String quantity, Model model) {
        List<Country> countries = countryService.getCountries();

        countries = countries.stream().filter(c -> c.getPopulation() >= Integer.parseInt(quantity)).collect(Collectors.toList());
        
        model.addAttribute("countries", countries);

        return "countrylist";
    }
    
}
