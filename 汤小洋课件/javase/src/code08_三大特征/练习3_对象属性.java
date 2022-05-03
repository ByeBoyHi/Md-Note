package code08_三大特征;

/*
 * 对象属性
 */
public class 练习3_对象属性 {
	public static void main(String[] args) {
		Stu stu = new Stu("s1001", "唐伯虎", 20);
		Clazz clazz = new Clazz();
		clazz.setCid(1);
		clazz.setCname("Java一班");
		clazz.setLocation("三号教室");
		stu.setClazz(clazz);

		// Address address = new Address("江苏省", "南京市", "秦淮区龙蟠中路");
		stu.setAddress(new Address("江苏省", "南京市", "秦淮区龙蟠中路"));

		System.out.println(stu.getSid());
		System.out.println(stu.getName());
		System.out.println(stu.getClazz().getCname());
		Address addr = stu.getAddress();
		System.out.println(addr.getCity());
		// System.out.println(stu.getAddress().getCity());

	}
}

/*
 * 学生类
 */
class Stu {
	private String sid;
	private String name;
	private int age;
	private Clazz clazz; // 班级信息
	private Address address; // 地址信息

	public Stu() {
		super();
	}

	public Stu(String sid, String name, int age) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}

/*
 * 班级
 */
class Clazz {
	private int cid;
	private String cname; // 班级名称
	private String location; // 所在教室

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}

/*
 * 地址
 */
class Address {
	private String province; // 省份
	private String city; // 城市
	private String district; // 区域

	public Address() {
	}

	public Address(String province, String city, String distrcit) {
		this.province = province;
		this.city = city;
		this.district = district;
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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

}
