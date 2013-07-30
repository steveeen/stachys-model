package de.kuub.stachys.thenew;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-08T00:05:21.765+0200")
@StaticMetamodel(RedlistSpecies.class)
public class RedlistSpecies_ {

    public static volatile SingularAttribute<RedlistSpecies, RedlistSpeciesPK> redlistSpeciesPK;

    public static volatile SingularAttribute<RedlistSpecies, Date> syslogcreatedOn;

    public static volatile SingularAttribute<RedlistSpecies, String> syslogcreatedby;

    public static volatile SingularAttribute<RedlistSpecies, Date> sysloglastChangedOn;

    public static volatile SingularAttribute<RedlistSpecies, String> sysloglastChangedBy;

    public static volatile SingularAttribute<RedlistSpecies, String> value;

    public static volatile SingularAttribute<RedlistSpecies, Species> species;

    public static volatile SingularAttribute<RedlistSpecies, RedList> redList;
}
