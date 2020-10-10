package yaksha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class MainClass {

	public static void main(String[] args)
			throws NumberFormatException, IOException, SQLException, ClassNotFoundException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int advertisementId;
		String priority;
		int noOfDays;
		String clientName;
		Connection con = DB.getConnection();
		BonBonPublishing bbp = new BonBonPublishing();
		System.out.println("Enter the advertisement id");
		advertisementId = Integer.parseInt(br.readLine());
		System.out.println("Enter the priority (high / medium / low)");
		priority = br.readLine();
		System.out.println("Enter the no of days advertisement is published");
		noOfDays = Integer.parseInt(br.readLine());
		System.out.println("Enter the client name");
		clientName = br.readLine();
		System.out.println("Enter the type of Advertisement (video/image/text)");
		String str = br.readLine();
		if (str.equals("video")) {
			System.out.println("Enter the duration in minutes");
			int duration = Integer.parseInt(br.readLine());
			Advertisement obj = new VideoAdvertisement(advertisementId, priority, noOfDays, clientName, duration);
			System.out.println("Enter the base cost");
			float baseCost = Float.parseFloat(br.readLine());
			System.out.println("The Advertisement cost is " + obj.calculateAdvertisementCharge(baseCost));
			Advertisement advertisement = new VideoAdvertisement(advertisementId, priority, noOfDays, clientName,
					duration);
			String query = "insert into advertisement values (?,?,?,?)";
			PreparedStatement pStatement = con.prepareStatement(query);
			pStatement.setInt(1, advertisement.getAdvertisementId());
			pStatement.setString(2, advertisement.getPriority());
			pStatement.setInt(3, advertisement.getNoOfDays());
			pStatement.setString(4, advertisement.getClientName());
			pStatement.executeUpdate();
			bbp.viewAdvertisementDetails();
		} else if (str.equals("image")) {
			System.out.println("Enter the number of inches");
			int inches = Integer.parseInt(br.readLine());
			Advertisement obj = new VideoAdvertisement(advertisementId, priority, noOfDays, clientName, inches);
			System.out.println("Enter the base cost");
			float baseCost = Float.parseFloat(br.readLine());
			System.out.println("The Advertisement cost is " + obj.calculateAdvertisementCharge(baseCost));
			Advertisement advertisement = new ImageAdvertisement(advertisementId, priority, noOfDays, clientName,
					inches);
			String query = "insert into advertisement values (?,?,?,?)";
			PreparedStatement pStatement = con.prepareStatement(query);
			pStatement.setInt(1, advertisement.getAdvertisementId());
			pStatement.setString(2, advertisement.getPriority());
			pStatement.setInt(3, advertisement.getNoOfDays());
			pStatement.setString(4, advertisement.getClientName());
			pStatement.executeUpdate();
			bbp.viewAdvertisementDetails();
		} else {
			System.out.println("Enter the number of characters");
			int noOfCharacters = Integer.parseInt(br.readLine());
			Advertisement obj = new VideoAdvertisement(advertisementId, priority, noOfDays, clientName, noOfCharacters);
			System.out.println("Enter the base cost");
			float baseCost = Float.parseFloat(br.readLine());
			System.out.println("The Advertisement cost is " + obj.calculateAdvertisementCharge(baseCost));
			Advertisement advertisement = new TextAdvertisement(advertisementId, priority, noOfDays, clientName,
					noOfCharacters);
			String query = "insert into advertisement values (?,?,?,?)";
			PreparedStatement pStatement = con.prepareStatement(query);
			pStatement.setInt(1, advertisement.getAdvertisementId());
			pStatement.setString(2, advertisement.getPriority());
			pStatement.setInt(3, advertisement.getNoOfDays());
			pStatement.setString(4, advertisement.getClientName());
			pStatement.executeUpdate();
			bbp.viewAdvertisementDetails();
		}
	}
}
