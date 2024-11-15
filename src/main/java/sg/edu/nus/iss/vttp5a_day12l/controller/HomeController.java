package sg.edu.nus.iss.vttp5a_day12l.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController 
{
    @GetMapping(path = {"", "/landing"}, produces = {"text/html"}) // produces can be omitted, why(?)
    
    public String home(Model model)
    {
        model.addAttribute("CurrTime", (new Date()).toString());

        Calendar cal = Calendar.getInstance();
        model.addAttribute("currHour", cal.get(Calendar.HOUR_OF_DAY));
        return "home";
    }

    
}
