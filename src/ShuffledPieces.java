import java.util.*;

public class ShuffledPieces {
	private ArrayList<Animal> pieces;
	
	public ShuffledPieces() {
		pieces = new ArrayList<Animal>();
		
		pieces.add(new Mouse(true));
		pieces.add(new Cat(true));
		pieces.add(new Wolf(true));
		pieces.add(new Dog(true));
		pieces.add(new Leopard(true));
		pieces.add(new Tiger(true));
		pieces.add(new Lion(true));
		pieces.add(new Elephant(true));
		
		Collections.shuffle(pieces);
		
		for (int i = 0; i < pieces.size(); i++) {
			System.out.println(pieces.get(i));
		}
	}
	
	public String getAnimalType(Animal a) {
		if(a instanceof Mouse) {
			return "Mouse";
		}else if(a instanceof Cat) {
			return "Cat";
		}else if(a instanceof Wolf) {
			return "Wolf";
		}else if(a instanceof Dog) {
			return "Dog";
		}else if(a instanceof Leopard) {
			return "Leopard";
		}else if(a instanceof Tiger) {
			return "Tiger";
		}else if(a instanceof Lion) {
			return "Lion";
		}else if(a instanceof Elephant) {
			return "Elephant";
		}
		
		return null;
	}
	
	public Animal getChosenPiece(int i) {
		return pieces.get(i);
	}
	
	public ArrayList<Animal> getPieces(){
		return pieces;
	}

	public boolean decideFirstMove(Animal p1, Animal p2) {
		if(p1.getRANK() > p2.getRANK())
			return true;
		
		return false;
	}
}
