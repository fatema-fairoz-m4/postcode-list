package postcode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.Address;
import io.spring.guides.gs_producing_web_service.AddressList;
import io.spring.guides.gs_producing_web_service.GetAddressRequest;

@Endpoint
public class AddressEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private AddressRepository addressRepository;

	@Autowired
	public AddressEndpoint(AddressRepository countryRepository) {
		this.addressRepository = countryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAddressRequest")
	@ResponsePayload
	public AddressList getCountry(@RequestPayload GetAddressRequest request) {
		AddressList response = new AddressList();
		List<Address> addresses = response.getAddress();
		addresses.addAll(addressRepository.findAddress(request.getPostcode()));

		return response;
	}
}