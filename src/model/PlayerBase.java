package model;

import java.io.Serializable;
import java.util.LinkedList;

public abstract class PlayerBase implements Serializable {
	private static final long serialVersionUID = 6054095141575886689L;

	public LinkedList<Hand> hand = new LinkedList<Hand>();

	public abstract void draw(Deck deck);

}
