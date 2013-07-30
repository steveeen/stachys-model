package de.kuub.stachys.thenew;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-14T21:36:44.114+0200")
@StaticMetamodel(CountedSpecies.class)
public class CountedSpecies_ {

    public static volatile SingularAttribute<CountedSpecies, Date> syslogcreatedOn;

    public static volatile SingularAttribute<CountedSpecies, String> syslogcreatedby;

    public static volatile SingularAttribute<CountedSpecies, Date> sysloglastChangedOn;

    public static volatile SingularAttribute<CountedSpecies, String> sysloglastChangedBy;

    public static volatile SingularAttribute<CountedSpecies, UUID> zdId;

    public static volatile SingularAttribute<CountedSpecies, Short> yearofRecord;

    public static volatile SingularAttribute<CountedSpecies, Integer> countedUnits;

    public static volatile SingularAttribute<CountedSpecies, Boolean> estimation;

    public static volatile SingularAttribute<CountedSpecies, String> blooming;

    public static volatile SingularAttribute<CountedSpecies, String> comments;

    public static volatile SingularAttribute<CountedSpecies, Boolean> trusted;

    public static volatile SingularAttribute<CountedSpecies, Integer> oldid;

    public static volatile SingularAttribute<CountedSpecies, Species> speciesId;

    public static volatile SingularAttribute<CountedSpecies, SearchPlace> foId;

    public static volatile CollectionAttribute<CountedSpecies, CountedSpeciesPerson> countedSpeciespersonsCollection;
}
