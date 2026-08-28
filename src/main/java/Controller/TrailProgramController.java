package Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Service.TrailService;

@RestController
public class TrailProgramController {

    private final TrailService trailService;

    public TrailProgramController(TrailService trailService){ 

        this.trailService =trailService;


    }

@RequestMapping("/welcome")
    public String GetWelcomeMessage(@RequestParam String name){

        return trailService.WelcomeMessagePrinting(name);

    }


@GetMapping("/trail")
    public String trail(){
        return "Hi this is my first Spring boot project";
    }

@GetMapping("/add")
    public int add(@RequestParam int a,@RequestParam int b){

        return trailService.add(a, b);
    }


    @GetMapping("/namePrinting")
    public String namePrinting(@RequestParam String name){

      return "My name is " +name;
    }



}
