/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

/**
 *
 * @author ma7mo
 */

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author usfng
 */
public class Database {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> companyAdmin;
    private MongoCollection<Document> ShipmentAdmin;
    private MongoCollection<Document> storeAdmin;
    private MongoCollection<Document> customer;
    private MongoCollection<Document> employee;
    private MongoCollection<Document> Transaction;
    private MongoCollection<Document> Product;
    private MongoCollection<Document> Shipment;
    private MongoCollection<Document> Inventory;
    private Gson gson = new Gson();

    public Database() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("BUE"); // Database name
        companyAdmin = database.getCollection("companyadmin");// Collection name
        storeAdmin = database.getCollection("storeadmin");
        ShipmentAdmin = database.getCollection("shipmentadmin");
        customer = database.getCollection("customer");
        employee = database.getCollection("employee");
        Transaction = database.getCollection("Transaction");
        Product = database.getCollection("Product");
        Shipment = database.getCollection("shipment");
        Inventory = database.getCollection("Inventory");
                
    
    }
    public void insertCompanyAdmin(Company_admin s) {
        companyAdmin.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Company_admin inserted.");
    }

    public void deleteCompanyAdmin(Company_admin email) {
        boolean result = companyAdmin.deleteOne(Filters.eq("email", email)).wasAcknowledged();
        if (result) {
            System.out.println("Company_admin Deleted.");
        } else {
            System.out.println("Company_admin wasn't found.");
        }
    }
     public void insertStoreadmin(Store_admin s) {
        storeAdmin.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Store_admin inserted.");
    }

    public void deleteStoreadmin(int id) {
        boolean result = storeAdmin.deleteOne(Filters.eq("id", id)).wasAcknowledged();
        if (result) {
            System.out.println("Store_admin Deleted.");
        } else {
            System.out.println("Store_admin wasn't found.");
        }
    }
     public void insertShipmentAdmin(Shipment_admin s) {
        ShipmentAdmin.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Shipment_admin inserted.");
    }

    public void deleteShipmenAdmin(int id) {
        boolean result = ShipmentAdmin.deleteOne(Filters.eq("id", id)).wasAcknowledged();
        if (result) {
            System.out.println("Shipment_admin Deleted.");
        } else {
            System.out.println("Shipment_admin wasn't found.");
        }
    }
    public void insertCart(Cart c) {
        customer.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("Shipment_admin inserted.");
    }
     public void insertCustomer(Customer s) {
        customer.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Customer inserted.");
    }

    public void deleteCustomer(int id) {
        boolean result = customer.deleteOne(Filters.eq("id", id)).wasAcknowledged();
        if (result) {
            System.out.println("Customer Deleted.");
        } else {
            System.out.println("Customer wasn't found.");
        }
    }
     public void insertEmployee(Employee s) {
         employee.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Employee inserted.");
    }

    public void deleteEmployee(int id) {
        boolean result = employee.deleteOne(Filters.eq("id", id)).wasAcknowledged();
        if (result) {
            System.out.println("Employee Deleted.");
        } else {
            System.out.println("Employee wasn't found.");
        }
    }
     public void insertTransaction(Transaction t) {
        Transaction.insertOne(Document.parse(gson.toJson(t)));
        System.out.println("Transaction inserted.");
    }

    public void deleteTransaction(int id) {
        boolean result = Transaction.deleteOne(Filters.eq("id", id)).wasAcknowledged();
        if (result) {
            System.out.println("Transaction Deleted.");
        } else {
            System.out.println("Transaction wasn't found.");
        }
    }
    public void insertShipment(Shipment s) {
        Shipment.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Shipment inserted.");
    }

    public void deleteShipment(int id) {
        boolean result = Shipment.deleteOne(Filters.eq("id", id)).wasAcknowledged();
        if (result) {
            System.out.println("Shipment Deleted.");
        } else {
            System.out.println("Shipment wasn't found.");
        }
    }
    public void insertProduct(Product p) {
        Product.insertOne(Document.parse(gson.toJson(p)));
        System.out.println("Product inserted.");
    }

    public void deleteProduct(int id) {
        boolean result = Product.deleteOne(Filters.eq("id", id)).wasAcknowledged();
        if (result) {
            System.out.println("Product Deleted.");
        } else {
            System.out.println("Product wasn't found.");
        }
    }
    public void insertProductinInventory(Product i) {
        Inventory.insertOne(Document.parse(gson.toJson(i)));
        System.out.println("Product inserted in ");
    }

    public void deleteProductfromInventory(Product p ) {
        
       boolean result = Inventory.deleteOne(Filters.eq("id", p.getId())).wasAcknowledged();
     
    }
    public void updateProduct(Product s) {
        Document doc = Document.parse(gson.toJson(s));
        boolean result = Product.replaceOne(Filters.eq("id", s.getId()), doc).wasAcknowledged();
        if (result) {
            System.out.println("Product Updated.");
        } else {
            System.out.println("Product wasn't found.");
        }
    }
     public void updateShipment(Shipment s) {
        Document doc = Document.parse(gson.toJson(s));
        boolean result = Shipment.replaceOne(Filters.eq("id", s.getId()), doc).wasAcknowledged();
        if (result) {
            System.out.println("Shipment Updated.");
        } else {
            System.out.println("Shipment wasn't found.");
        }
    }
     public void updateEmployee(Employee s) {
        Document doc = Document.parse(gson.toJson(s));
        boolean result = Shipment.replaceOne(Filters.eq("id", s.getId()), doc).wasAcknowledged();
        if (result) {
            System.out.println("Shipment Updated.");
        } else {
            System.out.println("Shipment wasn't found.");
        }
    }
   public ArrayList<Transaction> getAllTransaction() {
        ArrayList<Transaction> result = new ArrayList();
        ArrayList<Document> docs = Transaction.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Transaction.class));
        }
        return result;
    }
   public ArrayList<Product> getAllsoldProducts() {
        ArrayList<Transaction> result = new ArrayList();
        ArrayList<Product> result2 = new ArrayList();
        ArrayList<Document> docs = Transaction.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Transaction.class));          
        }
        for(int i=0;i<result.size();i++)
        {
            for(int y=0;y<result.get(i).getProducts().size();y++)
            {
                result2.add(result.get(i).getProducts().get(i));
            }
        }
        return result2;
    }
   public ArrayList<Product> getAllProduct() {
        ArrayList<Product> result = new ArrayList();
        ArrayList<Document> docs = Product.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Product.class));
        }
        return result;
    }
   public ArrayList<Shipment> getAllShipment() {
        ArrayList<Shipment> result = new ArrayList();
        ArrayList<Document> docs = Shipment.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Shipment.class));
        }
        return result;
    }
   public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> result = new ArrayList();
        ArrayList<Document> docs = customer.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Customer.class));
        }
        return result;
    }
   public ArrayList<Shipment> getAllApprovedShipment() {
        ArrayList<Shipment> result = new ArrayList();
        ArrayList<Document> docs = Shipment.find(Filters.eq("Approved",true)).into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Shipment.class));
        }
        return result;
    }
   public Transaction getTransactionByID(int id) {
        Document doc=Transaction.find(Filters.eq("id",id)).first();
        Transaction result=gson.fromJson(doc.toJson(), Transaction.class);
        
        return result;
    }
   
   public ArrayList<Product> getAllProductsintoInventory() {
        ArrayList<Product> result = new ArrayList();
        ArrayList<Document> docs = Inventory.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Product.class));
        }
        return result;
    }
   public ArrayList<Transaction> getAllTransactionsforCustomer(int id) {
        ArrayList<Transaction> result = new ArrayList();
        ArrayList<Document> docs = Transaction.find(Filters.eq("Customer_id", id)).into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Transaction.class));
        }
        return result;
    }
   
   public boolean verifyCompanyadmin(String username,String password){
   
      Document docs = companyAdmin.find(Filters.and(Filters.eq("username", username),Filters.eq("password",password))).first();
      if(docs!=null)
          return true;
      else
          return false;
   }
   public boolean verifyStoreadmin(String username,String password){
   
      Document docs = storeAdmin.find(Filters.and(Filters.eq("username", username),Filters.eq("password",password))).first();
      if(docs!=null)
          return true;
      else
          return false;
   
   }
     public boolean verifyShipmentadmin(String username,String password){
   
      Document docs = ShipmentAdmin.find(Filters.and(Filters.eq("username", username),Filters.eq("password",password))).first();
      if(docs!=null)
          return true;
      else
          return false;
   
}
public boolean verifyCustomer(String username,String password){
   
      Document docs = customer.find(Filters.and(Filters.eq("username", username),Filters.eq("password",password))).first();
      if(docs!=null)
          return true;
      else
          return false;
}
}