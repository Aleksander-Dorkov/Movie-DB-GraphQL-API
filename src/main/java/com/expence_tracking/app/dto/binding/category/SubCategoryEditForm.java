package com.expence_tracking.app.dto.binding.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubCategoryEditForm
{
    private Long categoryId;
    private String oldName;
    private String newName;
}
