package vo;

/* People DB ���� ���� �޾� �����ϰ�, View �� �����ִ� �Ű�ü ������ �մϴ�. */
public class People {
	
	private String strID;
	private String strName;
	private String strAge;
	private String strDati;
	
	
	public People(String strID, String strName, String strAge, String strDati) {
		this.strID = strID;
		this.strName = strName;
		this.strAge = strAge;
		this.strDati = strDati;
	}
	
	public String getStrID() {
		return strID;
	}
	public void setStrID(String strID) {
		this.strID = strID;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public String getStrAge() {
		return strAge;
	}
	public void setStrAge(String strAge) {
		this.strAge = strAge;
	}
	public String getStrDati() {
		return strDati;
	}
	public void setStrDati(String strDati) {
		this.strDati = strDati;
	}

	@Override
	public String toString() {
		return "People [strID=" + strID + ", strName=" + strName + ", strAge="
				+ strAge + ", strDati=" + strDati + "]";
	}
	

}