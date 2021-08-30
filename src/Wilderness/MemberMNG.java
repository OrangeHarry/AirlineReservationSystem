package Wilderness;

public class MemberMNG {
	private String ID = null;
	private String PW = null;
	private String Name = null;
	private String isMan = null;
	private String birth = null;
	private String email = null;
	private int price = 0; // 최종금액

	public TicketInformation getTicketinfo() {
		return ticketinfo;
	}

	public void setTicketinfo(TicketInformation ticketinfo) {
		this.ticketinfo = ticketinfo;
	}

	TicketInformation ticketinfo = null; // 티켓 정보

	private long cardNum = 0; // 카드번호(-없이 숫자만 입력하세요)
	private int Validity = 0; // 유효기간 (mmYY)
	private int Installment = 0;// 할부
	private int cvcNum = 0; // CVC넘버
	private String cardCompany = null;

	public MemberMNG(String iD, String pW, String name) {
		this.ID = iD;
		this.PW = pW;
		this.Name = name;
		this.ticketinfo = new TicketInformation();
	}

	public MemberMNG(String iD, String pW, String name, String isMan, String birth, String email) {
		this(iD, pW, name);
		this.isMan = isMan;
		this.birth = birth;
		this.email = email;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public long getCardNum() {
		return cardNum;
	}

	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}

	public int getValidity() {
		return Validity;
	}

	public void setValidity(int validity) {
		Validity = validity;
	}

	public int getInstallment() {
		return Installment;
	}

	public void setInstallment(int installment) {
		Installment = installment;
	}

	public int getCvcNum() {
		return cvcNum;
	}

	public void setCvcNum(int cvcNum) {
		this.cvcNum = cvcNum;
	}

	public String getCardCompany() {
		return cardCompany;
	}

	public void setCardCompany(String cardCompany) {

		this.cardCompany = cardCompany;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getIsMan() {
		return isMan;
	}

	public void setIsMan(String isMan) {
		this.isMan = isMan;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getID() {
		return ID;
	}

	public String getPW() {
		return PW;
	}

	public String getName() {
		return Name;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "ID : " + ID + " PW : " + PW + " Name : " + Name;
	}
}