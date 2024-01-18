package ra.model;

import java.util.Scanner;

public class Singer {
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    // Constructors
    public Singer() {
    }

    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    // Getter and Setter methods
    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Input data method
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tên ca sĩ: ");
        this.singerName = scanner.nextLine();
        System.out.print("Tuổi: ");
        this.age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Quốc gia: ");
        this.nationality = scanner.nextLine();
        System.out.print("Giới tính (Nhập: true nếu là Name, false nếu là nữ): ");
        this.gender = scanner.nextBoolean();
        scanner.nextLine(); // Tránh nuốt dòng.
        System.out.print("Thể loại nhạc trình diễn: ");
        this.genre = scanner.nextLine();
    }

    // Phương thức hiển thị Danh sách Tất cả ca sĩ
    public void displayData() {
        System.out.println("ID Ca sĩ: " + this.singerId);
        System.out.println("Tên ca sĩ: " + this.singerName);
        System.out.println("Tuổi: " + this.age);
        System.out.println("Quốc tịch: " + this.nationality);
        System.out.println("Giới tính: " + (this.gender ? "Male" : "Female"));
        System.out.println("Thể loại: " + this.genre);
    }
}
