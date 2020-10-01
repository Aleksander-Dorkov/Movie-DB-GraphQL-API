package com.expence_tracking.app.services.favorites;

import com.expence_tracking.app.domain.User;
import com.expence_tracking.app.dto.view.FavoriteView;
import com.expence_tracking.app.repostiories.FavoritesRepository;
import com.expence_tracking.app.repostiories.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
public class FavoriteQueryService implements GraphQLQueryResolver
{
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final FavoritesRepository favoritesRepository;

    public List<FavoriteView> allFavoritesByUser(Long id)
    {
        User one = this.userRepository.getOne(id);
        return this.favoritesRepository.findAllByUser(one).stream()
                .map(favorite -> this.modelMapper.map(favorite, FavoriteView.class))
                .collect(Collectors.toList());
    }
}
