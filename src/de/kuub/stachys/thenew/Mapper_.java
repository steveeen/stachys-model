package de.kuub.stachys.thenew;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author Bonke
 */
@Generated(value = "Dali", date = "2013-05-08T00:05:21.740+0200")
@StaticMetamodel(Mapper.class)
public class Mapper_ {

    public static volatile SingularAttribute<Mapper, MapperPK> mapperPK;

    public static volatile SingularAttribute<Mapper, Date> syslogcreatedOn;

    public static volatile SingularAttribute<Mapper, String> syslogcreatedby;

    public static volatile SingularAttribute<Mapper, Date> sysloglastChangedOn;

    public static volatile SingularAttribute<Mapper, String> sysloglastChangedBy;

    public static volatile SingularAttribute<Mapper, Person> persons;

    public static volatile SingularAttribute<Mapper, CountedSpecies> countedSpecies;
}
