
package com.miracl.nego.dao;

import com.miracl.nego.dao.exceptions.NonexistentEntityException;
import com.miracl.nego.entity.Provider;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Rawia BOUABDELLAH-ISIMS
 */
public class ProviderDAO implements Serializable {

    public ProviderDAO() {
    	emf = Persistence.createEntityManagerFactory("engine-wf-PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Provider provider) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(provider);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Provider provider) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            provider = em.merge(provider);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = provider.getIdProvider();
                if (findProvider(id) == null) {
                    throw new NonexistentEntityException("The provider with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Provider provider;
            try {
                provider = em.getReference(Provider.class, id);
                provider.getIdProvider();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The provider with id " + id + " no longer exists.", enfe);
            }
            em.remove(provider);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Provider> findProviderEntities() {
        return findProviderEntities(true, -1, -1);
    }

    public List<Provider> findProviderEntities(int maxResults, int firstResult) {
        return findProviderEntities(false, maxResults, firstResult);
    }

    private List<Provider> findProviderEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
        	Query q = em.createQuery("SELECT p FROM Provider p");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Provider> findService() {
    	 EntityManager em=getEntityManager();
         try{
             return em.createQuery("Select DISTINCT p.serviceName From Provider p ").getResultList();
         }
         catch(Exception e){
             e.printStackTrace();
             return null;
         }
         finally{
             em.close();
         }
    }
    
    public List<Provider> findByService(String serviceName) {
   	 EntityManager em=getEntityManager();
        try{
            return em.createQuery("Select p From Provider p WHERE p.serviceName =?1").setParameter(1,serviceName).getResultList();
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
        finally{
            em.close();
        }
   }
    
    public List<Provider> findByContributor(String contributor) {
      	 EntityManager em=getEntityManager();
           try{
               return em.createQuery("Select p From Provider p WHERE p.contributor =?1").setParameter(1,contributor).getResultList();
           }
           catch(Exception e){
               e.printStackTrace();
               return null;
           }
           finally{
               em.close();
           }
      }
    
    public List<Provider> findContributor() {
   	 EntityManager em=getEntityManager();
        try{
            return em.createQuery("Select DISTINCT p.contributor From Provider p ").getResultList();
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
        finally{
            em.close();
        }
   }

    public List<Provider> findByServiceAndContributor(String serviceName, String contributor) {
     	 EntityManager em=getEntityManager();
          try{
              return em.createQuery("Select p From Provider p WHERE p.serviceName =?1 and p.contributor =?2").setParameter(1, serviceName).setParameter(2, contributor).getResultList();
          }
          catch(Exception e){
              e.printStackTrace();
              return null;
          }
          finally{
              em.close();
          }
     }
    public Provider findProvider(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Provider.class, id);
        } finally {
            em.close();
        }
    }

    public int getProviderCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Provider> rt = cq.from(Provider.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
