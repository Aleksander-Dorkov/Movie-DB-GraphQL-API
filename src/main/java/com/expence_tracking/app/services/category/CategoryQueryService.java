package com.expence_tracking.app.services.category;

import com.expence_tracking.app.domain.Category;
import com.expence_tracking.app.repostiories.CategoryRepository;
import com.expence_tracking.app.repostiories.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryQueryService implements GraphQLQueryResolver
{
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public List<Category> getAllCategoriesByUserId(Long userId)
    {
        return this.categoryRepository.findAllByOwner(this.userRepository.getOne(userId));
    }
}
