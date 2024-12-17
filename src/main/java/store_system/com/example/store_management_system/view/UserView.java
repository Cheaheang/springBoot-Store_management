package store_system.com.example.store_management_system.view;

import lombok.Builder;
import lombok.Data;
import store_system.com.example.store_management_system.service.UserService;

@Data
@Builder
public class UserView {
    private String name;
    private String role;
    private String status;
    private String password;

    public static UserView of(UserView userView) {
        return UserView.builder()
                .name(userView.getName())
                .password(userView.getPassword())
                .role(userView.getRole())
                .status(userView.getStatus()).build();
    }
}
