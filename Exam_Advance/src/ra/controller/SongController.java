package ra.controller;

import ra.model.Song;
import ra.service.SingerService;
import ra.service.SongService;

import java.util.List;
import java.util.Scanner;

public class SongController {
    private SongService songService;
    private SingerService singerService;

    // Phương thức khởi tạo không tham số
    public SongController() {
        this.songService = new SongService();
    }

    public SongController(SongService songService, SingerService singerService) {
        this.songService = songService;
        this.singerService = singerService;
    }

    public void displaySongManagementMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**********************SONG-MANAGEMENT*************************");
            System.out.println("1. Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới");
            System.out.println("2. Hiển thị danh sách tất cả bài hát đã lưu trữ");
            System.out.println("3. Thay đổi thông tin bài hát theo mã id");
            System.out.println("4. Xóa bài hát theo mã id");
            System.out.println("5. Thoát");

            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline character

            switch (choice) {
                case 1:
                    songService.addSongs();
                    break;
                case 2:
                    songService.displayAllSongs();
                    break;
                case 3:
                    songService.updateSongInfo();
                    break;
                case 4:
                    songService.deleteSongById();
                    break;
                case 5:
                    System.out.println("Thoát khỏi quản lý bài hát");
                    return;  // thoát khỏi menu quản lý bài hát
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}

