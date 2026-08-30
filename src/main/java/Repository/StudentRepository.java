package Repository;


import Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Optional<Student> findByEmail(String Email);


}












