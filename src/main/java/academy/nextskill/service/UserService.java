package academy.nextskill.service;

import academy.nextskill.model.UserEntity;
import academy.nextskill.utils.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserEntity create(UserDTO req);
    List<UserEntity> getAll();
    UserEntity getById(Long id);
    UserEntity update(Long id, UserDTO req);
    void deleteById(Long id);
}
