package dev.smita.sms.repository;

import dev.smita.sms.domain.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDetailRepository extends
        JpaRepository<StudentDetail,Integer> {
}
