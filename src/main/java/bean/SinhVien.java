package bean;

public class SinhVien {
	
	private int id;
	private String hotenString;
	private String diachiString;
	
	public SinhVien()
	{
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHotenString() {
		return hotenString;
	}
	public void setHotenString(String hotenString) {
		this.hotenString = hotenString;
	}
	public String getDiachiString() {
		return diachiString;
	}
	public void setDiachiString(String diachiString) {
		this.diachiString = diachiString;
	}
	
	public SinhVien (int id, String hoten, String diachi)
	{
		super();
		this.id=id;
		this.hotenString=hoten;
		this.diachiString=diachi;
	}
	
	
	

}
