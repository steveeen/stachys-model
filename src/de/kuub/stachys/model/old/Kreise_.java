package de.kuub.stachys.model.old;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-07T23:44:54.733+0200")
@StaticMetamodel(Kreise.class)
public class Kreise_ {

    public static volatile SingularAttribute<Kreise, Integer> kreisId;

    public static volatile SingularAttribute<Kreise, String> kreisname;

    public static volatile SingularAttribute<Kreise, Integer> kreisNr;

    public static volatile CollectionAttribute<Kreise, Gemeinde> gemeindeCollection;
}
