package com.cg.laptop.bean;

public class LaptopBean {
	
	 public String laptopModelNo;
	 public String laptopModelName;
	 public String RAM;
	 public String OS;
	 public String screen;
	 public String hardDisk;
	 public String CPU;
	 public int laptopPrice;
	 public  int quantity;
	  
	  
	  
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getLaptopPrice() {
		return laptopPrice;
	}
	public void setLaptopPrice(int laptopPrice) {
		this.laptopPrice = laptopPrice;
	}
	public String getLaptopModelNo() {
		return laptopModelNo;
	}
	public void setLaptopModelNo(String laptopModelNo) {
		this.laptopModelNo = laptopModelNo;
	}
	public String getLaptopModelName() {
		return laptopModelName;
	}
	public void setLaptopModelName(String laptopModelName) {
		this.laptopModelName = laptopModelName;
	}
	public String getRAM() {
		return RAM;
	}
	public void setRAM(String rAM) {
		RAM = rAM;
	}
	public String getOS() {
		return OS;
	}
	public void setOS(String oS) {
		OS = oS;
	}
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	public String getHardDisk() {
		return hardDisk;
	}
	public void setHardDisk(String hardDisk) {
		this.hardDisk = hardDisk;
	}
	public String getCPU() {
		return CPU;
	}
	public void setCPU(String cPU) {
		CPU = cPU;
	}
	@Override
	public String toString() {
		return "LaptopBean [laptopModelNo=" + laptopModelNo + ", laptopModelName=" + laptopModelName + ", RAM=" + RAM
				+ ", OS=" + OS + ", screen=" + screen + ", hardDisk=" + hardDisk + ", CPU=" + CPU + ", laptopPrice="
				+ laptopPrice + ",quantity="+quantity+"]"+"\n";
	}
	  
	  
	  
	  

}
