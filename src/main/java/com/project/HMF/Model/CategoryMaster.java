package com.project.HMF.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "category_master")
@Setter
@Getter
@NoArgsConstructor
public class CategoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private Integer categoryId;

    @Column(length = 100)
    private String categoryName;

    @Column(length = 500)
    private String categoryDescription;

    @Column(length = 20)
    private String status;
}
