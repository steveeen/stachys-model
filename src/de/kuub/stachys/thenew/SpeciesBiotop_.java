package de.kuub.stachys.thenew;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-08T00:05:21.781+0200")
@StaticMetamodel(SpeciesBiotop.class)
public class SpeciesBiotop_ {

    public static volatile SingularAttribute<SpeciesBiotop, SpeciesBiotopPK> speciesBiotopPK;

    public static volatile SingularAttribute<SpeciesBiotop, Date> syslogcreatedOn;

    public static volatile SingularAttribute<SpeciesBiotop, String> syslogcreatedby;

    public static volatile SingularAttribute<SpeciesBiotop, Date> sysloglastChangedOn;

    public static volatile SingularAttribute<SpeciesBiotop, String> sysloglastChangedBy;

    public static volatile SingularAttribute<SpeciesBiotop, String> comment;

    public static volatile SingularAttribute<SpeciesBiotop, Species> species;

    public static volatile SingularAttribute<SpeciesBiotop, Biotop> biotop;
}
