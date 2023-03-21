package com.example.demo.model.dto;

import io.swagger.annotations.ApiModelProperty;
//import jakarta.validation.Valid;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserAvatarDto {
    @ApiModelProperty(hidden = true)
    private Long id;

    @NotNull(
            message = "Full name is required"
    )
    @ApiModelProperty(
            notes="Full name cannot be empty",
            required=true
    )
    private String name;

    @ApiModelProperty(notes = "User email address", required = true)
    @Email(message = "Email address is not valid")
    @NotBlank(message = "Email address is not valid")
    private String email;

    @ApiModelProperty(notes = "User's password (must be at least 8 characters)",required = true)
    @Size(min = 8, message =  "Must be at least 8 characters")
    private String password;

    @ApiModelProperty(notes = "User gender")
    private String gender;

    @Pattern(
            regexp=" /^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$/",
            message = "Please provide a valid phone number"
    )
    @ApiModelProperty(
            notes = "Number of Phone cannot be empty",
            required=true
    )
    private String phone;
    @Valid
    @URL(
            regexp="(https?:\\/\\/.*\\.(?:png|jpg))",
            message="Avatar must be an url image"
    )
    @ApiModelProperty(
            example="https://i.pinimg.com/564x/3f/28/99/3f2899261b21fe3a97dd684e7813b493.jpg",
            notes="Avatar must be an url image",
            required = false
    )
    private String avatar;
}
