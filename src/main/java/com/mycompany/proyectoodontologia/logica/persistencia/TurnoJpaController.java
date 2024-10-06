/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoodontologia.logica.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.proyectoodontologia.logica.Paciente;
import com.mycompany.proyectoodontologia.logica.Odontologo;
import com.mycompany.proyectoodontologia.logica.Turno;
import com.mycompany.proyectoodontologia.logica.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
 */
public class TurnoJpaController implements Serializable {

    public TurnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public TurnoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("proyectoOdontologiaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Turno turno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente = turno.getPaciente();
            if (paciente != null) {
                paciente = em.getReference(paciente.getClass(), paciente.getId_persona());
                turno.setPaciente(paciente);
            }
            Odontologo odonto = turno.getOdonto();
            if (odonto != null) {
                odonto = em.getReference(odonto.getClass(), odonto.getId_persona());
                turno.setOdonto(odonto);
            }
            em.persist(turno);
            if (paciente != null) {
                paciente.getTurnos().add(turno);
                paciente = em.merge(paciente);
            }
            if (odonto != null) {
                odonto.getTurnos().add(turno);
                odonto = em.merge(odonto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Turno turno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno persistentTurno = em.find(Turno.class, turno.getId_turno());
            Paciente pacienteOld = persistentTurno.getPaciente();
            Paciente pacienteNew = turno.getPaciente();
            Odontologo odontoOld = persistentTurno.getOdonto();
            Odontologo odontoNew = turno.getOdonto();
            if (pacienteNew != null) {
                pacienteNew = em.getReference(pacienteNew.getClass(), pacienteNew.getId_persona());
                turno.setPaciente(pacienteNew);
            }
            if (odontoNew != null) {
                odontoNew = em.getReference(odontoNew.getClass(), odontoNew.getId_persona());
                turno.setOdonto(odontoNew);
            }
            turno = em.merge(turno);
            if (pacienteOld != null && !pacienteOld.equals(pacienteNew)) {
                pacienteOld.getTurnos().remove(turno);
                pacienteOld = em.merge(pacienteOld);
            }
            if (pacienteNew != null && !pacienteNew.equals(pacienteOld)) {
                pacienteNew.getTurnos().add(turno);
                pacienteNew = em.merge(pacienteNew);
            }
            if (odontoOld != null && !odontoOld.equals(odontoNew)) {
                odontoOld.getTurnos().remove(turno);
                odontoOld = em.merge(odontoOld);
            }
            if (odontoNew != null && !odontoNew.equals(odontoOld)) {
                odontoNew.getTurnos().add(turno);
                odontoNew = em.merge(odontoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = turno.getId_turno();
                if (findTurno(id) == null) {
                    throw new NonexistentEntityException("The turno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno turno;
            try {
                turno = em.getReference(Turno.class, id);
                turno.getId_turno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turno with id " + id + " no longer exists.", enfe);
            }
            Paciente paciente = turno.getPaciente();
            if (paciente != null) {
                paciente.getTurnos().remove(turno);
                paciente = em.merge(paciente);
            }
            Odontologo odonto = turno.getOdonto();
            if (odonto != null) {
                odonto.getTurnos().remove(turno);
                odonto = em.merge(odonto);
            }
            em.remove(turno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Turno> findTurnoEntities() {
        return findTurnoEntities(true, -1, -1);
    }

    public List<Turno> findTurnoEntities(int maxResults, int firstResult) {
        return findTurnoEntities(false, maxResults, firstResult);
    }

    private List<Turno> findTurnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turno.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Turno findTurno(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turno> rt = cq.from(Turno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
