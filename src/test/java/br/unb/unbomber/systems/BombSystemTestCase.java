package br.unb.unbomber.systems;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.unb.unbomber.entity.Bomb;
import br.unb.unbomber.entity.Character;

public class BombSystemTestCase {

	@Before
	public void setUp() throws Exception {
		BombSystem.createInstance();
	}

	@Test
	public void dropBombTest() {
		//character should drop bomb
		Character c = new Character();
		c.getBombDropper().setPermittedSimultaneousBombs(5);
		c.dropBomb();
		
		List<Bomb> bombs = BombSystem.getInstance().getBombs();
		assertFalse(bombs.isEmpty());	
	}
	
	@Test
	public void dropBombAtSamePlaceTest() {
		//character should drop bomb into their own place
		Character c = new Character();
		c.setX(3.0d);
		c.setY(3.0d);
		c.getBombDropper().setPermittedSimultaneousBombs(5);
		c.dropBomb();
		List<Bomb> bombs = BombSystem.getInstance().getBombs();
		Bomb bomb = bombs.get(0);
		assertTrue(bomb.getX() == 3.0d);
	}
	
	@Test
	public void bombRangeTest() {
		int bombRange = 8;
		
		Character c = new Character(bombRange);
		c.getBombDropper().setPermittedSimultaneousBombs(3);
		
		BombSystem.getInstance().dropBomb(c.getBombDropper());
		List<Bomb> bombs = BombSystem.getInstance().getBombs();
		assertTrue(bombs.get(0).getBombRange() == bombRange);
		
	}
	
	@Test
	public void permittedSimultaneousBombsTrue() {
		int permittedSimultaneousBombs = 6;
		
		Character c = new Character();
		c.getBombDropper().setPermittedSimultaneousBombs(permittedSimultaneousBombs);
		
		BombSystem.getInstance().dropBomb(c.getBombDropper());
		
		assertTrue(BombSystem.getInstance().getPermittedSimultaneousBombs() < permittedSimultaneousBombs);
		
	}
	
	@Test
	public void permittedSimultaneousBombsFalse() {
		int permittedSimultaneousBombs = 6;
		
		Character c = new Character();
		c.getBombDropper().setPermittedSimultaneousBombs(permittedSimultaneousBombs);
		
		BombSystem.getInstance().dropBomb(c.getBombDropper());
		
		assertFalse(BombSystem.getInstance().getPermittedSimultaneousBombs() > permittedSimultaneousBombs);
		
	}

}
