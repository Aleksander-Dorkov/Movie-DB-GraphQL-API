package com.expence_tracking.app.domain;

import com.expence_tracking.app.domain.enums.CategoryType;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "categories")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "user_id"})})
@TypeDefs({
        @TypeDef(
                name = "list-array",
                typeClass = ListArrayType.class
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
    @Type(type = "list-array")
    @Column(
            name = "sub_categories",
            columnDefinition = "text[]"
    )
    private List<String> subCategories;
    private BigDecimal balance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User owner;
}
