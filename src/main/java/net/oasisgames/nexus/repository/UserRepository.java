package net.oasisgames.nexus.repository;

import net.oasisgames.nexus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT count(*) from User")
    Integer getUserCount();

    User findByUsername(String username);

}
