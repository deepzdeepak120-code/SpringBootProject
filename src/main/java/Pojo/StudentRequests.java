package Pojo;

import jakarta.validation.constraints.*;

public class StudentRequests {

//    private int id;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;
    @Min(value = 16, message = "Age must be at least 16")
    @Max(value = 60, message = "Age must not exceed 60")
    private int age;

    @NotBlank
    @Email
    private String email;

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    @Size(max = 10, message="Phone number must be within ten characters")
    private String PhoneNumber;


    @Override
    public String toString() {
        return "StudentRequests{" +
//                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    private String passWord;

    // Default constructor
    public StudentRequests() {

    }

//    // Parameterized constructor
//    public StudentRequests(int id, String name, int age, String email,String passWord) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.email = email;
//        this.passWord =passWord;
//    }

    // Getters and Setters
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
