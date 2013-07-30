//@FilterDefs(
//    {
//    @FilterDef(
//        name="betweenLength",
//        parameters = {
//            @ParamDef(name="minLength", type="integer"),
//            @ParamDef(name="maxLength", type="integer")
//        }
//    )
//    }
//)
@TypeDefs(
        {
    @TypeDef(name = "uuid-custom", typeClass = PersistentUUID.class),
    @TypeDef(name = "hstore-json", typeClass = HstoreJson.class)
})
package de.kuub.stachys.thenew;

import de.kuub.utils.HstoreJson;
import de.kuub.utils.PersistentUUID;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
