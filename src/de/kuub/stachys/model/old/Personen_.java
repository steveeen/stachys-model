package de.kuub.stachys.model.old;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-07T23:44:54.743+0200")
@StaticMetamodel(Personen.class)
public class Personen_ {

    public static volatile SingularAttribute<Personen, Integer> persId;

    public static volatile SingularAttribute<Personen, String> name;

    public static volatile SingularAttribute<Personen, String> vname;

    public static volatile SingularAttribute<Personen, String> email;

    public static volatile SingularAttribute<Personen, Boolean> kartierer;

    public static volatile SingularAttribute<Personen, Boolean> autor;

    public static volatile SingularAttribute<Personen, String> ort;

    public static volatile SingularAttribute<Personen, String> sonstiges;

    public static volatile SingularAttribute<Personen, String> role;

    public static volatile CollectionAttribute<Personen, Quelle> quelleCollection;

    public static volatile CollectionAttribute<Personen, Zaehldaten> zaehldatenCollection;

    public static volatile CollectionAttribute<Personen, Users> usersCollection;

    public static volatile SingularAttribute<Personen, Users> userId;
}
