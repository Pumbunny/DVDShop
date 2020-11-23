package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Dvdcart;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-24T00:09:42")
@StaticMetamodel(Dvdcatalog.class)
public class Dvdcatalog_ { 

    public static volatile SingularAttribute<Dvdcatalog, Integer> quantity;
    public static volatile SingularAttribute<Dvdcatalog, String> rate;
    public static volatile SingularAttribute<Dvdcatalog, Double> price;
    public static volatile SingularAttribute<Dvdcatalog, String> name;
    public static volatile CollectionAttribute<Dvdcatalog, Dvdcart> dvdcartCollection;
    public static volatile SingularAttribute<Dvdcatalog, Integer> id;
    public static volatile SingularAttribute<Dvdcatalog, Integer> years;

}