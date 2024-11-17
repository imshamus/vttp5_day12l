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
@RequestMapping("/T")
public class TrialController
{
    // http://localhost:8080/T/trial
    @GetMapping(path = "/trial")
    public String trialPage(Model model)
    {
        model.addAttribute("name", "John");
        return "trial";
    }

    
}
