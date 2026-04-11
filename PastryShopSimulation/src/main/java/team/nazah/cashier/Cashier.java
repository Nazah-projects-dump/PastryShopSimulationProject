package team.nazah.cashier;

import common.AppendableObjectOutputStream;
import common.Employee;
import common.User;

import java.io.*;
import java.util.ArrayList;

public class Cashier extends User implements Employee , Serializable {
    private String password;
    private String branch;
    private static final long serialVersionUID = 1L;

    public Cashier() {
    }

    public Cashier(String userId, String name, String password, String branch) {
        super(userId, name);
        this.password = password;
        this.branch = branch;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String getEmployeeId() {
        return getUserId();
    }

    @Override
    public String getBranch() {
        return branch;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "password='" + password + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }

    @Override
    public void showDashboard() {

    }

    @Override
    public boolean login(String name, String password) {
        return false;
    }

    public static void saveCashier(Cashier cashier) {
        try {
            File f = new File("Cashier.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(cashier);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Cashier> loadCashiers() {
        ArrayList<Cashier> list = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("Cashier.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                Cashier c = (Cashier) ois.readObject();
                list.add(c);
            }

        } catch (EOFException e) {
            //
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /*public static void createCashiers() {
        saveCashier(new Cashier("1", "Jess", "1234", "Main"));
        saveCashier(new Cashier("2", "Ken", "5678", "Secondary"));
        saveCashier(new Cashier("3", "Sarah", "2378", "Main"));
    }*/
}
