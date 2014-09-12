package br.unb.unbomber.entity;


public class Character extends Entity {

	int playerNumber;	// Some way to identify the player - this could also be a player name string
	float maxSpeed;
	Direction facingDirection = Direction.DOWN;
	BombDropper bombDropper;
	
		
	public Character(){
		 bombDropper = new BombDropper(this);
	}
	
	
	public Character(int charBombRange){
		 bombDropper = new BombDropper(this);
		 
		 bombDropper.setBombRange(charBombRange);
	}
	
	public final void dropBomb(){
		bombDropper.drop();
	}
	
	public BombDropper getBombDropper() {
		return bombDropper;
	}
}
