package de.kuub.stachys.model.old;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-07T23:44:54.774+0200")
@StaticMetamodel(TaxRl.class)
public class TaxRl_ {

    public static volatile SingularAttribute<TaxRl, TaxRlPK> taxRlPK;

    public static volatile SingularAttribute<TaxRl, String> status;

    public static volatile SingularAttribute<TaxRl, Taxonomisch> taxonomisch;

    public static volatile SingularAttribute<TaxRl, Roteliste> roteliste;
}
