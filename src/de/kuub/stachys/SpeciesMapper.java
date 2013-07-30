/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys;

import de.kuub.stachys.model.old.Taxonomisch;
import de.kuub.stachys.thenew.Biotop;
import de.kuub.stachys.thenew.Pictures;
import de.kuub.stachys.thenew.RedList;
import de.kuub.stachys.thenew.RedlistSpecies;
import de.kuub.stachys.thenew.Species;
import de.kuub.stachys.thenew.SpeciesBiotop;
import de.kuub.stachys.thenew.SpeciesName;
import de.kuub.stachys.thenew.SpeciesPicture;
import de.kuub.stachys.thenew.SpeciesScienceName;
import de.kuub.utils.ExceptionHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Bonke
 */
public class SpeciesMapper {

    private static EntityManager emr;

    public SpeciesMapper(EntityManager em) {
        emr = em;
    }

    public Map<Integer, Species> TransferSpecies(List<Taxonomisch> speciesList) {
        try {

            Map<Integer, Species> speli = new HashMap<>();

            Query qRedlist = emr.createQuery(" from RedList");

            Map<String, RedList> rlSet = GetRedListAsMap(qRedlist);

            Query qBioTop = emr.createQuery(" from Biotopo");

            Map<Integer, Biotop> bioSet = GetBioTopAsMap(qBioTop);

            for (Taxonomisch todo : speciesList) {
                emr.getTransaction().begin();
                //      System.out.println(todo.getSciencename() + " :: " + todo.getScienceNameToString());
                Species bla = CreateSpecies(todo.getArtId());
                if (bla == null) {
                    System.out.println("JK");
                }
                emr.persist(bla);
                SpeciesScienceName tmp = CreateScienceName(bla, todo);
                emr.persist(tmp);

                emr.persist(CreateSpeciesName(bla, todo));
                bla.setMainScienceName(tmp);
                emr.merge(bla);
                List<SpeciesBiotop> spBios = LoadBiotops(todo, bioSet, bla.getSpeciesId());
                if (spBios != null && !spBios.isEmpty()) {
                    bla.setSpeciesBiotopCollection(spBios);
                    emr.merge(bla);
                }
                List<RedlistSpecies> rlSp = LoadRedListValues(todo, rlSet, bla.getSpeciesId());
                if (rlSp != null && !rlSp.isEmpty()) {
                    bla.setRedlistSpeciesCollection(rlSp);
                    emr.merge(bla);
                }
                CreateSpeciesPictures(todo, emr, bla);
                speli.put(bla.getOldid(), bla);
                //try {
                emr.getTransaction().commit();
//                } catch (Exception e) {
//                    System.out.println("hjkk");
//                }
            }


            emr.clear();
            return speli;

        } catch (PersistenceException ex) {

            ExceptionHelper.ParsePersistenceException(ex);
            emr.getTransaction().rollback();
            emr.clear();
        }
        return null;
    }

    protected static Species CreateSpecies(int oldid) {
        //for each SPecies :
        //create Species with ID
        // Read the existing entries and write to console
        Species bla = new Species();
        bla.setOldid(oldid);
        bla = JavaGIS.FillSysLog(bla);
        return bla;
    }

    protected static SpeciesScienceName CreateScienceName(Species speciesref, Taxonomisch species) {
        SpeciesScienceName tmp = new SpeciesScienceName();
        tmp.setFamily(species.GetGattung());
        tmp.setNamesource("unknown");
        tmp.setSpecies(species.GetSpezies());
        tmp.setSubspecies(species.GetSubSpezies());

        tmp.setSpeciesnameorginal(species.getSciencename());
        tmp = JavaGIS.FillSysLog(tmp);
        tmp.setSpeciesRef(speciesref);
        return tmp;
    }

    protected static SpeciesName CreateSpeciesName(Species speciesref, Taxonomisch species) {
        SpeciesName tmp = new SpeciesName();
        tmp.setSpeciesname(species.getDeutschername());
        tmp = JavaGIS.FillSysLog(tmp);
        tmp.setSpecies(speciesref);
        return tmp;
    }

    protected static Map<String, RedList> GetRedListAsMap(Query qRedlist) {
        List<RedList> redlist = qRedlist.getResultList();
        Map<String, RedList> rlSet = new HashMap<>();
        for (RedList rls : redlist) {
            if (!rlSet.containsKey(rls.getCountry())) {
                rlSet.put(rls.getCountry(), rls);
            }
        }
        return rlSet;
    }

    private static Map<Integer, Biotop> GetBioTopAsMap(Query q) {
        List<Biotop> list = q.getResultList();
        Map<Integer, Biotop> bSet = new HashMap<>();
        for (Biotop btp : list) {
            if (!bSet.containsKey(btp.getOldid())) {
                bSet.put(btp.getOldid(), btp);
            }
        }
        return bSet;
    }

    protected static List<SpeciesBiotop> LoadBiotops(Taxonomisch todo, Map<Integer, Biotop> btps, UUID speciesId) {
        if (todo.getBiotopCollection() == null) {
            return null;
        }
        List<SpeciesBiotop> spBios = new ArrayList<>();
        for (de.kuub.stachys.model.old.Biotop bp : todo.getBiotopCollection()) {
            System.out.println(bp.toString());
            Biotop tmp = btps.get(bp.getBiotopId());
            System.out.println(tmp.getBiotoptyp() + "::" + bp.getBiotoptyp());
            SpeciesBiotop spbp = new SpeciesBiotop(tmp.getBiotopId(), speciesId);
            spbp = JavaGIS.FillSysLog(spbp);
            spBios.add(spbp);
        }
        return spBios;
    }

    private static List<RedlistSpecies> LoadRedListValues(Taxonomisch todo, Map<String, RedList> rlSet, UUID speciesId) {

        List<RedlistSpecies> rpSp = new ArrayList<>();
        UUID rluid = rlSet.get("BRD").getRedListId();
        if (todo.getRlBrd() != null && !todo.getRlBrd().isEmpty()) {
            RedlistSpecies tmp = new RedlistSpecies(speciesId, rluid, todo.getRlBrd());
            tmp = JavaGIS.FillSysLog(tmp);
            rpSp.add(tmp);
        }
        rluid = rlSet.get("NRW").getRedListId();
        if (todo.getRlNrw() != null && !todo.getRlNrw().isEmpty()) {
            RedlistSpecies tmp = new RedlistSpecies(speciesId, rluid, todo.getRlNrw());
            tmp = JavaGIS.FillSysLog(tmp);
            rpSp.add(tmp);
        }
        return rpSp;
    }

    protected static void CreateSpeciesPictures(Taxonomisch todo, EntityManager em2, Species bla) {
        Collection<SpeciesPicture> sppics = new ArrayList<>();
        if (todo.hasArtbild()) {
            Pictures newPic = new Pictures();
            newPic.setMimeType("image/jpeg");
            newPic.setPicture(todo.getArtbild());
            newPic.setOldid(todo.getArtId());
            newPic = JavaGIS.FillSysLog(newPic);
            em2.persist(newPic);
            SpeciesPicture newspic = new SpeciesPicture(bla.getSpeciesId(), newPic.getPictureId());
            newspic = JavaGIS.FillSysLog(newspic);
            sppics.add(newspic);

            bla.setSpeciesPictureCollection(sppics);
            bla.setMainPicture(newPic);
            em2.merge(bla);
        }
    }

    /**
     *
     * @param bioold
     * @return
     */
    public Species mapSpecies(Taxonomisch specold) {
        Species specnew = new Species();
        specnew.setOldid(specold.getArtId());
        return specnew;
    }
}
