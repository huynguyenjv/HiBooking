package web.hibooking.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.hibooking.backend.entities.Test;

@Repository
public interface TestRepository extends JpaRepository<Test,Integer> {
}
