package entity;

import entity.Customer;
import entity.Employee;
import entity.Orderitem;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-03-20T23:39:24")
@StaticMetamodel(Orderproduct.class)
public class Orderproduct_ { 

    public static volatile SingularAttribute<Orderproduct, String> note;
    public static volatile SingularAttribute<Orderproduct, Date> createdAt;
    public static volatile SingularAttribute<Orderproduct, String> address;
    public static volatile SingularAttribute<Orderproduct, Boolean> flag;
    public static volatile SingularAttribute<Orderproduct, Date> lastUpdate;
    public static volatile CollectionAttribute<Orderproduct, Orderitem> orderitemCollection;
    public static volatile SingularAttribute<Orderproduct, Customer> customerId;
    public static volatile SingularAttribute<Orderproduct, Employee> employeeId;
    public static volatile SingularAttribute<Orderproduct, String> id;
    public static volatile SingularAttribute<Orderproduct, String> shipStatus;
    public static volatile SingularAttribute<Orderproduct, String> payStatus;
    public static volatile SingularAttribute<Orderproduct, BigDecimal> totalCost;

}