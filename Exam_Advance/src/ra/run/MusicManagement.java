package ra.run;

import ra.controller.SingerController;
import ra.controller.SongController;
import ra.service.SingerService;
import ra.service.SongService;

import java.util.Scanner;

public class MusicManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SingerService singerService = new SingerService();
        SongService songService = new SongService();

        //SingerController singerController = new SingerController(); // Khởi tạo đối tượng từ Lớp SingerController
        //SongController songController = new SongController(); // Khởi tạo đối tượng từ Lớp SongController

        SingerController singerController = new SingerController(singerService);
        SongController songController = new SongController(songService, singerService);

        while (true) {
            System.out.println("************************MUSIC-MANAGEMENT*************************");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");

            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline character

            switch (choice) {
                case 1:
                    // Gọi phương thức để quản lý ca sĩ
                    singerController.displaySingerManagementMenu();
                    break;
                case 2:
                    // Gọi phương thức để quản lý bài hát
                    songController.displaySongManagementMenu();
                    break;
                case 3:
                    // TODO: Gọi phương thức để tìm kiếm bài hát
                    break;
                case 4:
                    System.out.println("Thoát khỏi chương trình");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}


