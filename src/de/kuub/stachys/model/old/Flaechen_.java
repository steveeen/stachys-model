package de.kuub.stachys.model.old;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-07T23:44:54.691+0200")
@StaticMetamodel(Flaechen.class)
public class Flaechen_ {

    public static volatile SingularAttribute<Flaechen, Integer> flId;

    public static volatile SingularAttribute<Flaechen, String> flaechenname;

    public static volatile CollectionAttribute<Flaechen, Flaechennamen> flaechennamenCollection;
}
