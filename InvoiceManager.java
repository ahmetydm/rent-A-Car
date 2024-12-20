import Classrooms.Customer;
import Classrooms.Invoice;

import java.time.LocalDate;
import java.util.ArrayList;

public class InvoiceManager {


        public void Add(int rentalId , int userId , int customerId , Double totalPrice , String isPayed) {

            if (isPayed == "Ödendi") {
                Main.invoices.add(new Invoice(Main.invoices.size() + 1, rentalId , customerId , userId,
                        totalPrice , totalPrice * 0.20, LocalDate.now(), LocalDate.now(), isPayed));
                System.out.println("İşleminiz tamamlandı");

            }
        }


    public void Listing(Invoice invoice) {
        String customername="";
        String username="";
        if(invoice.getCustomer()>=0) {
            for (Customer customer : Main.customers) {
                if (customer.getPersonID()== invoice.getInvoiceId()) {
                    customername=customer.getName();
                }
            }
        }

        System.out.println(
                invoice.getInvoiceId() + " Kiralama numarası" + invoice.getRental() + " " + customername + " " + username + " " + invoice.getTotalPrice()+
                        " " + invoice.getTaxAmount() + " " + invoice.getIssueDate() + " " + invoice.getInvoiceStatus() + " " + invoice.getPaymentDate());
    }

            public static void Pay(ArrayList<Invoice>invoices , int payId){
                for (Invoice invoice : invoices)
                {
                    if(invoice.getInvoiceId()==payId) {
                        invoice.setPaymentDate(LocalDate.now());
                        invoice.setInvoiceStatus("Ödendi");
                    }
                }
            }

}
