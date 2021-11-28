
public class DevTeam extends Echipa{
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
