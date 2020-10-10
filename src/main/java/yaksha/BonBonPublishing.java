package yaksha;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BonBonPublishing {
	public ArrayList<Advertisement> viewAdvertisementDetails() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Advertisement> flightList = new ArrayList<Advertisement>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DB.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from advertisement");
			while (rs.next()) {
				int advertisementId = rs.getInt(1);
				String priority = rs.getString(2);
				int noOfDays = rs.getInt(3);
				String clientName = rs.getString(4);
				System.out.println("Advertisement Details \n");
				System.out.println(advertisementId + " " + priority + " " + noOfDays + " " + clientName);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return flightList;
	}
}
