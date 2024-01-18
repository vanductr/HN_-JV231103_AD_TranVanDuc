package ra.model;

import ra.service.SingerService;

import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    // Constructors
    public Song() {
    }

    public Song(String songId, String songName, String descriptions, Singer singer, String songWriter) {
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = new Date(); // Default to current system time
        this.songStatus = true; // Default to true
    }

    // Getter and Setter methods
    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    // Input data method
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin bài hát:");
        System.out.print("ID Bài hát(4 ký tự bắt đầu bằng 'S'): ");
        this.songId = scanner.nextLine();
        System.out.print("Tên Bài hát: ");
        this.songName = scanner.nextLine();
        System.out.print("Mô tả: ");
        this.descriptions = scanner.nextLine();

        // Đang fix !!!!
//        // Hiển thị ca sĩ có sẵn để người dùng lựa chọn
//        System.out.println("Ca sĩ có sẵn:");
//        SingerService singerService = new SingerService();
//        singerService.displayAllSingers();
//
//        System.out.print("Chọn ID ca sĩ: ");
//        int singerId = scanner.nextInt();
//
//        // Tìm nạp đối tượng Singer dựa trên ID đã chọn
//        Singer chosenSinger = singerService.findSingerById(singerId);
//
//        // Kiểm tra xem Ca sĩ được chọn có hay  không
//        if (chosenSinger != null) {
//            // Set the chosenSinger to the singer property
//            Song song = new Song();
//            song.setSinger(chosenSinger);
//            System.out.println("Đã chọn ca sĩ: " + chosenSinger.getSingerName());
//        } else {
//            System.out.println("Không tìm thấy ca sĩ với ID đã chọn.");
//        }


//        scanner.nextLine(); // Tránh nuốt dòng
        System.out.print("Người Sáng tác: ");
        this.songWriter = scanner.nextLine();
    }

    // Display data method
    public void displayData() {
        System.out.println("ID bài hát: " + this.songId);
        System.out.println("Tên bài hát: " + this.songName);
        System.out.println("Thể loại: " + this.descriptions);
//        System.out.println("Ca sĩ: " + this.singer.getSingerName());
        System.out.println("Tác giả: " + this.songWriter);
        System.out.println("Ngày tạo: " + this.createdDate);
        System.out.println("Trạng thái bài hát: " + (this.songStatus ? "Active" : "Inactive"));
    }
}


