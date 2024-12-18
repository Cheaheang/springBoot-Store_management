package store_system.com.example.store_management_system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store_system.com.example.store_management_system.form.CreateUserForm;
import store_system.com.example.store_management_system.service.UserService;
import store_system.com.example.store_management_system.view.UserView;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

public UserController(UserService userService){
this.userService = userService;
}

    @PostMapping
    public UserView create(@RequestBody CreateUserForm form) {
        return userService.createUser(form);
    }
    @GetMapping
    public List<UserView> get(){
        return userService.getUser();
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody CreateUserForm form){
        String result = userService.updateUser(form, id);
        if(result.equals("User update failed")){
            return ResponseEntity.status(404).body(result);
        }
        return ResponseEntity.status(200).body(result) ;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        String result  = userService.deleteUser(id);
        if(result.equals("User delete failed")){
         return ResponseEntity.status(404).body(result);
        }
        return ResponseEntity.status(200).body(result);
    }
}
