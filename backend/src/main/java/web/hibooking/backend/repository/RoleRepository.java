package web.hibooking.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.hibooking.backend.entities.Role;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    boolean existsByName(String name);
    Set<Role> findRoleByName(String name);
}
