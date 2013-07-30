package de.kuub.stachys.model.old;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-07T23:44:54.705+0200")
@StaticMetamodel(Gebiet.class)
public class Gebiet_ {

    public static volatile SingularAttribute<Gebiet, Integer> gebietId;

    public static volatile SingularAttribute<Gebiet, String> gebietsname;

    public static volatile CollectionAttribute<Gebiet, Gebietsnamen> gebietsnamenCollection;
}
