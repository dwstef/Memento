package pl.edu.agh.mwo.scratchbook;

public class Memento {

	private final String text;
	private final String date;

	public Memento(String text, String date) {
		this.text = text;
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public String getDate() {
		return date;
	}

	
}
