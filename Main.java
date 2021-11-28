import java.util.ArrayList;

class Membru{
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

abstract class Echipaa{
	private String nume;
	private int numarMaximMembri;
	protected Membru lider;
	
	public Echipaa(String name, int nr) {
		this.nume = name;
		this.numarMaximMembri = nr;
	}
	
	protected ArrayList<Membru> membri = new ArrayList<Membru>(numarMaximMembri);
	
	public boolean addMember(Membru member) {
		if(membri.size() == numarMaximMembri)
			return false;
		else {
			membri.add(member);
			return true;
		}
	}
	
	public boolean setLeader(Membru liderNou) {
		if(liderNou.getAniExperienta() >= 5) {
			lider = liderNou;
			return true;
		}
		return false;
	}
	
	public Membru getLider() {
		return this.lider;
	}
	
	public int getNumarMaximMembri() {
		return this.numarMaximMembri;
	}
	
	public Membru removeMember(Membru member) {
		for(int i=0;i<membri.size();i++) {
			if(member.equals(membri.get(i))) {
				Membru removed = membri.remove(i);
				return removed;
			}
		}
		return null;
	}
	
	public void setNumarMaximMembri(int nr, Membru mem) {
		if(this.getLider().equals(mem))
			this.numarMaximMembri = nr;
		else {
			System.out.println("Doar liderul are voie sa modifice numarul!");
		}
		if(nr == 0) {
			membri.clear();
			this.lider = null;
		}
	}
	
	public void setNume(String nume, Membru mem) {
		if(this.getLider().equals(mem))
			this.nume = nume;
		else {
			System.out.println("Doar liderul are voie sa modifice numele!");
		}
	}
	
	public abstract double getCost();
	public String toString() {
		String tempp = "";
		if(this.getLider() == null) {
			for(int i=0;i<membri.size();i++) {
				tempp += membri.get(i).toString() + " ";
			}
			return tempp;
		}
		
		String temp = "Numele:" + this.nume + "\nLider echipa:<" + lider.toString() +">"+ " Membri:";
		for(int i=0;i<membri.size();i++) {
			temp += membri.get(i).toString() + " ";
		}
		return temp;
	}
}

class DevTeam extends Echipaa{

	public DevTeam(String name, int nr) {
		super(name, nr);
	}
	
	@Override
	public double getCost() {
		double suma = 0;
		for(int i=0;i<membri.size();i++) {
			if(membri.get(i).equals(lider)) {
				suma += (2500+250*lider.getAniExperienta());
			}
			else {
				if(membri.get(i).getAniExperienta() <2) {
					suma += (1500+0*membri.get(i).getAniExperienta());
				}
				else {
					if(membri.get(i).getAniExperienta() >=2 && membri.get(i).getAniExperienta() <=5) {
						suma += (1500+0.25*membri.get(i).getAniExperienta());
					}
					else {
						if(membri.get(i).getAniExperienta() > 5) {
							suma += (1500+0.5*membri.get(i).getAniExperienta());
						}
					}
				}
			}
		}
		return suma;
	}
}

class HR extends Echipaa{
	public HR(String name, int nr) {
		super(name, nr);
	}

	@Override
	public double getCost() {
		double suma = 0;
		for(int i=0;i<membri.size();i++) {
			if(membri.get(i).equals(lider)) {
				suma += (1350+300*lider.getAniExperienta());
			}
			else {
				if(membri.get(i).getAniExperienta() <2) {
					suma += (1000+0*membri.get(i).getAniExperienta());
				}
				else {
					if(membri.get(i).getAniExperienta() >=2 && membri.get(i).getAniExperienta() <=5) {
						suma += (1000+0.25*membri.get(i).getAniExperienta());
					}
					else {
						if(membri.get(i).getAniExperienta() > 5) {
							suma += (1000+0.5*membri.get(i).getAniExperienta());
						}
					}
				}
			}
		}
		return suma;
	}
}

public class Main {

	public static void main(String[] args) {
		DevTeam d1 = new DevTeam("Java",12);
		Membru m1 = new Membru("Tiurbe","Serban",20,2000,3);
		Membru m2 = new Membru("Dusan","Szasz",19,1500,2);
		Membru m3 = new Membru("Iulian","Toderesc",25,3000,5);
		Membru m4 = new Membru("Barna","Alin",22,4500,4);
		Membru m5 = new Membru("Daniel","Galea",21,1700,2);
		d1.addMember(m1);
		d1.addMember(m2);
		d1.addMember(m3);
		d1.addMember(m4);
		d1.addMember(m5);
		//d1.setLeader(m1); //aici adaug liderul care nu este eligil -> eroare
		d1.setLeader(m3); //aici adaug liderul care este eligil -> works just fine
		System.out.println("Echipa DEVTEAM" + '\n' + d1);
		System.out.println("Costul:"+d1.getCost());
		System.out.println("Membrul sters: "+d1.removeMember(m5));//aici sterg un membru
		System.out.println("Echipa fara un membru:" +'\n'+ d1); //afisez din nou echipa
		
		HR h1 = new HR("Oameni faini",10);
		Membru m6 = new Membru("Andreea","Neag",30,3000,4);
		Membru m7 = new Membru("Bianca","Panea",45,4500,20);
		Membru m8 = new Membru("Denisa","Corneanu",32,2500,18);
		Membru m9 = new Membru("Ana","Chirodea",30,3200,15);
		Membru m10 = new Membru("Carla","Porumb",50,5000,20);
		h1.addMember(m6);
		h1.addMember(m7);
		h1.addMember(m8);
		h1.addMember(m9);
		h1.addMember(m10);
		h1.setLeader(m10); //aici am adaugat doar liderul este eligil, cazul pt cel care nu e eligil e evidentiat mai sus
		System.out.println("Echipa HR"+'\n'+h1);
		System.out.println("Costul:"+h1.getCost());
		System.out.println("Echipa fara un membru:"+h1.removeMember(m6) + "\n" + h1); //elimin un membru ca apoi sa verific daca scade costul
		System.out.println("Costul fara un membru:"+h1.getCost());
		
		/*
		DevTeam d1 = new DevTeam("Java",12);
		Membru m3 = new Membru("Iulian","Toderesc",25,3000,5);
		Membru m2 = new Membru("Dusan","Szasz",19,1500,2);
		d1.addMember(m3);
		d1.addMember(m2);
		d1.setLeader(m3);
		System.out.println(d1.getLider());
		d1.setNume("lol", m3);
		//d1.setNumarMaximMembri(0, m3);
		System.out.println(d1);
		*/
	}
}