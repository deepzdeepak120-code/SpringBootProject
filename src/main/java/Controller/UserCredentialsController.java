package Controller;


import Pojo.UserCredentialsRequest;
import Service.UserCredentialsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserCredentialsController {


    private final UserCredentialsService userCredentialsService;


    public UserCredentialsController(UserCredentialsService userCredentialsService){
        this.userCredentialsService=userCredentialsService;
    }


   @PostMapping("/register")
   public void register(@Valid @RequestBody UserCredentialsRequest request){

       userCredentialsService.register(request);
}

}
