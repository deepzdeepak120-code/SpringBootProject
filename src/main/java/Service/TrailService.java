package Service;

import org.springframework.stereotype.Service;

@Service
public class TrailService {

    public int add(int a, int b){

            int result=a+b;
            return result;
    }


    public String WelcomeMessagePrinting(String WelcomeMessage){

        return WelcomeMessage+" Welcome to Satyam cinemas";

    }





}


