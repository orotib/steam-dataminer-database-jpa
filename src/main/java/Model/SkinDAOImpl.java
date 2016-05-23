package Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;


public class SkinDAOImpl implements SkinDAO {

	EntityManager em;
	public List<Skin> searchedSkin;

	public SkinDAOImpl(EntityManager entityM) {
		this.em = entityM;
		searchedSkin = new ArrayList<Skin>();
	}

	public List<Skin> getSkins() {
		searchedSkin = em.createQuery("select s from " + Skin.class.getName() + " s", Skin.class).getResultList();
		return searchedSkin;
	}

	public boolean insertSkin(Skin skin) {
		try {
			em.getTransaction().begin();
			em.persist(skin);
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Skin> findSkin(String command) {
		searchedSkin = em.createQuery("select s from " + Skin.class.getName() + " s " + command).getResultList();
		return searchedSkin;

	}

	public boolean updateSkin(Skin skin, double newPrice) {
		StringBuilder q = new StringBuilder();
		q.append("UPDATE " + Skin.class.getName() + " SET price=").append(newPrice).append(" WHERE ");
		q.append("collection='").append(skin.getCollection()).append("' AND ");
		q.append("tipus='").append(skin.getType().name()).append("' AND ");
		q.append("weapon='").append(skin.getWeapon()).append("' AND ");
		q.append("skin='").append(skin.getSkin()).append("' AND ");
		q.append("condition='").append(skin.getCondition().name()).append("'");
		try {
			em.getTransaction().begin();
			em.createQuery(q.toString()).executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			return false;
		}

		return true;
	}

	public boolean deleteSkin(String command) {
		try {
			em.getTransaction().begin();
			em.createQuery("delete from " + Skin.class.getName() + command).executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			return false;
		}
		return true;
	}

	public boolean deleteAll() {
		try {
			em.getTransaction().begin();
			em.createQuery("delete from " + Skin.class.getName()).executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			return false;
		}
		return true;
	}

	public String getSkinLink(Skin skin) {
		StringBuilder b = new StringBuilder();
		b.append("http://steamcommunity.com/market/listings/730/");
		if (skin.getType().equals(Type.STATTRAK))
			b.append("StatTrak%E2%84%A2%20");
		else if (skin.getType().equals(Type.SOUVENIR))
			b.append("Souvenir%20");
		else
			;
		b.append(skin.getWeapon()).append("%20%7C%20");
		b.append(skin.getSkin()).append("%20%28");
		b.append(skin.getCondition().getValue()).append("%29");
		return b.toString().replace(" ", "%20");
	}
}
