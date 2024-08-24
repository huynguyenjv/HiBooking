package web.hibooking.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.hibooking.backend.entities.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Integer> {
}
