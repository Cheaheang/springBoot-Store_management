package store_system.com.example.store_management_system.view;

import lombok.Builder;
import lombok.Data;
import store_system.com.example.store_management_system.entity.User;
import store_system.com.example.store_management_system.service.UserService;

@Data
@Builder
public class UserView {
    private String name;
    private String role;
    private String status;
    private String password;

    public static UserView of(User user) {
        return UserView.builder()
                .name(user.getName())
                .password(user.getPassword())
                .role(user.getRole())
                .status(user.getStatus()).build();
    }
}
