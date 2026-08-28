package Entity;


import jakarta.persistence.*;
import org.apache.logging.log4j.message.Message;


@Entity
@Table(name = "Student")
public class Student {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @Column(unique = true)
    private String email;
    private String passWord;
    private String PhoneNumber;

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }



    // Default constructor
    public Student() {
    }

//    // Parameterized constructor
//    public Student(int id, String name, int age, String email,String passWord) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.email = email;
//        this.passWord= passWord;
//    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getPassword(){
        return passWord;
    }

    public void setPassword(String passWord){
        this.passWord=passWord;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", passWord=" + passWord +
                '}';
    }
}