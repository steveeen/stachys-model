package de.kuub.stachys.thenew;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-14T21:36:44.240+0200")
@StaticMetamodel(RedList.class)
public class RedList_ {

    public static volatile SingularAttribute<RedList, Date> syslogcreatedOn;

    public static volatile SingularAttribute<RedList, String> syslogcreatedby;

    public static volatile SingularAttribute<RedList, Date> sysloglastChangedOn;

    public static volatile SingularAttribute<RedList, String> sysloglastChangedBy;

    public static volatile SingularAttribute<RedList, UUID> redListId;

    public static volatile SingularAttribute<RedList, Short> yearPublication;

    public static volatile SingularAttribute<RedList, String> country;

    public static volatile SingularAttribute<RedList, Integer> oldid;

    public static volatile CollectionAttribute<RedList, RedlistSpecies> redlistSpeciesCollection;
}
