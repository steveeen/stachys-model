package de.kuub.stachys.model.old;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-05-07T23:44:54.769+0200")
@StaticMetamodel(Taxonomisch.class)
public class Taxonomisch_ {

    public static volatile SingularAttribute<Taxonomisch, Integer> artId;

    public static volatile SingularAttribute<Taxonomisch, String> sciencename;

    public static volatile SingularAttribute<Taxonomisch, String> deutschername;

    public static volatile SingularAttribute<Taxonomisch, String> rlBrd;

    public static volatile SingularAttribute<Taxonomisch, String> rlNrw;

    public static volatile SingularAttribute<Taxonomisch, byte[]> artbild;

    public static volatile SingularAttribute<Taxonomisch, String> fsuffix;

    public static volatile CollectionAttribute<Taxonomisch, Biotop> biotopCollection;

    public static volatile SingularAttribute<Taxonomisch, Artpics> artpics;

    public static volatile CollectionAttribute<Taxonomisch, TaxRl> taxRlCollection;

    public static volatile CollectionAttribute<Taxonomisch, Zaehldaten> zaehldatenCollection;
}
