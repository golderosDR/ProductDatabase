import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Product {
    private final String name;
    private double prise;
    private final Category category;
    private final String BASE_FILE;


    private final String RECORD_FORMAT = "%s | %.2f | %s";
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


    public Product(String name, double prise, Category category) throws IOException {
        this.name = name;
        this.prise = prise;
        this.category = category;
        this.BASE_FILE = String.format("./res/%s.txt", this.name);


        Date currentDate = new Date();
        makeFirstRecord(currentDate);
    }

    private void makeFirstRecord(Date date) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.BASE_FILE));
        writer.write(String.format(RECORD_FORMAT, dateFormat.format(date), this.prise, "added"));
        writer.newLine();
        writer.close();
    }

    private void makeRecord() throws IOException {
        Date currentDate = new Date();
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.BASE_FILE, true));

        writer.write(String.format(RECORD_FORMAT, dateFormat.format(currentDate), this.prise, "price changed"));
        writer.newLine();
        writer.close();
    }

    @Override
    public String toString() {
        return "Product '" + name + '\'' +
                ", prise " + String.format("%.2f Euro",prise) +
                ", category: " + category;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double newPrise) throws IOException {
        if (newPrise > 0) {
            this.prise = newPrise;
            this.makeRecord();
        }
    }
    public void setPrise() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%nEnter new prise for product '%s'. Old prise is %.2f Euro  : ", this.name, this.prise );
        double newPrise = scanner.nextDouble();
        scanner.close();

        if (newPrise > 0) {
            this.prise = newPrise;
            this.makeRecord();
        }
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
