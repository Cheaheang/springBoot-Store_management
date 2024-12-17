package store_system.com.example.store_management_system.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store_system.com.example.store_management_system.repository.UserRepository;
import store_system.com.example.store_management_system.view.UserView;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImp implements UserService {
    private UserRepository userRepository;
    @Override
    public List<UserView> getUser() {
        return userRepository.findAll().stream().map(UserView::of).toList();
    }

    @Override
    public List<UserView> setUser(String name, String pass, String status, String role) {
        return userRepository.save(name, pass, status, role,);
    }
}
