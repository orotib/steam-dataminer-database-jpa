package Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class SkinDAOImplTest {

	static Skin skinN = new Skin("Col", Type.NORMAL, "AWP", "Asiimov", Condition.FIELD, 5.0);
	static Skin skinST = new Skin("Col", Type.STATTRAK, "AWP", "Asiimov", Condition.FIELD, 5.0);
	static Skin skinS = new Skin("Col", Type.SOUVENIR, "AWP", "Asiimov", Condition.FIELD, 5.0);
	static EntityManagerFactory emf;
	static EntityManager em;
	static SkinDAOImpl DAO;

	static {
		emf = Persistence.createEntityManagerFactory("db");
		em = emf.createEntityManager();
		DAO = new SkinDAOImpl(em);
		DAO.deleteAll();
	}

	@Test
	public void testInsertSkin() {
		assertTrue(DAO.insertSkin(skinN));
	}

	@Test
	public void testFindSkin() {
		assertEquals(Arrays.asList(skinN), DAO.findSkin(" where collection='Col'"));
	}

	@Test
	public void testUpdateSkin() {
		assertTrue(DAO.updateSkin(skinN, 5.5));
	}

	@Test
	public void testGetSkinLink() {
		assertEquals("http://steamcommunity.com/market/listings/730/AWP%20%7C%20Asiimov%20%28Field-Tested%29",
				DAO.getSkinLink(skinN));
		assertEquals(
				"http://steamcommunity.com/market/listings/730/StatTrak%E2%84%A2%20AWP%20%7C%20Asiimov%20%28Field-Tested%29",
				DAO.getSkinLink(skinST));
		assertEquals(
				"http://steamcommunity.com/market/listings/730/Souvenir%20AWP%20%7C%20Asiimov%20%28Field-Tested%29",
				DAO.getSkinLink(skinS));
	}

	@Test
	public void testGetSkins() {
		DAO.insertSkin(skinN);
		assertEquals(Arrays.asList(skinN), DAO.getSkins());
	}
	
	@Test
	public void testDeleteSkin() {
		assertTrue(DAO.deleteSkin(" where collection='col'"));
	}
	
	@Test
	public void testInsertException() {
		DAO.insertSkin(skinN);
		DAO.insertSkin(skinN);
	}

	@Test
	public void testDeleteAll() {
		assertTrue(DAO.deleteAll());
	}

}
