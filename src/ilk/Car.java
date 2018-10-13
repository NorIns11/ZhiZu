package ilk;

public class Car {
	public static final int PAGE_SIZE = 12;
	// id
	private String carID;
	// 品牌
	private String brand;
	// 型号
	private String type;
	// 状态
	private Boolean status;
	// 价格
	private float price;
	public String getCarID() {
	return carID;
	}
	public void setCarID(String carID) {
	this.carID = carID;
	}
	public String getBrand() {
	return brand;
	}
	public void setBrand(String brand) {
	this.brand = brand;
	}
	public String getType() {
	return type;
	}
	public void setType(String type) {
	this.type = type;
	}
	public Boolean getStatus() {
	return status;
	}
	public void setStatus(Boolean status) {
	this.status = status;
	}
	public float getPrice() {
	return price;
	}
	public void setPrice(float price) {
	this.price = price;
	}
	public String getStatusToString(){
		String i = null;
		if(status==true){
			i="空闲";
			return i;
		}
		else{
			i="占用";
			return i;
		}
	}

}
