package store_system.com.example.store_management_system.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import store_system.com.example.store_management_system.entity.User;
@Data
@RequiredArgsConstructor
public class CreateUserForm {
    @NotBlank
    private String name;
    @NotBlank
    private String role;
    @NotBlank
    private String status;
    @NotBlank
    private String password;

    public User toUser() {
        return User.builder()
                .name(name)
                .password(password)
                .role(role)
                .status(status)
                .build();
    }
}
