package com.TaskManagement.Entity;

import com.TaskManagement.Enum.Role;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="user_Auth")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserAuthentication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;
    @Column(unique = true, nullable = false)
    private String userOfficialEmail;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


}
