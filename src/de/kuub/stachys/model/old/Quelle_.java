package de.kuub.stachys.model.old;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-07T23:44:54.751+0200")
@StaticMetamodel(Quelle.class)
public class Quelle_ {

    public static volatile SingularAttribute<Quelle, Integer> quellId;

    public static volatile SingularAttribute<Quelle, String> titel;

    public static volatile SingularAttribute<Quelle, Short> jahr;

    public static volatile SingularAttribute<Quelle, String> quellart;

    public static volatile SingularAttribute<Quelle, String> ort;

    public static volatile SingularAttribute<Quelle, Boolean> publikation;

    public static volatile CollectionAttribute<Quelle, Personen> personenCollection;

    public static volatile CollectionAttribute<Quelle, Zaehldaten> zaehldatenCollection;

    public static volatile CollectionAttribute<Quelle, QuZeit> quZeitCollection;
}
