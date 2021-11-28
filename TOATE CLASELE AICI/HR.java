
public class HR extends Echipa{
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
