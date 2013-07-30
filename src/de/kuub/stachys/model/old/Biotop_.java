package de.kuub.stachys.model.old;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-07T23:44:54.666+0200")
@StaticMetamodel(Biotop.class)
public class Biotop_ {

    public static volatile SingularAttribute<Biotop, Integer> biotopId;

    public static volatile SingularAttribute<Biotop, String> biotoptyp;

    public static volatile CollectionAttribute<Biotop, Taxonomisch> taxonomischCollection;
}
