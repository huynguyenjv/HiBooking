package web.hibooking.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.hibooking.backend.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
