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
@StaticMetamodel(CountedSpeciesPerson.class)
public class CountedSpeciesPerson_ {

    public static volatile SingularAttribute<CountedSpeciesPerson, CountedSpeciesPersonPK> countedSpeciespersonsPK;

    public static volatile SingularAttribute<CountedSpeciesPerson, Date> syslogcreatedOn;

    public static volatile SingularAttribute<CountedSpeciesPerson, String> syslogcreatedby;

    public static volatile SingularAttribute<CountedSpeciesPerson, Date> sysloglastChangedOn;

    public static volatile SingularAttribute<CountedSpeciesPerson, String> sysloglastChangedBy;

    public static volatile SingularAttribute<CountedSpeciesPerson, Person> persons;

    public static volatile SingularAttribute<CountedSpeciesPerson, CountedSpecies> countedSpecies;
}
