package de.kuub.stachys.thenew;

import com.vividsolutions.jts.geom.Geometry;
import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-14T21:36:44.290+0200")
@StaticMetamodel(ReferenceAreas.class)
public class ReferenceAreas_ {

    public static volatile SingularAttribute<ReferenceAreas, UUID> areaID;

    public static volatile SingularAttribute<ReferenceAreas, Date> syslogcreatedOn;

    public static volatile SingularAttribute<ReferenceAreas, String> syslogcreatedby;

    public static volatile SingularAttribute<ReferenceAreas, Date> sysloglastChangedOn;

    public static volatile SingularAttribute<ReferenceAreas, String> sysloglastChangedBy;

    public static volatile SingularAttribute<ReferenceAreas, Geometry> area;

    public static volatile SingularAttribute<ReferenceAreas, Integer> oldid;

    public static volatile SingularAttribute<ReferenceAreas, UUID> mainAreaName;
}
