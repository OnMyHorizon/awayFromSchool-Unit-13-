package finalproject;

public class wishlistCars {
	private boolean [] values;
	public wishlistCars() {
		
	}
 	public wishlistCars(user u) {
 		values = new boolean[8];
 		updateList(u);
	}
 	public boolean[] getList() {
 		return values;
 	}
	public void updateList(user u) {
		if (!u.get1()) {
			values[0] = true;
		}else {
			values[0] = false;
		}
		if (!u.get2()) {
			values[1] = true;
		}else {
			values[1] = false;
		}
		if (!u.get3()) {
			values[2] = true;
		}else {
			values[2] = false;
		}
		if (!u.get4()) {
			values[3] = true;
		}else {
			values[3] = false;
		}
		if (!u.get5()) {
			values[4] = true;
		}else {
			values[4] = false;
		}
		if (!u.get6()) {
			values[5] = true;
		}else {
			values[5] = false;
		}
		if (!u.get7()) {
			values[6] = true;
		}else {
			values[6] = false;
		}
		if (!u.get8()) {
			values[7] = true;
		}else {
			values[7] = false;
		}
	}
}
