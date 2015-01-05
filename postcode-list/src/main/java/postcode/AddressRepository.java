package postcode;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Address;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class AddressRepository {
	private static final List<Address> addresses = new ArrayList<Address>();

	@PostConstruct
	public void initData() {
		Address spain = new Address();
		spain.setPostcode("WH 014");
		spain.setTown("Town1");
		Country value = new Country();
		value.setValue("Spain");
		value.setCode("CODE_Spain");
		spain.setCountry(value);

		addresses.add(spain);

		Address poland = new Address();
		poland.setPostcode("WH 014");
		poland.setTown("Town2");
		Country value1 = new Country();
		value1.setValue("Poland");
		poland.setCountry(value1);

		addresses.add(poland);

		Address uk = new Address();
		uk.setPostcode("WJ 112");
		uk.setTown("Town3");
		Country value2 = new Country();
		value2.setValue("UK");
		poland.setCountry(value2);

		addresses.add(uk);
	}

	public List<Address> findAddress(String country) {
		Assert.notNull(country);

		List<Address> add = new ArrayList<Address>();

		for (Address address : addresses) {
			if (address.getCountry() == null || address.getCountry().getValue() == null)
				continue;
			if (country.equals(address.getPostcode())) {
				add.add(address);
			}
		}

		return add;
	}
}