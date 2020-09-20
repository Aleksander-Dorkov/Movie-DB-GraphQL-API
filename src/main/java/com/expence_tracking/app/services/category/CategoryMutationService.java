package com.expence_tracking.app.services.category;

import com.expence_tracking.app.domain.Category;
import com.expence_tracking.app.dto.binding.category.CategoryCreateForm;
import com.expence_tracking.app.dto.binding.category.CategoryEditForm;
import com.expence_tracking.app.dto.binding.category.SubCategoryCreateForm;
import com.expence_tracking.app.dto.binding.category.SubCategoryEditForm;
import com.expence_tracking.app.dto.view.Message;
import com.expence_tracking.app.repostiories.CategoryRepository;
import com.expence_tracking.app.repostiories.UserRepository;
import com.expence_tracking.app.configuration.exceptions.SubCategoryAllReadyExistException;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryMutationService implements GraphQLMutationResolver
{
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public Message createCategory(CategoryCreateForm form)
    {
        Category category = this.modelMapper.map(form, Category.class);
        category.setBalance(BigDecimal.valueOf(0));
        category.setOwner(this.userRepository.getOne(form.getUserId()));
        this.categoryRepository.save(category);
        return new Message("Successfully added a new Category");
    }

    public Message updateCategory(CategoryEditForm form)
    {
        this.categoryRepository.editCategory(form.getName(), form.getType(), form.getCategoryId());
        return new Message("Successfully added a new Category");
    }

    public Message createSubCategory(SubCategoryCreateForm form) throws SubCategoryAllReadyExistException
    {
        Category category = this.categoryRepository.findByCategoryId(form.getCategoryId());
        if (!category.getSubCategories().contains(form.getName()))
        {
            category.getSubCategories().add(form.getName());
        } else
        {
            throw new SubCategoryAllReadyExistException("Subcategory with this name all ready exists");
        }
        this.categoryRepository.save(category);
        return new Message("Successfully added a new SubCategory");
    }

    public Message updateSubCategory(SubCategoryEditForm form)
    {
        Category category = this.categoryRepository.findByCategoryId(form.getCategoryId());
        List<String> subCategories = category.getSubCategories();
        if (subCategories.contains(form.getNewName()))
        {
            throw new SubCategoryAllReadyExistException("Subcategory with this name all ready exists");

        }
        for (int i = 0; i < subCategories.size(); i++)
        {
            if (subCategories.get(i).equals(form.getOldName()))
            {
                subCategories.set(i, form.getNewName());
                break;
            }
        }
        this.categoryRepository.save(category);
        return new Message("Successfully edited SubCategory");
    }
}
