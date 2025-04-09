package th.ac.mahidol.ict.gemini5.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

import th.ac.mahidol.ict.gemini5.model.User;
import th.ac.mahidol.ict.gemini5.repository.UserRepository;


@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private BCryptPasswordEncoder passwordEncoder;

    // Sign up
    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody User newUser) {
        System.out.println("🔹 Signup request for email: " + newUser.getEmail());

        if (userRepository.existsByEmail(newUser.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("❌ Email already exists");
        }
        if (userRepository.existsByUsername(newUser.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("❌ Username already taken");
        }

        User savedUser = userRepository.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<?> addUser(@RequestBody User loginUser) {
        System.out.println("Login request for email: " + loginUser.getEmail());

        Optional<User> user = userRepository.findByEmail(loginUser.getEmail());
        if (user.isPresent()) {
            System.out.println("✅ User found: " + user.get().getEmail());
    
            if (user.get().getPassword().equals(loginUser.getPassword())) {
                System.out.println("Password matched!");
                return ResponseEntity.ok(user.get());
            } else {
                System.out.println("Incorrect password!");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
            }
        } else {
            System.out.println("User not found!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    // Get all users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
    }

    // Get a user by ID
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Update user by ID
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable("id") Integer userId, @RequestBody User updatedUser) {
        Optional<User> existingUser = userRepository.findById(userId);
    
        if (existingUser.isPresent()) {
            User user = existingUser.get();

            // อัปเดตเฉพาะฟิลด์ที่ไม่ใช่ค่า null
            if (updatedUser.getFirstName() != null) user.setFirstName(updatedUser.getFirstName());
            if (updatedUser.getLastName() != null) user.setLastName(updatedUser.getLastName());
            if (updatedUser.getEmail() != null) user.setEmail(updatedUser.getEmail());
            if (updatedUser.getUsername() != null) user.setUsername(updatedUser.getUsername());
            if (updatedUser.getPhone() != null) user.setPhone(updatedUser.getPhone());
            if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
                user.setPassword(updatedUser.getPassword());
            }

            userRepository.save(user);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + userId + " not found.");
        }
    }

    // Delete user by ID
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Integer userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return ResponseEntity.ok("Deleted user with ID: " + userId);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete all users
    @DeleteMapping("/users")
    public ResponseEntity<?> deleteAllUsers() {
        userRepository.deleteAll();
        return ResponseEntity.ok("Deleted all users");
    }

}
