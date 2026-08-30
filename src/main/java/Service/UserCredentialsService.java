package Service;


import Entity.UserCredentials;
import Pojo.UserCredentialsRequest;
import Repository.UserCredentialsRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsService {

    private final UserCredentialsRepository userCredentialsRepository;


    public UserCredentialsService(UserCredentialsRepository userCredentialsRepository){

        this.userCredentialsRepository=userCredentialsRepository;

    }

    public UserCredentials register(UserCredentialsRequest request){

        UserCredentials usercred = new UserCredentials();


        usercred.setPassword(request.getPassword());
        usercred.setRole(request.getRole());
        usercred.setUsername(request.getUsername());

        return userCredentialsRepository.save(usercred);

    }



}
