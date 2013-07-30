package de.kuub.stachys.model.old;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-07T23:44:54.804+0200")
@StaticMetamodel(Zeitschrift.class)
public class Zeitschrift_ {

    public static volatile SingularAttribute<Zeitschrift, Integer> zeitschriftId;

    public static volatile SingularAttribute<Zeitschrift, String> titel;

    public static volatile CollectionAttribute<Zeitschrift, QuZeit> quZeitCollection;
}
