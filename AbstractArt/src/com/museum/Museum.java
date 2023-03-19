package com.museum;

import java.util.ArrayList;
import java.util.Collections;

public class Museum {

	public static void main(String[] args) {
		ArrayList<Art> museum = new ArrayList<> ();
		museum.add(new Painting ("Sun Flower","Van Gogh","It Expensive","Oil"));
		museum.add(new Painting ("The Scream","Edward Munch","It Cool","oil"));
		museum.add(new Painting ("Mona Lisa","Da Vinci","She Smiling","oil"));
		museum.add(new Sculpture("David","Michaelangelo","He posing","marble"));
		museum.add(new Sculpture("The Thinker","Rodin","He Mediating","marble"));
		
		
		Collections.shuffle(museum);
		for(Art artwork: museum) {
			artwork.viewArt();
		}
	}

}
