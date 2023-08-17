package A13ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04Songs {
    static class Song {
        String typeList;
        String name;
        String time;

        public Song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        public String getName() {
            return this.name;
        }

        public String getTypeList() {
            return this.typeList;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSongs = Integer.parseInt(scanner.nextLine());

        List<Song> songsList = new ArrayList<>();

        for (int i = 1; i <= numberOfSongs; i++) {
            String input = scanner.nextLine();
            String[] inputSongArray = input.split("_");

            String currentTypeList = inputSongArray[0];
            String currentName = inputSongArray[1];
            String currentTime = inputSongArray[2];

            Song currentSong = new Song(currentTypeList, currentName, currentTime);

            songsList.add(currentSong);
        }
        String command = scanner.nextLine();

        if (command.equals("all")) {
            for (Song song : songsList) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songsList) {
                String typeList = song.getTypeList();

                if (command.equals(typeList)) {
                    System.out.println(song.getName());
                }
            }
        }
    }
}
