package pl.edu.agh.mwo.scratchbook;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Editor {

	private String text;
	private String date;

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

	public Editor(String text) {
		super();
		this.text = text;
		this.date = formatter.format(LocalDateTime.now());
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public Memento saveTextToMemento() {
		return new Memento(this.text, formatter.format(LocalDateTime.now()));
	}

	public void getTextFromMemento(Memento memento) {
		this.text = memento.getText();
		this.date = memento.getDate();

	}

}
