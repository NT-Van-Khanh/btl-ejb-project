package entity;

import entity.Productnutrient;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-03-20T23:39:24")
@StaticMetamodel(Nutrient.class)
public class Nutrient_ { 

    public static volatile SingularAttribute<Nutrient, Boolean> flag;
    public static volatile SingularAttribute<Nutrient, String> name;
    public static volatile SingularAttribute<Nutrient, String> id;
    public static volatile SingularAttribute<Nutrient, String> detail;
    public static volatile CollectionAttribute<Nutrient, Productnutrient> productnutrientCollection;

}