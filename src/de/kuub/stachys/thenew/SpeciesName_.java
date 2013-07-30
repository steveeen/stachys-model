package de.kuub.stachys.thenew;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-14T21:36:44.338+0200")
@StaticMetamodel(SpeciesName.class)
public class SpeciesName_ {

    public static volatile SingularAttribute<SpeciesName, Date> syslogcreatedOn;

    public static volatile SingularAttribute<SpeciesName, String> syslogcreatedby;

    public static volatile SingularAttribute<SpeciesName, Date> sysloglastChangedOn;

    public static volatile SingularAttribute<SpeciesName, String> sysloglastChangedBy;

    public static volatile SingularAttribute<SpeciesName, UUID> speciesId;

    public static volatile SingularAttribute<SpeciesName, String> speciesname;

    public static volatile SingularAttribute<SpeciesName, Species> species;
}
