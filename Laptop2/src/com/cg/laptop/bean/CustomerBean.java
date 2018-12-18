package com.cg.laptop.bean;

public class CustomerBean {
	
	    private String customerId;
		private String customerName;
		private String phoneNumber;
		private String address;
		private String mailId;
		private double laptopAmount;
		private String bookingDate;
		private String laptopId;
		//private String laptopModelName;
		
		
		
		/*public String getLaptopModelName() {
			return laptopModelName;
		}
		public void setLaptopModelName(String laptopModelName) {
			this.laptopModelName = laptopModelName;
		}*/
		public String getMailId() {
			return mailId;
		}
		public void setMailId(String mailId) {
			this.mailId = mailId;
		}
		public String getLaptopId() {
			return laptopId;
		}
		public void setLaptopId(String laptopId) {
			this.laptopId = laptopId;
		}
		public String getCustomerId() {
			return customerId;
		}
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public double getLaptopAmount() {
			return laptopAmount;
		}
		public void setLaptopAmount(double laptopAmount) {
			this.laptopAmount = laptopAmount;
		}
		public String getBookingDate() {
			return bookingDate;
		}
		public void setBookingDate(String bookingDate) {
			this.bookingDate = bookingDate;
		}
		@Override
		public String toString() {
			return "CustomerBean [customerId=" + customerId + ", customerName=" + customerName + ", phoneNumber="
					+ phoneNumber + ", address=" + address + ", laptopAmount=" + laptopAmount + ", bookingDate="
					+ bookingDate +  "]";
		}
		
		
		
		
	}


