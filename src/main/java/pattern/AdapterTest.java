package pattern;

/**
 * Created by nali on 2018/5/9.
 */
public class AdapterTest {}

interface DBSocketInterface {
	void powerWithTwoRound();
}

class DBSocket implements DBSocketInterface {

	@Override
	public void powerWithTwoRound() {
		System.out.println("power with two round !");
	}
}

interface GBSocketInterface{
	void powerWithThreeFlat();
}

class GBSocket implements GBSocketInterface{

	@Override
	public void powerWithThreeFlat() {
		System.out.println("power with three flat !");
	}
}

class SocketAdapter implements DBSocketInterface{
	private GBSocketInterface gbSocketInterface;

	public void setGbSocketInterface(GBSocketInterface gbSocketInterface){
		this.gbSocketInterface = gbSocketInterface;
	}

	@Override
	public void powerWithTwoRound() {
		gbSocketInterface.powerWithThreeFlat();
	}
}

class Hotel {
	private DBSocketInterface dbSocketInterface;

	public Hotel(DBSocketInterface dbSocketInterface){
		this.dbSocketInterface = dbSocketInterface;
	}

	public void charge(){
		dbSocketInterface.powerWithTwoRound();
	}
}

class Test{
	public static void main(String[] args) {
		GBSocketInterface gbSocketInterface = new GBSocket();
		SocketAdapter socketAdapter = new SocketAdapter();
		socketAdapter.setGbSocketInterface(gbSocketInterface);
		Hotel hotel = new Hotel(socketAdapter);
		hotel.charge();
	}
}