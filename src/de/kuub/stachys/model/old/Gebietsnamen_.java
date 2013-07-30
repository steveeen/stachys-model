package de.kuub.stachys.model.old;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-07T23:44:54.723+0200")
@StaticMetamodel(Gebietsnamen.class)
public class Gebietsnamen_ {

    public static volatile SingularAttribute<Gebietsnamen, Integer> gbaliasId;

    public static volatile SingularAttribute<Gebietsnamen, String> gebName;

    public static volatile SingularAttribute<Gebietsnamen, Boolean> hauptname;

    public static volatile SingularAttribute<Gebietsnamen, Gebiet> gebietId;
}
