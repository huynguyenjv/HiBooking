package web.hibooking.backend.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;


@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="street",length = 100)
    String street;

    @Column(name="city",length = 100)
    String city;

    @Column(name="state",length = 100)
    String state;

    @Column(name="country",length = 100)
    String country;

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
