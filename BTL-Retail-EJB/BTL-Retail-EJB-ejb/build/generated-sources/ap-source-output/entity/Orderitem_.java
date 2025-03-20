package entity;

import entity.Orderproduct;
import entity.Product;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-03-20T23:39:24")
@StaticMetamodel(Orderitem.class)
public class Orderitem_ { 

    public static volatile SingularAttribute<Orderitem, Date> createdAt;
    public static volatile SingularAttribute<Orderitem, Short> quantity;
    public static volatile SingularAttribute<Orderitem, Boolean> flag;
    public static volatile SingularAttribute<Orderitem, Product> productId;
    public static volatile SingularAttribute<Orderitem, Orderproduct> orderId;
    public static volatile SingularAttribute<Orderitem, BigDecimal> price;
    public static volatile SingularAttribute<Orderitem, Integer> id;
    public static volatile SingularAttribute<Orderitem, BigDecimal> totalCost;

}