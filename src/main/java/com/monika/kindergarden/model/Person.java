package com.monika.kindergarden.model;

import com.monika.kindergarden.annotations.FieldsValueMatch;
import com.monika.kindergarden.annotations.PasswordValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "pwd",
                fieldMatch = "confirmPwd",
                message = "Passwords do not match"
        ),
        @FieldsValueMatch(
                field = "email",
                fieldMatch = "confirmEmail",
                message = "Email addresses do not match"
        )
})
public class Person extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private int personId;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, message = "Name must not be less than 3 characters")
    private String name;

    @NotBlank(message = "Mobile Number must not be blank")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be exactly 10 digits long")
    private String mobileNumber;

    @NotBlank(message = "Password must not be blank")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Confirmed Email must not be blank")
    @Email(message = "Please provide a valid confirm email address")
    @Transient
    private String confirmEmail;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 5, message = "Password must not be less than 5 characters")
    @PasswordValidator
    private String pwd;

    @NotBlank(message = "Confirm Password must not be blank")
    @Size(min = 5, message = "Confirm Password must not be less than 5 characters")
    @Transient
    private String confirmPwd;


//    private Roles roles;
//    private Address address;
}
