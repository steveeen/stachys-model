package de.kuub.stachys.thenew;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-14T21:36:44.166+0200")
@StaticMetamodel(Person.class)
public class Person_ {

    public static volatile SingularAttribute<Person, Date> syslogcreatedOn;

    public static volatile SingularAttribute<Person, String> syslogcreatedby;

    public static volatile SingularAttribute<Person, Date> sysloglastChangedOn;

    public static volatile SingularAttribute<Person, String> sysloglastChangedBy;

    public static volatile SingularAttribute<Person, UUID> persId;

    public static volatile SingularAttribute<Person, String> lastname;

    public static volatile SingularAttribute<Person, String> firstname;

    public static volatile SingularAttribute<Person, String> email;

    public static volatile SingularAttribute<Person, String> ort;

    public static volatile SingularAttribute<Person, String> sonstiges;

    public static volatile SingularAttribute<Person, String> role;

    public static volatile SingularAttribute<Person, Integer> oldpid;

    public static volatile SingularAttribute<Person, Integer> olduid;

    public static volatile CollectionAttribute<Person, SpeciesPicture> speciesPictureCollection;

    public static volatile SingularAttribute<Person, User> userId;

    public static volatile CollectionAttribute<Person, Mapper> countedSpeciespersonsCollection;
}
