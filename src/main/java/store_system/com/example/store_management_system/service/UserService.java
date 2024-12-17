package store_system.com.example.store_management_system.service;

import store_system.com.example.store_management_system.entity.User;
import store_system.com.example.store_management_system.view.UserView;
import java.util.List;
public interface UserService  {
    List<UserView> getUser();
    List<UserView> setUser(String name, String pass, String status, String role);

}
