package hibernate;

public class UpdatePaymentExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 0) Create a new UpdatePaymentExample
		// 1) Query the new payment we just created by its id
		// 2) change the check number and the amount 
		// 3) update the payment
		
		PaymentDAO paymentDao = new PaymentDAO();
		
		Payment p = paymentDao.findById(1);
//		
//		p.setAmount(99999.99);
//		p.setCheckNumber("4444444");
//		
//		paymentDao.update(p);
		
	}

}
