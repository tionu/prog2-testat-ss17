package prog2.testat;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class RehaKursTestMock {

	@Spy
	private RehaKurs rehaKurs;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testHinzufuegen() {
		rehaKurs.hinzufuegen("Maxi", "Müller", 28);
		rehaKurs.hinzufuegen("Hänsel", "Waldmann", 17);
		
		assertEquals("Maxi", rehaKurs.gibTeilnehmer(1).getVorname());
		assertEquals("Müller", rehaKurs.gibTeilnehmer(1).getNachname());
		assertEquals(28, rehaKurs.gibTeilnehmer(1).getAlter());
		
		assertEquals("Hänsel", rehaKurs.gibTeilnehmer(2).getVorname());
		assertEquals("Waldmann", rehaKurs.gibTeilnehmer(2).getNachname());
		assertEquals(17, rehaKurs.gibTeilnehmer(2).getAlter());
		
		InOrder orderRehaKurs = inOrder(rehaKurs);
		orderRehaKurs.verify(rehaKurs).hinzufuegen("Maxi", "Müller", 28);
		orderRehaKurs.verify(rehaKurs).hinzufuegen("Hänsel", "Waldmann", 17);
		verify(rehaKurs, never()).unter18();
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAlterUnter0() {
		rehaKurs.hinzufuegen("Maxi", "Müller", -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAlterUeber130() {
		rehaKurs.hinzufuegen("Maxi", "Müller", 131);
	}

	@Test
	public void testAnzahlUnter18() {
		rehaKurs.hinzufuegen("Maxi", "Müller", 28);
		rehaKurs.hinzufuegen("Hänsel", "Waldmann", 17);

		assertEquals(1, rehaKurs.unter18());
	}

	@Test 
	public void testTeilnehmerMinMaxAlter() {
		rehaKurs.hinzufuegen("Maxi", "Müller", 28);
		rehaKurs.hinzufuegen("Hänsel", "Waldmann", 17);
		rehaKurs.hinzufuegen("Schorch", "Gruber", 65);

		List<Teilnehmer> teilnehmerListeMinMaxAlter = rehaKurs.getTeilnehmerByAlter(20, 30);

		assertEquals(1, teilnehmerListeMinMaxAlter.size());
		assertEquals("Maxi", teilnehmerListeMinMaxAlter.get(0).getVorname());
		assertEquals("Müller", teilnehmerListeMinMaxAlter.get(0).getNachname());
		assertEquals(28, teilnehmerListeMinMaxAlter.get(0).getAlter());
		
		verify(rehaKurs, times(1)).getTeilnehmerByAlter(anyInt(), anyInt());

	}

}
