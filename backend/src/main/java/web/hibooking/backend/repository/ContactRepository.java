package web.hibooking.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.OpPlus;
import org.springframework.stereotype.Repository;
import web.hibooking.backend.entities.Contact;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {

    Optional<Contact> findContactByUserId(String userId);
}
