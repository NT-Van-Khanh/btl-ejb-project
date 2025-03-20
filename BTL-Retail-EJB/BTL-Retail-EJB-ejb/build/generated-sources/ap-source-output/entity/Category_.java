package entity;

import entity.Product;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-03-20T23:39:24")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, Date> createdAt;
    public static volatile SingularAttribute<Category, Boolean> flag;
    public static volatile CollectionAttribute<Category, Product> productCollection;
    public static volatile SingularAttribute<Category, String> name;
    public static volatile SingularAttribute<Category, String> id;

}