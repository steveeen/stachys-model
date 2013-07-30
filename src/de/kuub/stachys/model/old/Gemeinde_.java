package de.kuub.stachys.model.old;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-07T23:44:54.728+0200")
@StaticMetamodel(Gemeinde.class)
public class Gemeinde_ {

    public static volatile SingularAttribute<Gemeinde, Integer> gemId;

    public static volatile SingularAttribute<Gemeinde, String> gemeindename;

    public static volatile SingularAttribute<Gemeinde, Integer> gemNr;

    public static volatile SingularAttribute<Gemeinde, Kreise> kreisId;
}
