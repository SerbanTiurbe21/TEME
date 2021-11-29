import java.util.ArrayList;

abstract class Echipa {
	private String nume;
	private int numarMaximMembri;
	protected Membru lider;
	
	public Echipa(String name, int nr) {
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
			if(nr == 0) {
				membri.clear();
				this.lider = null;
			}
			else {
				for(int i=membri.size()-1;i>=nr;i--) {
					membri.remove(i);
				}
				this.lider = membri.get(0);
			}
		else {
			System.out.println("Doar liderul are voie sa modifice numarul!");
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
		String tempp = "Numele: " + this.nume + "\nMembri:";
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
