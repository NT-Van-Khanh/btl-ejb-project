package entity;

import entity.Orderproduct;
import entity.Product;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-03-20T23:39:24")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, Date> birthday;
    public static volatile SingularAttribute<Employee, String> lastName;
    public static volatile SingularAttribute<Employee, String> firstName;
    public static volatile SingularAttribute<Employee, Date> createdAt;
    public static volatile SingularAttribute<Employee, String> password;
    public static volatile SingularAttribute<Employee, Boolean> flag;
    public static volatile SingularAttribute<Employee, Boolean> gender;
    public static volatile CollectionAttribute<Employee, Product> productCollection;
    public static volatile SingularAttribute<Employee, String> phone;
    public static volatile CollectionAttribute<Employee, Orderproduct> orderproductCollection;
    public static volatile SingularAttribute<Employee, String> id;
    public static volatile SingularAttribute<Employee, String> email;

}