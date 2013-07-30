package de.kuub.stachys.thenew;

import com.vividsolutions.jts.geom.Geometry;
import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-14T21:36:44.049+0200")
@StaticMetamodel(AreaNames.class)
public class AreaNames_ {

    public static volatile SingularAttribute<AreaNames, Date> syslogcreatedOn;

    public static volatile SingularAttribute<AreaNames, String> syslogcreatedby;

    public static volatile SingularAttribute<AreaNames, Date> sysloglastChangedOn;

    public static volatile SingularAttribute<AreaNames, String> sysloglastChangedBy;

    public static volatile SingularAttribute<AreaNames, UUID> areanameid;

    public static volatile SingularAttribute<AreaNames, String> name;

    public static volatile SingularAttribute<AreaNames, Geometry> referencedArea;
}
