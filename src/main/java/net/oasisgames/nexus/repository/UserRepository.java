package net.oasisgames.nexus.repository;

import net.oasisgames.nexus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT count(*) from User")
    Integer getUserCount();

}
