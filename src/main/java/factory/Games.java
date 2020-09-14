package factory;

/**
 * Created by randy on 2019-12-10.
 */
public class Games {
	public static void main(String[] args) {
		playGame(Checker.gameFactory);
	}

	public static void playGame(GameFactory gameFactory) {
		Game game = gameFactory.getGame();
		while (game.move());
	}
}

interface Game {
	boolean move();
}

interface GameFactory {
	Game getGame();
}

class Checker implements Game {
	private int moved;
	private static final int MOVE_LIMIT = 3;

	private Checker(){}

	public static GameFactory gameFactory = new GameFactory() {
		@Override
		public Game getGame() {
			return new Checker();
		}
	};

	@Override
	public boolean move() {
		System.out.println("Checkou move:" + moved);
		return ++moved != MOVE_LIMIT;
	}
}
