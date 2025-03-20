package entity;

import entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-03-20T23:39:24")
@StaticMetamodel(Unit.class)
public class Unit_ { 

    public static volatile SingularAttribute<Unit, Boolean> flag;
    public static volatile CollectionAttribute<Unit, Product> productCollection;
    public static volatile SingularAttribute<Unit, String> name;
    public static volatile SingularAttribute<Unit, String> id;

}