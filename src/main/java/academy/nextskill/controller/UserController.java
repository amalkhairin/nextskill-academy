package academy.nextskill.controller;

import academy.nextskill.model.UserEntity;
import academy.nextskill.service.UserService;
import academy.nextskill.utils.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    private ResponseEntity<?> createUser(@RequestBody UserDTO req) {
        UserEntity result = userService.create(req);
        return ResponseEntity.status(201).body(result);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping
    private ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDTO req) {
        return ResponseEntity.ok(userService.update(id, req));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteUser(@PathVariable Long id) {
        String msg = "";
        userService.deleteById(id);
        msg = "User with id " + id + " deleted";
        return ResponseEntity.ok().body(msg);
    }

}
