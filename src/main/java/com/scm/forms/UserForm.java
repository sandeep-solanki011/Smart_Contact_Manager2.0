package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {

    @NotBlank(message = "Username is required")
    @Size(min = 3,message = "Minumum 3 Characters is required")
    private String name;

    @Email(message = "Invalid Email Address")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Pssword is Required")
    @Size(min=6,message = "Min 6 Characters is required")
    private String password;

    @NotBlank(message = "PhoneNumber is Required")
    @Size(min = 8,max = 12,message = "Invalid Phone Number")
    private String phoneNumber;

    @NotBlank(message = "About is Required")
    private String about;



}
