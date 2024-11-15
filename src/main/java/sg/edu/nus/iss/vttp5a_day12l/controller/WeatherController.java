package sg.edu.nus.iss.vttp5a_day12l.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.vttp5a_day12l.model.Country;
import sg.edu.nus.iss.vttp5a_day12l.service.CountryService;

@Controller
@RequestMapping("/weather")
public class WeatherController 
{
    @Autowired
    CountryService countryService;

    @GetMapping("")
    // http://localhost:8080/weather?country=Jarkata&units=cm
    public String weather(@RequestParam(required = true, name = "country", defaultValue = "Singapore") String city, 
    @RequestParam(name = "units", defaultValue = "centimeters") String metric,
    Model model) // if no default name, it would default to para which is city
    {
        model.addAttribute("city", city); 

        // "city" makes the variable city (method parameter) available in the HTML template as ${city}. <p>City: <span data-th-text="${city}"></span></p>
        // You could write model.addAttribute("country", city); K: "country", V: city (the method parameter)
        // In the template, you'd reference it as ${country} instead of ${city}.

        model.addAttribute("metrics", metric); 

        return "weather";
    }    



    @GetMapping(path = {"/city/{country}/metrics/{metrics}", "/{country}/{metrics}" })
    // http://localhost:8080/weather/city/United%20States/metrics/degree%20celcius
    public String weather2(@PathVariable(required = true, name = "country") String city, @PathVariable(name = "metrics") String metric, Model model) {

        model.addAttribute("city", city);
        model.addAttribute("metrics", metric);
    
        return "weather";
    }



    @GetMapping("/pagea")
    public String pageA(Model model) {
        String [] units = {"millimiter", "centimeter", "meter", "kilometer"};
        List<Country> countries = countryService.getCountries();

        model.addAttribute("countries", countries);
        model.addAttribute("metrics", units);
        return "pagea";
    }
    
    // Form & POST usually comes out at different magnitude, 10 marks, either multivaluemap or model will come out
    @GetMapping("/forma")
    public String showForm() {
        return "forma";
    }

    @PostMapping("/forma")
    public String handlePageA(@RequestBody MultiValueMap<String, String> form)
    {
        // Map<String, String> formData = new HashMap<>();
        
        for(String str: form.keySet()) // what's a keyset()? key set is the key
        {
            // formData.put(str, form.getFirst(str)); // getFirst to get the value
            System.out.println(str + ">>> " + form.getFirst(str));
        }

        return "forma";
    }

    




    
}
