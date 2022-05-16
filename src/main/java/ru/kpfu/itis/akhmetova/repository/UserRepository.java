package ru.kpfu.itis.akhmetova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.akhmetova.model.User;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail (String email);

    @Query(value = "select * from users u WHERE u.email = :email", nativeQuery = true)
    Optional<User> getUserByEmail(@Param("email") String email);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update users set name = :name, password = :password where email = :email",  nativeQuery = true)
    void updateUser(@Param("name") String name, @Param("password") String password, @Param("email") String email);
}
