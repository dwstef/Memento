package pl.edu.agh.mwo.scratchbook;

import java.util.List;
import java.util.Scanner;

public class ScratchpadDemo {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter your text:");
		String text = scanner.nextLine();

		Editor editor = new Editor(text);
		CareTaker history = new CareTaker();

		editor.setText(text);
		history.add(editor.saveTextToMemento());

		int option = 0;
		String option0 = "0 - enter your text (create new version)";
		String option1 = "1 - print the current version";
		String option2 = "2 - undo (go back to the second to last version)";
		String option3 = "3 - redo (go back to the last version";
		String option4 = "4 - print history";
		String option5 = "5 - close program";

		List<Memento> mementos = history.getMementoList();

		while (option != 5) {

			System.out.println(" ");
			System.out.println("Type the number of option:");
			System.out.println(option0);
			System.out.println(option1);
			System.out.println(option2);
			System.out.println(option3);
			System.out.println(option4);
			System.out.println(option5);

			System.out.println("Your choice:");
			option = scanner.nextInt();

			switch (option) {

			case 0 -> {
				System.out.println(" ");
				System.out.println("Enter your text:");
				scanner = new Scanner(System.in);
				text = scanner.nextLine();
				editor.setText(text);
				history.add(editor.saveTextToMemento());
			}

			case 1 -> {
				System.out.println("Current version of document:");
				System.out.println("(" + "Version date: " + editor.getDate() + "):");
				System.out.println(editor.getText());
			}

			case 2 -> {
				System.out.println("Undoing...");
				if (mementos.size() - 2 >= 0) {
					editor.getTextFromMemento(history.get(mementos.size() - 2));
					System.out.println("(" + "Version date: " + editor.getDate() + "):");
					System.out.println(editor.getText());
				} else
					System.out.println("There's nothing more in history... Write something");
			}

			case 3 -> {
				System.out.println("Redoing...");
				editor.getTextFromMemento(history.get(mementos.size() - 1));
				System.out.println("(" + "Version date: " + editor.getDate() + "):");
				System.out.println(editor.getText());
			}

			case 4 -> {
				System.out.println("Changelog:");
				for (int i = 0; i < mementos.size(); i++) {
					editor.getTextFromMemento(history.get(i));
					System.out.println((i + 1) + ". (" + "Version date: " + editor.getDate() + "):");
					System.out.println(editor.getText());
					System.out.println("==========================");

				}
			}

			case 5 -> {
				System.out.println("Closing...");
			}

			default -> {
				System.out.println("Enter your text:");
				scanner = new Scanner(System.in);
				text = scanner.nextLine();
				editor.setText(text);
				history.add(editor.saveTextToMemento());
			}

			}
		}
		System.out.println("The END ¯\\_( ͡° ͜ʖ ͡°)_/¯");
	}

}
