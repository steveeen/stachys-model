package de.kuub.stachys.thenew;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-14T21:36:44.206+0200")
@StaticMetamodel(Pictures.class)
public class Pictures_ {

    public static volatile SingularAttribute<Pictures, Date> syslogcreatedOn;

    public static volatile SingularAttribute<Pictures, String> syslogcreatedby;

    public static volatile SingularAttribute<Pictures, Date> sysloglastChangedOn;

    public static volatile SingularAttribute<Pictures, String> sysloglastChangedBy;

    public static volatile SingularAttribute<Pictures, UUID> pictureId;

    public static volatile SingularAttribute<Pictures, byte[]> picture;

    public static volatile SingularAttribute<Pictures, Integer> oldid;

    public static volatile CollectionAttribute<Pictures, Species> speciesCollection;

    public static volatile CollectionAttribute<Pictures, SpeciesPicture> speciesPictureCollection;
}
