package com.expence_tracking.app.services.implementations.favorites;

import com.expence_tracking.app.domain.User;
import com.expence_tracking.app.domain.enums.FavoriteType;
import com.expence_tracking.app.dto.view.FavoriteCount;
import com.expence_tracking.app.dto.view.FavoriteView;
import com.expence_tracking.app.repostiories.FavoritesRepository;
import com.expence_tracking.app.repostiories.UserRepository;
import com.expence_tracking.app.services.iterfaces.favorites.FavoriteQueryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
public class FavoriteQueryServiceImpl implements FavoriteQueryService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final FavoritesRepository favoritesRepository;

    @Override
    @PreAuthorize("isAuthenticated()")
    public List<FavoriteView> allFavoritesByUser(Long id) {
        User one = this.userRepository.getOne(id);
        return this.favoritesRepository.findAllByUser(one).stream()
                .map(favorite -> this.modelMapper.map(favorite, FavoriteView.class))
                .collect(Collectors.toList());
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public List<FavoriteCount> countFavoriteByUser(Long id) {
        return this.favoritesRepository.countFavoritesByUser(id).stream().map(obj ->
        {
            var fav = new FavoriteCount();
            fav.setFavoriteType((FavoriteType) obj[0]);
            fav.setCount((Long) obj[1]);
            return fav;
        }).collect(Collectors.toList());
    }
}
