package web.hibooking.backend.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Time;
import java.sql.Timestamp;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = true)
    String firstName;

    @Column(nullable = true)
    String lastName;

    @Column(nullable = true)
    Boolean gender;

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    String birthDay;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Timestamp createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    Timestamp deletedAt;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreRemove
    protected void onDelete() {
        deletedAt = new Timestamp(System.currentTimeMillis());
    }

}
