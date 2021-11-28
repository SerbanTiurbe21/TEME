
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
	}

}
