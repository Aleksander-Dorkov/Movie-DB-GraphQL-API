package com.expence_tracking.app.services.category;

import com.expence_tracking.app.domain.Category;
import com.expence_tracking.app.dto.binding.category.CategoryCreate;
import com.expence_tracking.app.dto.binding.category.CategoryEdit;
import com.expence_tracking.app.dto.view.Message;
import com.expence_tracking.app.repostiories.CategoryRepository;
import com.expence_tracking.app.repostiories.UserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryMutationService implements GraphQLMutationResolver
{
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public Message createCategory(CategoryCreate form)
    {
        Category category = this.modelMapper.map(form, Category.class);
        category.setOwner(this.userRepository.getOne(form.getUserId()));
        this.categoryRepository.save(category);
        return new Message("Successfully added a new Category");
    }

    public Message updateCategory(CategoryEdit form)
    {
        this.categoryRepository.editCategory(form.getName(), form.getType(), form.getCategoryId());
        return new Message("Successfully added a new Category");
    }
}
