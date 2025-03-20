package entity;

import entity.Brand;
import entity.Category;
import entity.Employee;
import entity.Orderitem;
import entity.Productnutrient;
import entity.Unit;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-03-20T23:39:24")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Short> quantity;
    public static volatile SingularAttribute<Product, Boolean> flag;
    public static volatile SingularAttribute<Product, Employee> employeeId;
    public static volatile SingularAttribute<Product, Date> createdAt;
    public static volatile SingularAttribute<Product, BigDecimal> price;
    public static volatile SingularAttribute<Product, Date> lastUpdate;
    public static volatile CollectionAttribute<Product, Orderitem> orderitemCollection;
    public static volatile SingularAttribute<Product, Brand> brandId;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, Unit> unitId;
    public static volatile SingularAttribute<Product, String> id;
    public static volatile SingularAttribute<Product, String> detail;
    public static volatile CollectionAttribute<Product, Productnutrient> productnutrientCollection;
    public static volatile SingularAttribute<Product, Category> categoryId;

}