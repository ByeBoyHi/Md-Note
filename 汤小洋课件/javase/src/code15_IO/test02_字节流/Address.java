package code15_IO.test02_字节流;

import java.io.Serializable;

public class Address implements Serializable{
	private String province;
	private String city;

	public Address() {
		super();
	}

	public Address(String province, String city) {
		super();
		this.province = province;
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [province=" + province + ", city=" + city + "]";
	}

	
}
