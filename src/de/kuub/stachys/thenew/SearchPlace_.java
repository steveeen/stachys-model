package de.kuub.stachys.thenew;

import com.vividsolutions.jts.geom.Geometry;
import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-14T21:36:44.302+0200")
@StaticMetamodel(SearchPlace.class)
public class SearchPlace_ {

    public static volatile SingularAttribute<SearchPlace, UUID> areaID;

    public static volatile SingularAttribute<SearchPlace, Geometry> area;

    public static volatile SingularAttribute<SearchPlace, Date> syslogcreatedOn;

    public static volatile SingularAttribute<SearchPlace, String> syslogcreatedby;

    public static volatile SingularAttribute<SearchPlace, Date> sysloglastChangedOn;

    public static volatile SingularAttribute<SearchPlace, String> sysloglastChangedBy;

    public static volatile SingularAttribute<SearchPlace, Integer> raster;

    public static volatile SingularAttribute<SearchPlace, Geometry> areahull;

    public static volatile SingularAttribute<SearchPlace, Integer> oldid;

    public static volatile CollectionAttribute<SearchPlace, CountedSpecies> countedSpeciesCollection;
}
