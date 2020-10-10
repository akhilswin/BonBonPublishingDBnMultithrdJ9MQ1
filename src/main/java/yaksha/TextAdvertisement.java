package yaksha;

public class TextAdvertisement extends Advertisement {
	private int noOfCharacters;

	public TextAdvertisement(int advertisementId, String priority, int noOfDays, String clientName,
			int noOfCharacters) {
		super(advertisementId, priority, noOfDays, clientName);
		this.noOfCharacters = noOfCharacters;
	}

	public int getNoOfCharacters() {
		return noOfCharacters;
	}

	public void setNoOfCharacters(int noOfCharacters) {
		this.noOfCharacters = noOfCharacters;
	}

	@Override
	public float calculateAdvertisementCharge(float baseCost) {
		float baseAdvertisementCost = baseCost * super.getNoOfDays() * noOfCharacters;
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
