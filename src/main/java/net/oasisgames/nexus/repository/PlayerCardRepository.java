package net.oasisgames.nexus.repository;

import net.oasisgames.nexus.entity.PlayerCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerCardRepository extends JpaRepository<PlayerCard, Long> {}
