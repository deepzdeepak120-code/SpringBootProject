package Service;


import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CalculatorService {

    private String name ="deepak";


    private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);

    public  int add (int a, int b) {
        int addtionResult = (a+b);
        logger.info(" addition of {} and {}",a ,b);
        logger.info("addtionResult={}",addtionResult);

        return addtionResult;
    }

    public  int subtract (int a, int b) {
        int subractingResult = (a-b);
        logger.info(" Subracting  {} and {}",a ,b);
        logger.info("subractingResult={}",subractingResult);
        return subractingResult;
    }

    public  int multiply (int a, int b) {
        int multiplicatingResult = (a*b);
        logger.info(" Multiply the {} and {}",a ,b);
        logger.info("multiplicatingResult={}",multiplicatingResult);
        return multiplicatingResult;
    }

    public  double divide (double a, double b) {
        double divisionResult = (a/b);
        logger.info(" divide the {} and {}",a ,b);
        logger.info("divisionResult={}",divisionResult);
        return divisionResult;
    }

    public double derive(String operation, int data1, int data2) {

        logger.info("derive called with operation={}, data1={}, data2={}", operation, data1, data2);

        if ("addition".equals(operation)) {
            return add(data1, data2);
        }
        else if ("subtraction".equals(operation)) {
            return subtract(data1, data2);
        }
        else if ("multiplication".equals(operation)) {
            return multiply(data1, data2);
        }
        else if ("division".equals(operation)) {
            return divide(data1, data2);
        }

        else {
            logger.error("unknown operation received: {}", operation);
            throw new IllegalArgumentException("Invalid operation: " + operation);
        }



    }

}
