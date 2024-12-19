public class PhoneDirectory implements Comparable<PhoneDirectory>{
	private String name, phoneNum;
	public int compareTo(PhoneDirectory x) {
		return name.compareTo(x.name);
	}	
	public PhoneDirectory(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
	}	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String toString() {
		return name +": " + phoneNum;
	}
}
