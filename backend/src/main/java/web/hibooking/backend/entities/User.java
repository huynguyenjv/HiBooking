package web.hibooking.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name="email",length = 50,unique = true)
    @NotBlank(message = "Email is required")
    @Size(min = 1, max = 50, message = "Email must be between 1 and 50 characters")
    @Email
    String email;

    @Column(name="password",length = 250)
    @NotBlank(message = "Password is required")
    String password;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Timestamp createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    Timestamp deletedAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Address address;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Contact contact;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    UserProfile userProfile;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "UserRole",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId")
    )
    Set<Role> roles = new HashSet<>();


    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreRemove
    protected void onDelete() {
        deletedAt = new Timestamp(System.currentTimeMillis());
    }
}
