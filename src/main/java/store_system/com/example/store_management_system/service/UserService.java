package store_system.com.example.store_management_system.service;

import store_system.com.example.store_management_system.form.CreateUserForm;
import store_system.com.example.store_management_system.view.UserView;
import java.util.List;
public interface UserService  {
    List<UserView> getUser();
    UserView createUser(CreateUserForm form);
    String updateUser(CreateUserForm form, Long id);
    String deleteUser(Long id);

}
