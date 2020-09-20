package com.expence_tracking.app.dto.binding.category;

import com.expence_tracking.app.domain.enums.CategoryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryEditForm
{
    private Long categoryId;
    private String name;
    private CategoryType type;
}
