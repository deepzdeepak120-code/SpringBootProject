package Controller;


import Pojo.Calculatorrequestor;
import Service.CalculatorService;

import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/calc")
public class CalculatorController {


    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b){

        logger.info("adding this {}and {}", a,b);
    int answerForAddtion = calculatorService.add(a,b);
        logger.info("The result of addtion is {}",answerForAddtion);
        return answerForAddtion;
    }

    @GetMapping("/subtract/{a}/{b}")
    public int subract(@PathVariable int a, @PathVariable int b){

        logger.info("subract this {}and {}", a,b);
        int answerForSubraction = calculatorService.subtract(a,b);
        logger.info("The result of subtract is {}",answerForSubraction);
        return answerForSubraction;
    }


    @PostMapping("/derive")
    public double derive(@RequestBody Calculatorrequestor request){


        request.getData1();

        logger.info("derive request received: operation={}, data1={}, data2={}",
                request.getOperation(), request.getData1(), request.getData2());

        double answerForDerive = calculatorService.derive(
                request.getOperation(), request.getData1(), request.getData2());

        logger.info("The result of derive is {}", answerForDerive);
        return answerForDerive;
    }
}
