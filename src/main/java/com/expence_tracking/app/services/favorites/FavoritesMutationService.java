package com.expence_tracking.app.services.favorites;

import com.expence_tracking.app.domain.Favorite;
import com.expence_tracking.app.domain.User;
import com.expence_tracking.app.dto.binding.favorites.FavoriteCreate;
import com.expence_tracking.app.dto.view.Message;
import com.expence_tracking.app.repostiories.FavoritesRepository;
import com.expence_tracking.app.repostiories.UserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
@RequiredArgsConstructor
public class FavoritesMutationService implements GraphQLMutationResolver
{
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final FavoritesRepository favoritesRepository;

    public Message favoriteCreate(@Valid FavoriteCreate form)
    {
        User user = this.userRepository.getOne(form.getUserId());
        Favorite favorite = this.modelMapper.map(form, Favorite.class);
        favorite.setUser(user);
        this.favoritesRepository.save(favorite);
        return new Message("");
    }
}
