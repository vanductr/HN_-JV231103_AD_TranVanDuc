package ra.service;

import ra.model.Song;
import ra.model.Singer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SongService {
    private List<Song> songList;

    public SongService() {
        this.songList = new ArrayList<>();
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void addSongs() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng bài hát cần thêm: ");
        int numberOfSongs = scanner.nextInt();
        scanner.nextLine();  // Tránh nuốt dòng

        for (int i = 0; i < numberOfSongs; i++) {
            System.out.println("Nhập thông tin cho bài hát thứ " + (i + 1) + ":");
            Song song = new Song(); // Khởi tạo đối tượng

            // Gọi phương thức inputData của đối tượng Song để nhập thông tin
            song.inputData();

            // Thêm đối tượng Song vào danh sách
            songList.add(song);
        }

        System.out.println("Đã thêm " + numberOfSongs + " bài hát mới.");
    }

    public void displayAllSongs() {
        if (songList.isEmpty()) {
            System.out.println("Danh sách bài hát trống.");
        } else {
            System.out.println("\n===== Danh sách Tất cả Bài hát =====");
            int songIndex = 1;
            for (Song song : songList) {
                System.out.println("Bài hát thứ " + songIndex + ":");
                song.displayData();
                System.out.println("------------------------------");
                songIndex++;
            }
        }
    }


    public void updateSongInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã bài hát cần thay đổi thông tin: ");
        String songId = scanner.nextLine();

        Song foundSong = findSongById(songId);
        if (foundSong != null) {
            // Thực hiện thay đổi thông tin của foundSong (ví dụ: sử dụng phương thức inputData)
            foundSong.inputData();
            System.out.println("Thông tin bài hát đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy bài hát với mã " + songId);
        }
    }

    public void deleteSongById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã bài hát cần xóa: ");
        String songId = scanner.nextLine();

        Iterator<Song> iterator = songList.iterator();
        while (iterator.hasNext()) {
            Song song = iterator.next();
            if (song.getSongId().equals(songId)) {
                iterator.remove();
                System.out.println("Bài hát đã được xóa khỏi danh sách.");
                return;
            }
        }

        System.out.println("Không tìm thấy bài hát với mã " + songId);
    }

    public Song findSongById(String songId) {
        for (Song song : songList) {
            if (song.getSongId().equals(songId)) {
                return song;
            }
        }
        return null;
    }

    public List<Song> searchSongs(String keyword) {
        List<Song> result = new ArrayList<>();
        for (Song song : songList) {
            if (song.getSongName().contains(keyword) || song.getSinger().getSingerName().contains(keyword)) {
                result.add(song);
            }
        }
        return result;
    }
}
