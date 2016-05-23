package Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.lang3.math.NumberUtils;

import Model.Condition;
import Model.Skin;
import Model.SkinDAOImpl;
import Model.Type;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViewController implements Initializable {

	private static Logger logger = LoggerFactory.getLogger(ViewController.class);

	@FXML
	TextField textFieldCollection;
	@FXML
	TextField textFieldCollectionS;
	@FXML
	RadioButton radioButtonCollectionS;
	@FXML
	TextField textFieldCollectionD;
	@FXML
	RadioButton radioButtonCollectionD;
	@FXML
	TextField textFieldCollectionU;

	@FXML
	ComboBox<String> comboBoxType;
	@FXML
	ComboBox<String> comboBoxTypeS;
	@FXML
	RadioButton radioButtonTypeS;
	@FXML
	ComboBox<String> comboBoxTypeD;
	@FXML
	RadioButton radioButtonTypeD;
	@FXML
	ComboBox<String> comboBoxTypeU;

	@FXML
	ComboBox<String> comboBoxWeapon;
	@FXML
	ComboBox<String> comboBoxWeaponS;
	@FXML
	RadioButton radioButtonWeaponS;
	@FXML
	ComboBox<String> comboBoxWeaponD;
	@FXML
	RadioButton radioButtonWeaponD;
	@FXML
	ComboBox<String> comboBoxWeaponU;

	@FXML
	TextField textFieldSkin;
	@FXML
	TextField textFieldSkinS;
	@FXML
	RadioButton radioButtonSkinS;
	@FXML
	TextField textFieldSkinD;
	@FXML
	RadioButton radioButtonSkinD;
	@FXML
	TextField textFieldSkinU;

	@FXML
	ComboBox<String> comboBoxCondition;
	@FXML
	ComboBox<String> comboBoxConditionS;
	@FXML
	RadioButton radioButtonConditionS;
	@FXML
	ComboBox<String> comboBoxConditionD;
	@FXML
	RadioButton radioButtonConditionD;
	@FXML
	ComboBox<String> comboBoxConditionU;

	@FXML
	TextField textFieldPrice;
	@FXML
	TextField textFieldPriceMinS;
	@FXML
	TextField textFieldPriceMaxS;
	@FXML
	TextField textFieldPriceMinD;
	@FXML
	TextField textFieldPriceMaxD;
	@FXML
	RadioButton radioButtonPriceS;
	@FXML
	RadioButton radioButtonPriceD;
	@FXML
	TextField textFieldNewPrice;

	@FXML
	Button buttonAdd;
	@FXML
	Button buttonSearch;
	@FXML
	Button buttonDelete;
	@FXML
	Button buttonUpdate;
	@FXML
	Button buttonInitialize;

	static EntityManagerFactory emf;
	static EntityManager em;
	public SkinDAOImpl DAO;

	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	public void initialize(URL location, ResourceBundle resources) {
		this.emf = Persistence.createEntityManagerFactory("db");
		this.em = emf.createEntityManager();
		this.DAO = new SkinDAOImpl(em);

		textFieldCollection.setText("Chroma 3 Case");
		comboBoxType.getItems().addAll("Normal", "StatTrak", "Souvenir");
		comboBoxType.setValue("Normal");
		comboBoxWeapon.getItems().addAll("AK-47", "AUG", "AWP", "CZ75-Auto", "Desert-Eagle", "FAMAS", "Five-Seven",
				"G3SG1", "Galil AR", "Glock-18", "M249", "M4A1-S", "M4A4", "MAC-10", "MAG-7", "MP7", "MP9", "Negev",
				"Nova", "P2000", "P250", "P90", "PP-Bizon", "R8-Revolver", "Sawed-Off", "SCAR-20", "SG 553", "SSG 08",
				"Tec-9", "UMP-45", "USP-S", "XM1014");
		comboBoxWeapon.setValue("P250");
		textFieldSkin.setText("Asiimov");
		comboBoxCondition.getItems().addAll("Factory New", "Minimal Wear", "Field-Tested", "Well-Worn",
				"Battle-Scarred");
		comboBoxCondition.setValue("Field-Tested");
		textFieldPrice.setText("5.0");

		textFieldCollectionS.setText("Chroma 3 Case");
		comboBoxTypeS.getItems().addAll(comboBoxType.getItems());
		comboBoxTypeS.setValue("Normal");
		comboBoxWeaponS.getItems().addAll(comboBoxWeapon.getItems());
		comboBoxWeaponS.setValue("P250");
		textFieldSkinS.setText("Asiimov");
		comboBoxConditionS.getItems().addAll(comboBoxCondition.getItems());
		comboBoxConditionS.setValue("Field-Tested");
		textFieldPriceMinS.setText("2.5");
		textFieldPriceMaxS.setText("3.5");

		textFieldCollectionU.setText("Chroma 3 Case");
		comboBoxTypeU.getItems().addAll(comboBoxType.getItems());
		comboBoxTypeU.setValue("Normal");
		comboBoxWeaponU.getItems().addAll(comboBoxWeapon.getItems());
		comboBoxWeaponU.setValue("P250");
		textFieldSkinU.setText("Asiimov");
		comboBoxConditionU.getItems().addAll(comboBoxCondition.getItems());
		comboBoxConditionU.setValue("Field-Tested");
		textFieldNewPrice.setText("9.07");

		textFieldCollectionD.setText("Chroma 3 Case");
		comboBoxTypeD.getItems().addAll(comboBoxType.getItems());
		comboBoxTypeD.setValue("Normal");
		comboBoxWeaponD.getItems().addAll(comboBoxWeapon.getItems());
		comboBoxWeaponD.setValue("P250");
		textFieldSkinD.setText("Asiimov");
		comboBoxConditionD.getItems().addAll(comboBoxCondition.getItems());
		comboBoxConditionD.setValue("Field-Tested");
		textFieldPriceMinD.setText("2.5");
		textFieldPriceMaxD.setText("2.9");

		textFieldCollectionS.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				if (event.getSource().equals(textFieldCollectionS))
					radioButtonCollectionS.selectedProperty().set(true);
				else if (event.getSource().equals(comboBoxTypeS))
					radioButtonTypeS.selectedProperty().set(true);
				else if (event.getSource().equals(comboBoxWeaponS))
					radioButtonWeaponS.selectedProperty().set(true);
				else if (event.getSource().equals(textFieldSkinS))
					radioButtonSkinS.selectedProperty().set(true);
				else if (event.getSource().equals(comboBoxConditionS))
					radioButtonConditionS.selectedProperty().set(true);
				else if (event.getSource().equals(textFieldPriceMinS) || event.getSource().equals(textFieldPriceMaxS))
					radioButtonPriceS.selectedProperty().set(true);
			}
		});
		comboBoxTypeS.setOnMouseClicked(textFieldCollectionS.getOnMouseClicked());
		comboBoxWeaponS.setOnMouseClicked(textFieldCollectionS.getOnMouseClicked());
		textFieldSkinS.setOnMouseClicked(textFieldCollectionS.getOnMouseClicked());
		comboBoxConditionS.setOnMouseClicked(textFieldCollectionS.getOnMouseClicked());
		textFieldPriceMinS.setOnMouseClicked(textFieldCollectionS.getOnMouseClicked());
		textFieldPriceMaxS.setOnMouseClicked(textFieldCollectionS.getOnMouseClicked());

		textFieldCollectionD.setOnMouseClicked(new EventHandler() {
			public void handle(Event event) {
				if (event.getSource().equals(textFieldCollectionD))
					radioButtonCollectionD.selectedProperty().set(true);
				else if (event.getSource().equals(comboBoxTypeD))
					radioButtonTypeD.selectedProperty().set(true);
				else if (event.getSource().equals(comboBoxWeaponD))
					radioButtonWeaponD.selectedProperty().set(true);
				else if (event.getSource().equals(textFieldSkinD))
					radioButtonSkinD.selectedProperty().set(true);
				else if (event.getSource().equals(comboBoxConditionD))
					radioButtonConditionD.selectedProperty().set(true);
				else if (event.getSource().equals(textFieldPriceMinD) || event.getSource().equals(textFieldPriceMaxD))
					radioButtonPriceD.selectedProperty().set(true);
			}
		});

		comboBoxTypeD.setOnMouseClicked(textFieldCollectionD.getOnMouseClicked());
		comboBoxWeaponD.setOnMouseClicked(textFieldCollectionD.getOnMouseClicked());
		textFieldSkinD.setOnMouseClicked(textFieldCollectionD.getOnMouseClicked());
		comboBoxConditionD.setOnMouseClicked(textFieldCollectionD.getOnMouseClicked());
		textFieldPriceMinD.setOnMouseClicked(textFieldCollectionD.getOnMouseClicked());
		textFieldPriceMaxD.setOnMouseClicked(textFieldCollectionD.getOnMouseClicked());
	}

	@FXML
	public void handleAddButton(ActionEvent event) {
		String collection = textFieldCollection.getText();
		String type = comboBoxType.getSelectionModel().getSelectedItem().toUpperCase();
		String weapon = comboBoxWeapon.getSelectionModel().getSelectedItem();
		String skin = textFieldSkin.getText();
		String condition = comboBoxCondition.getSelectionModel().getSelectedItem();
		if (condition.contains("-"))
			condition = condition.split("-")[0].toUpperCase();
		else
			condition = condition.split(" ")[0].toUpperCase();
		double price;
		if (!NumberUtils.isNumber(textFieldPrice.getText())) {
			logger.info("Wrong price!");
			return;
		}
		price = Double.parseDouble(textFieldPrice.getText());
		Skin addedSkin = new Skin(collection, Type.valueOf(type), weapon, skin, Condition.valueOf(condition), price);
		if (DAO.insertSkin(addedSkin))
			logger.info("Added: {}", addedSkin);
		else
			logger.info("The database already contains: {}", addedSkin);
	}

	@FXML
	public void handleSearchButton(ActionEvent event) {
		StringBuilder q = new StringBuilder(" WHERE '");

		if (radioButtonCollectionS.isSelected()) {
			String collection = textFieldCollectionS.getText();
			q.append(collection).append("'=collection");
		} else if (radioButtonTypeS.isSelected()) {
			String type = comboBoxTypeS.getSelectionModel().getSelectedItem().toUpperCase();
			q.append(Type.valueOf(type)).append("'=tipus");
		} else if (radioButtonWeaponS.isSelected()) {
			String weapon = comboBoxWeaponS.getSelectionModel().getSelectedItem();
			q.append(weapon).append("'=weapon");
		} else if (radioButtonSkinS.isSelected()) {
			String skin = textFieldSkinS.getText();
			q.append(skin).append("'=skin");
		} else if (radioButtonConditionS.isSelected()) {
			String condition = comboBoxConditionS.getSelectionModel().getSelectedItem();
			if (condition.contains("-"))
				condition = condition.split("-")[0].toUpperCase();
			else
				condition = condition.split(" ")[0].toUpperCase();
			q.append(Condition.valueOf(condition)).append("'=condition");
		} else if (radioButtonPriceS.isSelected()) {
			double min = 0.0;
			double max = 0.0;
			try {
				min = Double.parseDouble(textFieldPriceMinS.getText().replace(",", "."));
			} catch (NumberFormatException e) {
				logger.debug("Wrong Min value!");
				return;
			}
			try {
				max = Double.parseDouble(textFieldPriceMaxS.getText().replace(",", "."));
			} catch (NumberFormatException e) {
				logger.debug("Wrong Max value!");
				return;
			}
			q.deleteCharAt(q.length() - 1);
			q.append("price BETWEEN ").append(min).append(" AND ").append(max);
		}

		List<Skin> searchedSkin = DAO.findSkin(q.toString());
		if (searchedSkin != null)
			logger.info("Found skin(s): {}", searchedSkin.size());
		else
			logger.info("Nothing found!");
	}

	@FXML
	public void handleUpdateButton(ActionEvent event) {
		String collection = textFieldCollectionU.getText();
		String type = comboBoxTypeU.getSelectionModel().getSelectedItem().toUpperCase();
		String weapon = comboBoxWeaponU.getSelectionModel().getSelectedItem();
		String skin = textFieldSkinU.getText();
		String condition = comboBoxConditionU.getSelectionModel().getSelectedItem();

		if (condition.contains("-"))
			condition = condition.split("-")[0].toUpperCase();
		else
			condition = condition.split(" ")[0].toUpperCase();
		double price;
		if (!NumberUtils.isNumber(textFieldNewPrice.getText())) {
			logger.debug("Wrong price!");
			return;
		}
		price = Double.parseDouble(textFieldNewPrice.getText());
		Skin updateSkin = new Skin(collection, Type.valueOf(type), weapon, skin, Condition.valueOf(condition), price);

		if (DAO.updateSkin(updateSkin, price))
			logger.info("Successful updated!");
		else
			logger.info("Unsuccessful updated!");
	}

	@FXML
	public void handleDeleteButton(ActionEvent event) {
		StringBuilder q = new StringBuilder(" WHERE '");

		if (radioButtonCollectionD.isSelected()) {
			String collection = textFieldCollectionD.getText();
			q.append(collection).append("'=collection");
		} else if (radioButtonTypeD.isSelected()) {
			String type = comboBoxTypeD.getSelectionModel().getSelectedItem().toUpperCase();
			q.append(Type.valueOf(type)).append("'=tipus");
		} else if (radioButtonWeaponD.isSelected()) {
			String weapon = comboBoxWeaponD.getSelectionModel().getSelectedItem();
			q.append(weapon).append("'=weapon");
		} else if (radioButtonSkinD.isSelected()) {
			String skin = textFieldSkinD.getText();
			q.append(skin).append("'=skin");
		} else if (radioButtonConditionD.isSelected()) {
			String condition = comboBoxConditionD.getSelectionModel().getSelectedItem();
			if (condition.contains("-"))
				condition = condition.split("-")[0].toUpperCase();
			else
				condition = condition.split(" ")[0].toUpperCase();
			q.append(Condition.valueOf(condition)).append("'=condition");
		} else if (radioButtonPriceD.isSelected()) {
			double min = 0.0;
			double max = 0.0;
			try {
				min = Double.parseDouble(textFieldPriceMinD.getText().replace(",", "."));
			} catch (NumberFormatException e) {
				logger.debug("Wrong Min value!");
				return;
			}
			try {
				max = Double.parseDouble(textFieldPriceMaxD.getText().replace(",", "."));
			} catch (NumberFormatException e) {
				logger.debug("Wrong Max value!");
				return;
			}
			q.deleteCharAt(q.length() - 1);
			q.append("price BETWEEN ").append(min).append(" AND ").append(max);
		}

		if (DAO.deleteSkin(q.toString()))
			logger.info("Successful deleted!");
		else
			logger.info("Unsuccessful deleted!");
	}

	@FXML
	public void handleInitializeButton(ActionEvent event) {
		buttonInitialize.setVisible(false);

		try {
			DAO.deleteAll();
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/links"));
			String line = null;
			while ((line = br.readLine()) != null) {
				Type type = Type.NORMAL;
				double price = Double.valueOf(line.split(";")[0]);
				String collection = line.split(";")[1];
				line = line.split(";")[2];
				if (line.contains("StatTrak")) {
					type = Type.STATTRAK;
					line = line.replace("http://steamcommunity.com/market/listings/730/StatTrak%E2%84%A2%20", "");
				} else if (line.contains("Souvenir")) {
					type = Type.SOUVENIR;
					line = line.replace("http://steamcommunity.com/market/listings/730/Souvenir%20", "");
				} else {
					line = line.replace("http://steamcommunity.com/market/listings/730/", "");
				}
				line = line.replace("%20%7C%20", ";").replace("%20%28", ";").replace("%20", " ").replace("%29", "");
				String tmp[] = line.split(";");

				if (tmp[2].contains("-"))
					tmp[2] = tmp[2].split("-")[0].toUpperCase();
				else
					tmp[2] = tmp[2].split(" ")[0].toUpperCase();
				Skin addSkin = new Skin(collection, type, tmp[0], tmp[1], Condition.valueOf(tmp[2]), price);
				if (DAO.insertSkin(addSkin))
					logger.info("Added: {}", addSkin);
				else
					logger.info("The database already contains: {}", addSkin);
			}
		} catch (FileNotFoundException e) {
			logger.error("FileNotFound caught: {}", e);
		} catch (IOException e) {
			logger.error("IOException caught: {}", e);
		}
		logger.debug("Initialize done!");
	}

	@FXML
	public void handleGetLinkButton(ActionEvent event) {
		if (DAO.searchedSkin.size() == 0) {
			logger.info("No skins!");
			return;
		}
		DecimalFormat f = new DecimalFormat("0.00");
		for (Skin s : DAO.searchedSkin) {
			System.out.printf("%s;%s\n", f.format(s.getAvgPrice()).replace(",", "."), DAO.getSkinLink(s));
		}
	}

	@FXML
	public void handleListButton(ActionEvent event) {
		if (DAO.searchedSkin.size() == 0) {
			logger.info("No skin(s) in database!");
			return;
		}
		int itemcount = 1;
		for (Skin s : DAO.searchedSkin) {
			logger.info("{}. {}", itemcount++, s);
		}
	}

	public static void close() {
		em.close();
		emf.close();
	}
}
