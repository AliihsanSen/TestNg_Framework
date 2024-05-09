package apis.paramTech.login;

import lombok.Data;

@Data
public class PayloadLoginPojo {
	private String countryCode;
	private String userGsmOrCardOrTCKN;
	private String userPassword;
	}