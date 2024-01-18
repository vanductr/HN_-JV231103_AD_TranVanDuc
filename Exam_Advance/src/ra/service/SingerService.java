// SingerService: Có chức năng thực hiện Thêm-Sủa-Xoá-Hiển thị
// Danh sách Ca sĩ.
package ra.service;

import ra.model.Singer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SingerService {
    private List<Singer> singers;

    private static int currentSingerId = 1; // Biến static để theo dõi giá trị singerId


    public SingerService() {
        this.singers = new ArrayList<>();
    }

    // Phương thức thêm Ca sĩ (Singer).
    public void addSingers() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng ca sĩ cần thêm: ");
        int numberOfSingers = scanner.nextInt();

        for (int i = 0; i < numberOfSingers; i++) {
            System.out.println("Nhập thông tin cho ca sĩ thứ " + (i + 1) + ":");
            Singer singer = new Singer();

            // Gọi phương thức inputData của đối tượng Singer để nhập thông tin
            singer.inputData();

            // Tăng giá trị singerId và gán cho ca sĩ mới
            singer.setSingerId(currentSingerId++);

            // Thêm đối tượng Singer vào danh sách
            singers.add(singer);
        }

        System.out.println("Đã thêm " + numberOfSingers + " ca sĩ mới.");
    }


    public void displayAllSingers() {
        if (singers.isEmpty()) {
            System.out.println("Danh sách Ca sĩ trống.");
        } else {
            System.out.println("\n===== Danh sách Tất cả Ca sĩ =====");
            for (Singer singer : singers) {
                System.out.println("Ca sĩ thứ " + (singers.indexOf(singer) + 1) + ":");
                singer.displayData();
                System.out.println("------------------------------");
            }
        }
    }



    public void updateSingerInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã ca sĩ cần thay đổi thông tin: ");
        int singerId = scanner.nextInt();

        // Tìm ca sĩ trong danh sách theo mã
        Singer foundSinger = null;
        for (Singer singer : singers) {
            if (singer.getSingerId() == singerId) {
                foundSinger = singer;
                break; // Kết thúc vòng lặp nếu đã tìm thấy ca sĩ
            }
        }

        // Kiểm tra xem có tìm thấy ca sĩ hay không
        if (foundSinger != null) {
            // Hiển thị thông tin ca sĩ trước khi cập nhật
            System.out.println("Thông tin ca sĩ trước khi cập nhật:");
            foundSinger.displayData();

            // Thực hiện cập nhật thông tin
            System.out.println("Nhập thông tin mới cho ca sĩ:");
            foundSinger.inputData();

            // Hiển thị thông tin ca sĩ sau khi cập nhật
            System.out.println("Thông tin ca sĩ sau khi cập nhật:");
            foundSinger.displayData();

            System.out.println("Thông tin ca sĩ đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy ca sĩ với mã " + singerId);
        }
    }

    public void deleteSingerById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã ca sĩ cần xóa: ");
        int singerId = scanner.nextInt();

        // Tìm ca sĩ trong danh sách theo mã
        Singer singerToRemove = null;
        for (Singer singer : singers) {
            if (singer.getSingerId() == singerId) {
                singerToRemove = singer;
                break; // Kết thúc vòng lặp nếu đã tìm thấy ca sĩ
            }
        }

        // Kiểm tra xem có tìm thấy ca sĩ hay không
        if (singerToRemove != null) {
            // Hiển thị thông tin ca sĩ trước khi xóa
            System.out.println("Thông tin ca sĩ trước khi xóa:");
            singerToRemove.displayData();

            // Xóa ca sĩ khỏi danh sách
            singers.remove(singerToRemove);

            System.out.println("Ca sĩ đã được xóa khỏi danh sách.");
        } else {
            System.out.println("Không tìm thấy ca sĩ với mã " + singerId);
        }
    }

    public Singer findSingerById(int singerId) {
        for (Singer singer : singers) {
            if (singer.getSingerId() == singerId) {
                return singer; // Trả về đối tượng Singer nếu tìm thấy ID tương ứng
            }
        }
        return null; // Trả về null nếu không tìm thấy ca sĩ với ID đã cho
    }
}


