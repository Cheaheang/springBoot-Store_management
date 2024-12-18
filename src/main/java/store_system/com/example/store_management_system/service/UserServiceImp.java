package store_system.com.example.store_management_system.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store_system.com.example.store_management_system.entity.User;
import store_system.com.example.store_management_system.form.CreateUserForm;
import store_system.com.example.store_management_system.repository.UserRepository;
import store_system.com.example.store_management_system.view.UserView;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImp implements UserService {
    private UserRepository userRepository;

    @Override
    public List<UserView> getUser() {
        return userRepository.findAll().stream().map(UserView::of).toList();
    }

    @Override
    public UserView createUser(CreateUserForm form) {
        return UserView.of(userRepository.saveAndFlush(form.toUser()));
    }

    public String updateUser(CreateUserForm form, Long id) {
       return userRepository.findById(id).map(user -> {
            user.setName(form.getName());
            user.setRole(form.getRole());
            user.setStatus(form.getStatus());
            user.setPassword(form.getPassword());
            userRepository.save(user);
            return "User update successfully";
        }).orElse("User update failed");
    }

    @Override
    public String deleteUser(Long id) {

        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return "User delete successfully";
        }
        return "User delete failed";
    }

}
