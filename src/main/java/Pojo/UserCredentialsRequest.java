package Pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserCredentialsRequest {



     @NotBlank
     @Size(min =2)
    private String username ;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @NotBlank
    @Size(min=3)
    private String password ;


    @NotBlank
    private String role;


    //No args Constructor
    public UserCredentialsRequest(){

    }

}
