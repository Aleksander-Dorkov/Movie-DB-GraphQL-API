package com.expence_tracking.app.dto.bindings.category;

import com.expence_tracking.app.domain.enums.CategoryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryCreateForm
{
    private Long userId;
    private String name;
    private CategoryType type;
}
