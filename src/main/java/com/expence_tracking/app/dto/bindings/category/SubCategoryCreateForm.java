package com.expence_tracking.app.dto.bindings.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubCategoryCreateForm
{
    private Long categoryId;
    private String name;
}
