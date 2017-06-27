package prog2.testat;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RehaKursTest {

	RehaKurs rehaKurs;

	@Before
	public void setup() {
		rehaKurs = new RehaKurs();
	}

	@Test
	public void testHinzufuegen() {
		rehaKurs.hinzufuegen("Maxi", "M�ller", 28);
		rehaKurs.hinzufuegen("H�nsel", "Waldmann", 17);

		assertEquals("Maxi", rehaKurs.gibTeilnehmer(1).getVorname());
		assertEquals("M�ller", rehaKurs.gibTeilnehmer(1).getNachname());
		assertEquals(28, rehaKurs.gibTeilnehmer(1).getAlter());

		assertEquals("H�nsel", rehaKurs.gibTeilnehmer(2).getVorname());
		assertEquals("Waldmann", rehaKurs.gibTeilnehmer(2).getNachname());
		assertEquals(17, rehaKurs.gibTeilnehmer(2).getAlter());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAlterUnter0() {
		rehaKurs.hinzufuegen("Maxi", "M�ller", -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAlterUeber130() {
		rehaKurs.hinzufuegen("Maxi", "M�ller", 131);
	}

	@Test
	public void testAnzahlUnter18() {
		rehaKurs.hinzufuegen("Maxi", "M�ller", 28);
		rehaKurs.hinzufuegen("H�nsel", "Waldmann", 17);

		assertEquals(1, rehaKurs.unter18());
	}

	@Test
	public void testTeilnehmerMinMaxAlter() {
		rehaKurs.hinzufuegen("Maxi", "M�ller", 28);
		rehaKurs.hinzufuegen("H�nsel", "Waldmann", 17);
		rehaKurs.hinzufuegen("Schorch", "Gruber", 65);

		List<Teilnehmer> teilnehmerListeMinMaxAlter = rehaKurs.getTeilnehmerByAlter(20, 30);

		assertEquals(1, teilnehmerListeMinMaxAlter.size());
		assertEquals("Maxi", teilnehmerListeMinMaxAlter.get(0).getVorname());
		assertEquals("M�ller", teilnehmerListeMinMaxAlter.get(0).getNachname());
		assertEquals(28, teilnehmerListeMinMaxAlter.get(0).getAlter());

	}

}
