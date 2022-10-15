package com.miracl.nego.dao;

import com.miracl.nego.dao.exceptions.NonexistentEntityException;
import com.miracl.nego.dao.exceptions.PreexistingEntityException;
import com.miracl.nego.entity.Protocol;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Rawia BOUABDELLAH - MIRACL
 */
public class ProtocolDAO implements Serializable {

    private EntityManagerFactory emf = null;
    public ProtocolDAO() {
        emf = Persistence.createEntityManagerFactory("nego_wf_PU");
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Protocol protocol) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(protocol);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProtocol(protocol.getProtocolName()) != null) {
                throw new PreexistingEntityException("Protocol " + protocol + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Protocol protocol) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            protocol = em.merge(protocol);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = protocol.getProtocolName();
                if (findProtocol(id) == null) {
                    throw new NonexistentEntityException("The protocol with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Protocol protocol;
            try {
                protocol = em.getReference(Protocol.class, id);
                protocol.getProtocolName();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The protocol with id " + id + " no longer exists.", enfe);
            }
            em.remove(protocol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Protocol> findProtocolEntities() {
        return findProtocolEntities(true, -1, -1);
    }

    public List<Protocol> findProtocolEntities(int maxResults, int firstResult) {
        return findProtocolEntities(false, maxResults, firstResult);
    }

    private List<Protocol> findProtocolEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
        	Query q = em.createQuery("SELECT p FROM Protocol p");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Protocol findProtocol(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Protocol.class, id);
        } finally {
            em.close();
        }
    }

    public int getProtocolCount() {
    	EntityManager em = getEntityManager();
        try {
            return ((Long) em.createQuery("select count(p) from Protocol p").getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Protocol> findByALL(String behavior, String partners, String rounds, String attributes)
    {
        EntityManager em=getEntityManager();
        try{
        return  em.createQuery("SELECT p FROM Protocol p WHERE p.behavior = ?1 and p.partnersNumber = ?2 and p.roundsNumbers = ?3 and p.attributesNumber = ?4").setParameter(1,behavior).setParameter(2,partners).setParameter(3,rounds).setParameter(4,attributes).getResultList();
        }catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally{
            em.close();
        }
    }
    
    public List<Protocol> findByBehavior(String behavior)
    {
        EntityManager em=getEntityManager();
        try{
        return  em.createQuery("SELECT p FROM Protocol p WHERE p.behavior = ?1").setParameter(1,behavior).getResultList();
        }catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally{
            em.close();
        }
    }
    
    public List<Protocol> findByBehaviorAndPartners(String behavior, String partners)
    {
        EntityManager em=getEntityManager();
        try{
        return  em.createQuery("SELECT p FROM Protocol p WHERE p.behavior = ?1 and p.partnersNumber = ?2").setParameter(1,behavior).setParameter(2,partners).getResultList();
        }catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally{
            em.close();
        }
    }
    
    public List<Protocol> findByBehaviorAndPartnersAndRounds(String behavior, String partners, String rounds)
    {
        EntityManager em=getEntityManager();
        try{
        return  em.createQuery("SELECT p FROM Protocol p WHERE p.behavior = ?1 and p.partnersNumber = ?2 and p.roundsNumbers = ?3").setParameter(1,behavior).setParameter(2,partners).setParameter(3,rounds).getResultList();
        }catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally{
            em.close();
        }
    }
    
}
