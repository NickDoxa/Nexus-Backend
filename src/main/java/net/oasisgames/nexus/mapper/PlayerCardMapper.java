package net.oasisgames.nexus.mapper;

import net.oasisgames.nexus.dto.PlayerCardDto;
import net.oasisgames.nexus.entity.PlayerCard;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerCardMapper {

    PlayerCard getPlayerCardFromPlayerCardDto(PlayerCardDto playerCardDto);
    PlayerCardDto getPlayerCardDtoFromPlayerCard(PlayerCard playerCard);

}
