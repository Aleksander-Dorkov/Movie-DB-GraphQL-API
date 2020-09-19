package com.expence_tracking.app.domain;

import com.expence_tracking.app.domain.enums.CategoryType;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "categories")
@TypeDefs({
        @TypeDef(
                name = "string-array",
                typeClass = StringArrayType.class
        )
})
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_gen")
    @SequenceGenerator(name = "category_gen", sequenceName = "category_seq", allocationSize = 1)
    private Long categoryId;
    @Enumerated(EnumType.STRING)
    private CategoryType type;
    private String name;
    @Type(type = "string-array")
    @Column(
            name = "sub_categories",
            columnDefinition = "text[]"
    )
    private String[] subCategories;
    private BigInteger balance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User userId;

}
