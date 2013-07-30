package de.kuub.stachys.model.old;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-07T23:44:54.793+0200")
@StaticMetamodel(Users.class)
public class Users_ {

    public static volatile SingularAttribute<Users, Integer> userId;

    public static volatile SingularAttribute<Users, String> name;

    public static volatile SingularAttribute<Users, String> pass;

    public static volatile SingularAttribute<Users, String> role;

    public static volatile SingularAttribute<Users, Boolean> trusted;

    public static volatile SingularAttribute<Users, String> salt;

    public static volatile SingularAttribute<Users, Integer> transId;

    public static volatile SingularAttribute<Users, String> pass2;

    public static volatile SingularAttribute<Users, Personen> persId;

    public static volatile CollectionAttribute<Users, Personen> personenCollection;
}
