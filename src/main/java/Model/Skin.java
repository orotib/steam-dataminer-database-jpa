package Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity(name="skin")
@Table(name = "skins")
public class Skin implements Comparable<Skin>, Serializable {
	@Id
	@Column(name="collection")
	private String collection;
	
	@Id
	@Column(name="tipus")
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Id
	@Column(name="weapon")
	private String weapon;
	
	@Id
	@Column(name="skin")
	private String skin;
	
	@Id
	@Column(name="condition")
	@Enumerated(EnumType.STRING)
	private Condition condition;
	
	@Column(name="price")
	private double avgPrice;

	public Skin() {}
	
	public Skin(String collection, Type type, String weapon, String skin, Condition condition, double avgPrice) {
		super();
		this.collection = collection;
		this.type = type;
		this.weapon = weapon;
		this.skin = skin;
		this.condition = condition;
		this.avgPrice = avgPrice;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}

	@Override
	public String toString() {
		return new StringBuilder().append(collection).append(" ").append(type.getValue()).append(" ").append(weapon)
				.append(" ").append(skin).append(" ").append(condition.getValue()).append(" ").append(avgPrice)
				.toString();
	}

	public int compareTo(Skin skin) {
		return skin.avgPrice > avgPrice ? 1 : skin.avgPrice < avgPrice ? -1 : 0;
	}

}
