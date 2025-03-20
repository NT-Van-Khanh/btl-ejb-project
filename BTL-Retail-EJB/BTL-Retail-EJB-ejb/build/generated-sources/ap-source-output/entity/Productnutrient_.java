package entity;

import entity.Nutrient;
import entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-03-20T23:39:24")
@StaticMetamodel(Productnutrient.class)
public class Productnutrient_ { 

    public static volatile SingularAttribute<Productnutrient, Nutrient> nutrientId;
    public static volatile SingularAttribute<Productnutrient, Boolean> flag;
    public static volatile SingularAttribute<Productnutrient, Product> productId;
    public static volatile SingularAttribute<Productnutrient, String> id;

}