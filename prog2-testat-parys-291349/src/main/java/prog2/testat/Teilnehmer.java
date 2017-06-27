package prog2.testat;

public class Teilnehmer {

	private String vorname;
	private String nachname;
	private int alter;

	private Teilnehmer(TeilnehmerBuilder teilnehmerBuilder) {
		this.vorname = teilnehmerBuilder.vorname;
		this.nachname = teilnehmerBuilder.nachname;
		this.alter = teilnehmerBuilder.alter;
	}

	public static class TeilnehmerBuilder {
		private String vorname;
		private String nachname;
		private int alter;

		public TeilnehmerBuilder vorname(String vorname) {
			this.vorname = vorname;
			return (this);
		}

		public TeilnehmerBuilder nachname(String nachname) {
			this.nachname = nachname;
			return (this);
		}

		public TeilnehmerBuilder alter(int alter) {
			this.alter = alter;
			return (this);
		}

		public Teilnehmer build() {
			return (new Teilnehmer(this));
		}
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public int getAlter() {
		return alter;
	}

}
