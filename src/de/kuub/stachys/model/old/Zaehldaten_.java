package de.kuub.stachys.model.old;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-07T23:44:54.798+0200")
@StaticMetamodel(Zaehldaten.class)
public class Zaehldaten_ {

    public static volatile SingularAttribute<Zaehldaten, Integer> zdId;

    public static volatile SingularAttribute<Zaehldaten, Short> aufnahmejahr;

    public static volatile SingularAttribute<Zaehldaten, Integer> anzahlabs;

    public static volatile SingularAttribute<Zaehldaten, String> zaehleinheit;

    public static volatile SingularAttribute<Zaehldaten, Boolean> schaetzwert;

    public static volatile SingularAttribute<Zaehldaten, String> bNb;

    public static volatile SingularAttribute<Zaehldaten, String> ergaenzung;

    public static volatile SingularAttribute<Zaehldaten, Boolean> trusteduser;

    public static volatile CollectionAttribute<Zaehldaten, Personen> personenCollection;

    public static volatile CollectionAttribute<Zaehldaten, Quelle> quelleCollection;

    public static volatile SingularAttribute<Zaehldaten, Taxonomisch> artId;

    public static volatile SingularAttribute<Zaehldaten, Fundort> foId;
}
