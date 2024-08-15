package web.hibooking.backend.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @ManyToMany(mappedBy = "roles")
    Set<User> users = new HashSet<>();

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Timestamp createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    Timestamp deletedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreRemove
    protected void onDelete() {
        deletedAt = new Timestamp(System.currentTimeMillis());
    }
}
