package de.kuub.stachys.thenew;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-14T21:36:44.081+0200")
@StaticMetamodel(Biotop.class)
public class Biotop_ {

    public static volatile SingularAttribute<Biotop, Date> syslogcreatedOn;

    public static volatile SingularAttribute<Biotop, String> syslogcreatedby;

    public static volatile SingularAttribute<Biotop, Date> sysloglastChangedOn;

    public static volatile SingularAttribute<Biotop, String> sysloglastChangedBy;

    public static volatile SingularAttribute<Biotop, UUID> biotopId;

    public static volatile SingularAttribute<Biotop, String> biotoptyp;

    public static volatile SingularAttribute<Biotop, Integer> oldid;

    public static volatile CollectionAttribute<Biotop, SpeciesBiotop> speciesBiotopCollection;
}
