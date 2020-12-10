package reactive_data.projections;

public interface PersonSummary {

	String getName();
	AddressSummary getAddress();

	interface AddressSummary {
		String getCity();
	}
}