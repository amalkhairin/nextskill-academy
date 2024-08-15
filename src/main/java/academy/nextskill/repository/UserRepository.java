package academy.nextskill.repository;

import academy.nextskill.model.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "INSERT INTO users(full_name, username, email, password, role) VALUES (:fullName, :username, :email, :password, :role) " +
            "ON CONFLICT (username) DO UPDATE SET " +
            "full_name = COALESCE(:fullName, users.full_name), " +
            "username = COALESCE(:username, users.username), " +
            "email = COALESCE(:email, users.email), " +
            "password = COALESCE(:password, users.password), " +
            "role = COALESCE(:role, users.role) " +
            "RETURNING *", nativeQuery = true)
    UserEntity save(@Param("fullName") String fullName,
                    @Param("username") String username,
                    @Param("email") String email,
                    @Param("password") String password,
                    @Param("role") String role);

    @Override
    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<UserEntity> findAll();

    @Override
    @Query(value = "SELECT * FROM users WHERE id = :id", nativeQuery = true)
    Optional<UserEntity> findById(@Param("id") Long id);

    @Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
    Optional<UserEntity> findByUsername(@Param("username") String username);

    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    Optional<UserEntity> findByEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users WHERE id = :id", nativeQuery = true)
    void delete(@Param("id") Long id);
}
