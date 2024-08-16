package academy.nextskill.service.impl;

import academy.nextskill.model.UserEntity;
import academy.nextskill.repository.UserRepository;
import academy.nextskill.service.UserService;
import academy.nextskill.utils.dto.UserDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserEntity create(UserDTO req) {
        UserEntity userEntity = UserEntity.builder()
                .fullName(req.getFullName())
                .username(req.getUsername())
                .email(req.getEmail())
                .password(req.getPassword())
                .role(req.getRole())
                .build();
        return userRepository.create(
                req.getFullName(),
                req.getUsername(),
                req.getEmail(),
                req.getPassword(),
                req.getRole().name()
        );
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public UserEntity update(Long id, UserDTO req) {
        UserEntity user = this.getById(id);
        user.setFullName(req.getFullName() == null || req.getFullName().isEmpty() ? user.getFullName() : req.getFullName());
        return userRepository.update(
                user.getId(),
                user.getFullName(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getRole().name()
        );
    }

    @Override
    public void deleteById(Long id) {
        UserEntity user = this.getById(id);
        userRepository.delete(user.getId());
    }
}
