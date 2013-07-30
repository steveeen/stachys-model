package de.kuub.stachys.model.old;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-07T23:44:54.764+0200")
@StaticMetamodel(Roteliste.class)
public class Roteliste_ {

    public static volatile SingularAttribute<Roteliste, Integer> rlId;

    public static volatile SingularAttribute<Roteliste, String> land;

    public static volatile SingularAttribute<Roteliste, Short> jahr;

    public static volatile SingularAttribute<Roteliste, Integer> transId;

    public static volatile CollectionAttribute<Roteliste, TaxRl> taxRlCollection;
}
