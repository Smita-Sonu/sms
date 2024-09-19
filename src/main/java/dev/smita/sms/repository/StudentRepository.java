package dev.smita.sms.repository;

import dev.smita.sms.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query("UPDATE Student s SET s.fee = s.fee + :fee WHERE s.roll = :roll")
    @Modifying
    @Transactional
    void incrementByFee(@Param("fee") double fee, @Param("roll") int roll);

}
