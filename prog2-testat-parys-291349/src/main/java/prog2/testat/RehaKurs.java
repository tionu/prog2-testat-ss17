package prog2.testat;

import java.util.ArrayList;
import java.util.List;

public class RehaKurs {

	private List<Teilnehmer> teilnehmerListe;

	public RehaKurs() {
		teilnehmerListe = new ArrayList<Teilnehmer>();
	}

	public int hinzufuegen(String vorname, String nachname, int alter) {

		if (alter < 0 || alter > 130) {
			throw new IllegalArgumentException("Alter des Teilnehmers ungültig: " + alter);
		}
		teilnehmerListe
				.add(new Teilnehmer.TeilnehmerBuilder().vorname(vorname).nachname(nachname).alter(alter).build());

		return teilnehmerListe.size();

	}

	public Teilnehmer gibTeilnehmer(int index) {
		return teilnehmerListe.get(index - 1);
	}

	public int unter18() {
		int count = 0;

		for (Teilnehmer teilnehmer : teilnehmerListe) {
			if (teilnehmer.getAlter() < 18) {
				count++;
			}
		}
		return count;
	}

	public List<Teilnehmer> getTeilnehmerByAlter(int minAlter, int maxAlter) {
		List<Teilnehmer> teilnehmerListeByAlter = new ArrayList<Teilnehmer>();

		for (Teilnehmer teilnehmer : teilnehmerListe) {
			if (teilnehmer.getAlter() >= minAlter && teilnehmer.getAlter() <= maxAlter) {
				teilnehmerListeByAlter.add(teilnehmer);
			}
		}

		return teilnehmerListeByAlter;
	}

}
