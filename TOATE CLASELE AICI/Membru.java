
public class Membru {
	private String nume,prenume;
	private int varsta,aniExp;
	private double salariu;
	private Membru lider;
	
	public Membru(String nume, String prenume, int varsta, double salariu, int ani) {
		this.nume = nume;
		this.prenume = prenume;
		this.varsta = varsta;
		this.salariu = salariu;
		this.aniExp = ani;
	}
	
	public int getAniExperienta() {
		return this.aniExp;
	}
	
	public String toString() {
		return this.nume + " - " + this.prenume;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Membru) {
			Membru mem = (Membru)obj;
			return (mem.nume == this.nume && mem.prenume == this.prenume &&
					mem.varsta == this.varsta && mem.aniExp == this.aniExp &&
					mem.salariu == this.salariu);
		}
		else {
			return false;
		}
	}
}
