package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class Minesweeper {
	Level myLevel;
	Grid myGrid;
	Minefield field;

	public Minesweeper(File mySpecs) {
		Alert alert = new Alert(AlertType.WARNING);
		try {
			Scanner myReader = new Scanner(mySpecs);

			int difficulty, mines, time, superMine;
			if (myReader.hasNextLine()) {
				difficulty = Integer.parseInt(myReader.nextLine());
			} else {
				myReader.close();
				throw new InvalidDescriptionException("File should have 4 lines, each containing an integer.");
			}
			if (myReader.hasNextLine()) {
				mines = Integer.parseInt(myReader.nextLine());
			} else {
				myReader.close();
				throw new InvalidDescriptionException("File should have 4 lines, each containing an integer.");
			}
			if (myReader.hasNextLine()) {
				time = Integer.parseInt(myReader.nextLine());
			} else {
				myReader.close();
				throw new InvalidDescriptionException("File should have 4 lines, each containing an integer.");
			}
			if (myReader.hasNextLine()) {
				superMine = Integer.parseInt(myReader.nextLine());
			} else {
				myReader.close();
				throw new InvalidDescriptionException("File should have 4 lines, each containing an integer.");
			}

			myReader.close();

			myLevel = new Level(difficulty, mines, time, superMine);
			//myLevel.printSpecs();
			myGrid = new Grid(myLevel);
			//myGrid.printGrid();
			//myGrid.printNeighbours();
			field = new Minefield(myGrid.getNumGrid(), myLevel.getGridSize(), myLevel.getMineNum());
			
		} catch (InvalidDescriptionException e) {
			System.out.println("Invalid Description Exception!\n" + e.mes);
			alert.setContentText("Invalid Description Exception!\n" + e.mes);
			alert.show();
		}

		catch (InvalidValueException e) {
			System.out.println("Invalid Value Exception!\n" + e.mes);
			alert.setContentText("Invalid Value Exception!\n" + e.mes);
			alert.show();
		}

		catch (FileNotFoundException e) {
			System.out.println("File not found");
			alert.setContentText("File not found");
			alert.show();
			
		}

	}

}