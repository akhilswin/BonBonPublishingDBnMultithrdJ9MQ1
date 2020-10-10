package yaksha;

public class VideoAdvertisement extends Advertisement {
	private int duration;

	public VideoAdvertisement(int advertisementId, String priority, int noOfDays, String clientName, int duration) {
		super(advertisementId, priority, noOfDays, clientName);
		this.duration = duration;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public float calculateAdvertisementCharge(float baseCost) {
		float baseAdvertisementCost = baseCost * super.getNoOfDays() * duration;
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
