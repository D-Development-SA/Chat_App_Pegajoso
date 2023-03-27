package com.deika.pegajoso.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @NotNull(message = "The name cannot be null")
    @Size(message = "The number of characters is incorrect", min = 2, max = 15)
    @Column(unique = true, nullable = false, length = 15)
    private String name;

    @NotNull(message = "It have that exist a password")
    @Size(message = "The number of characters is incorrect", min = 10, max = 15)
    @Pattern(regexp = "[A-Za-z0-9]+", message = "The password does not meet the requirements")
    @Column(unique = true, nullable = false, length = 15)
    private String password;

    @NotNull(message = "Introduce a telephone number, cannot be empty")
    @Pattern(regexp = "\\d+", message = "The telephone number does not meet the requirements")
    @Column(unique = true, nullable = false, length = 8)
    private int number;

    private String perfilImageName;

    private boolean enabled = true;

    @OneToMany(
            mappedBy = "user_id",
            cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY
    )
    private List<Chat> chats;
}
