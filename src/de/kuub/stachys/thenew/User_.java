package de.kuub.stachys.thenew;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-14T21:36:44.403+0200")
@StaticMetamodel(User.class)
public class User_ {

    public static volatile SingularAttribute<User, Date> syslogcreatedOn;

    public static volatile SingularAttribute<User, String> syslogcreatedby;

    public static volatile SingularAttribute<User, Date> sysloglastChangedOn;

    public static volatile SingularAttribute<User, String> sysloglastChangedBy;

    public static volatile SingularAttribute<User, UUID> userId;

    public static volatile SingularAttribute<User, String> username;

    public static volatile SingularAttribute<User, String> password;

    public static volatile SingularAttribute<User, Boolean> trusted;

    public static volatile SingularAttribute<User, String> salt;

    public static volatile SingularAttribute<User, String> permakey;

    public static volatile SingularAttribute<User, Integer> oldid;

    public static volatile CollectionAttribute<User, Person> personsCollection;
}
