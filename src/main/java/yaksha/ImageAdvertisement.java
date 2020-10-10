package yaksha;

public class ImageAdvertisement extends Advertisement {
	private int inches;

	public ImageAdvertisement(int advertisementId, String priority, int noOfDays, String clientName, int inches) {
		super(advertisementId, priority, noOfDays, clientName);
		this.inches = inches;
	}

	public int getInches() {
		return inches;
	}

	public void setInches(int inches) {
		this.inches = inches;
	}

	@Override
	public float calculateAdvertisementCharge(float baseCost) {
		float baseAdvertisementCost = baseCost * super.getNoOfDays() * inches;
		float sum = 0.0f;
		sum += baseAdvertisementCost;
		if (super.getPriority().equals("high")) {
			sum += 0.1 * baseAdvertisementCost + 1000;
		} else if (super.getPriority().equals("medium")) {
			sum += 0.07 * baseAdvertisementCost + 700;
		} else {
			sum += 200;
		}
		return sum;
	}
}
