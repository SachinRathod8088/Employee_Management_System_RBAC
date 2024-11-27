//package com.excelr.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.excelr.DTO.UserDto;
//import com.excelr.model.User;
//import com.excelr.repository.UserRepository;
//
//
//@Service
//public class UserServiceImpl implements UserService {
////	
////	@Autowired
////	private PasswordEncoder passwordEncoder;
//	
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	public User save(UserDto userDto) {
//		User user = new User();
//		return userRepository.save(user);
//	}
//
//}
package com.excelr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.excelr.DTO.UserDto;
import com.excelr.model.User;
import com.excelr.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // Password encoder for secure storage

    @Override
    public User save(UserDto userDto) {
        User user = new User();
        
        // Map fields from UserDto to User entity
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword())); // Encode the password
        user.setRole(userDto.getRole());  // Assuming role is passed from UserDto
        user.setFullname(userDto.getFullname());

        // Save user to the database
        return userRepository.save(user);
    }
}

