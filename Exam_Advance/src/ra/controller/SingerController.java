// SingerController: Có chức năng Hiển thị Menu và điều hướng chức năng
package ra.controller;

import ra.model.Singer;
import ra.service.SingerService;

import java.util.List;
import java.util.Scanner;

public class SingerController {
    private SingerService singerService;

    public SingerController(SingerService singerService) {
        this.singerService = singerService;
    }

//    public List<Singer> getAllSingers() {
//        return singerService.getSingerList();
//    }

    // Phương thức khởi tạo đối tượng không tham số
    public SingerController() {
        this.singerService = new SingerService();
    }

    // Menu và điều hướng Menu.
    public void displaySingerManagementMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**********************SINGER-MANAGEMENT*************************");
            System.out.println("1. Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới");
            System.out.println("2. Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
            System.out.println("3. Thay đổi thông tin ca sĩ theo mã id");
            System.out.println("4. Xóa ca sĩ theo mã id");
            System.out.println("5. Thoát");

            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline character

            switch (choice) {
                case 1:
                    singerService.addSingers();
                    break;
                case 2:
                    singerService.displayAllSingers();
                    break;
                case 3:
                    singerService.updateSingerInfo();
                    break;
                case 4:
                    singerService.deleteSingerById();
                    break;
                case 5:
                    System.out.println("Thoát khỏi quản lý ca sĩ");
                    return;  // thoát khỏi menu quản lý ca sĩ
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }

    }
}

