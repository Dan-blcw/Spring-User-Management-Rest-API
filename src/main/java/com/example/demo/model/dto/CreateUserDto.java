package com.example.demo.model.dto;

import io.swagger.annotations.ApiModelProperty;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {
    /*
        phần này không có nhiều lưu ý, xem lại swagger các @api là oke

        Regex là các mẫu (pattern) thay vì các chuỗi cụ thể được sử dụng
        tìm/thay thế (Find/Replace). Là một công cụ cực mạnh cho xử lí chuỗi trong Php,
        javascript… Ví dụ: Khi kiểm tra tính hợp lệ của email hoặc số điện thoại
        thì điều bạn nghĩ tới đầu tiên chính là regex.
        Regex là viết tắt của Regular Expression, tên thuần Việt là biểu thức chính quy.

        nếu không hiểu thì tự tìm lại =))
    */
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
}
