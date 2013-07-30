package de.kuub.stachys.thenew;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-08T00:05:21.791+0200")
@StaticMetamodel(SpeciesPicture.class)
public class SpeciesPicture_ {

    public static volatile SingularAttribute<SpeciesPicture, SpeciesPicturePK> speciesPicturePK;

    public static volatile SingularAttribute<SpeciesPicture, Date> syslogcreatedOn;

    public static volatile SingularAttribute<SpeciesPicture, String> syslogcreatedby;

    public static volatile SingularAttribute<SpeciesPicture, Date> sysloglastChangedOn;

    public static volatile SingularAttribute<SpeciesPicture, String> sysloglastChangedBy;

    public static volatile SingularAttribute<SpeciesPicture, String> comment;

    public static volatile SingularAttribute<SpeciesPicture, Species> species;

    public static volatile SingularAttribute<SpeciesPicture, Pictures> pictures;

    public static volatile SingularAttribute<SpeciesPicture, Person> copyrightPersonId;
}
