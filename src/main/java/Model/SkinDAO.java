package Model;

import java.util.List;


public interface SkinDAO {
	public List<Skin> getSkins();
	public boolean insertSkin(Skin skin);
	public List<Skin> findSkin(String command);
	public boolean updateSkin(Skin skin, double newPrice);
	public boolean deleteSkin(String command);
	public boolean deleteAll();
}
