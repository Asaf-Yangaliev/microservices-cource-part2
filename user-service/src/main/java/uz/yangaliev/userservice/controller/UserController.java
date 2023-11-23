package uz.yangaliev.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.yangaliev.userservice.dto.UserDto;
import uz.yangaliev.userservice.entity.User;
import uz.yangaliev.userservice.repository.interfaces.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .build()).toList();
    }

    @GetMapping("/users/{id}")
    public UserDto findById(@PathVariable("id") Long id) {
        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .build();
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> save(@RequestBody User user) {
        User saved = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserDto.builder()
                        .id(saved.getId())
                        .name(saved.getName())
                        .surname(saved.getSurname())
                        .build());
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }
}
