package de.kuub.stachys.model.old;

import com.vividsolutions.jts.geom.Geometry;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-07T23:44:54.700+0200")
@StaticMetamodel(Fundort.class)
public class Fundort_ {

    public static volatile SingularAttribute<Fundort, Integer> foId;

    public static volatile SingularAttribute<Fundort, Integer> transId;

    public static volatile SingularAttribute<Fundort, Short> raster;

    public static volatile SingularAttribute<Fundort, Geometry> area;

    public static volatile SingularAttribute<Fundort, Boolean> trusteduser;

    public static volatile SingularAttribute<Fundort, Byte[]> areahull;

    public static volatile CollectionAttribute<Fundort, Zaehldaten> zaehldatenCollection;
}
