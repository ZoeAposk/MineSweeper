package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Minesweeper {
	Level myLevel;
	Grid myGrid;
	Minefield field;
	TimerBox timer;

	public Minesweeper(File mySpecs) {
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
			myLevel.printSpecs();
			myGrid = new Grid(myLevel);
			myGrid.printGrid();
			myGrid.printNeighbours();
			field = new Minefield(myGrid.numGrid, myLevel.gridSize);
			// timer = new TimerBox(time);
		} catch (InvalidDescriptionException e) {
			System.out.println("Invalid Description Exception!\n" + e.mes);
			// System.exit(0);
		}

		catch (InvalidValueException e) {
			System.out.println("Invalid Value Exception!\n" + e.mes);
			// System.exit(0);
		}

		catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}

	}
}