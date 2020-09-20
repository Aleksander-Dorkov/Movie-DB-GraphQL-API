package com.expence_tracking.app.domain;

import com.expence_tracking.app.domain.enums.CategoryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "categories")
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "user_id"})
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
    private BigDecimal balance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User owner;
}
