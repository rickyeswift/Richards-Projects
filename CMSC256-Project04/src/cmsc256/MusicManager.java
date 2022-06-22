/*
* CMSC256-Project04
* MusicManager.java
* This code implements the objects in Song.java to help manage a music collection
* contained in the file song.txt. It will find the artist whose name is entered and list their songs
* in the playlist and generate a list of the top 5 songs played in the playlist.
* Richard Elliott Jr
* 06/17/2022
 */
package cmsc256;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class MusicManager {
    private List<Song> songs;

    public MusicManager() {

        songs = new ArrayList<>();
    }

    public void addSong(Song s) {

        songs.add(s);
    }

    // opens file and reads in songs
    public void readPlaylistFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File " + fileName + " does not exists");
            return;
        }

        Scanner filesc = new Scanner(file);

        // till the end of file
        while (filesc.hasNext()) {
            String line = filesc.nextLine();
            String tokens[] = line.split(":");

            // parse string into int
            int playcount = Integer.parseInt(tokens[3]);

            Song s = new Song(tokens[0], tokens[1], tokens[2], playcount);
            addSong(s);
        }
        filesc.close();
    }

    public boolean hasSongsBy(String artist) {
        for (Song song : songs) {
            if (song.getArtist().equals(artist)) return true;
        }
        return false;
    }

    public List<Song> getSongsBy(String artist) {

        List<Song> ans = new ArrayList<>();
        // if artist matches add song to ans
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getArtist().equals(artist))
                ans.add(songs.get(i));
        }

        // sort will use compareTo function of song class
        // which will group songs by album
        Collections.sort(ans);
        return ans;
    }

    public Song[] getTop5Songs() {
        Song[] ans = new Song[5];

        int i;
        for (i = 0; i < 5; i++) {
            ans[0] = new Song();
        }

        for (i = 0; i < 5; i++) {
            // if this song is more played than 0th then it is the highest played
            if (songs.get(i).getPlaycount() > ans[0].getPlaycount()) {
                // move rest songs to 1 index right
                ans[4] = ans[3];
                ans[3] = ans[2];
                ans[2] = ans[1];
                ans[1] = ans[0];
                // at index 0 put this song
                ans[0] = songs.get(i);
            }
            // similarly for others
            else if (songs.get(i).getPlaycount() > ans[1].getPlaycount()) {
                ans[4] = ans[3];
                ans[3] = ans[2];
                ans[2] = ans[1];
                ans[1] = songs.get(i);
            } else if (songs.get(i).getPlaycount() > ans[2].getPlaycount()) {
                ans[4] = ans[3];
                ans[3] = ans[2];
                ans[2] = songs.get(i);
            } else if (songs.get(i).getPlaycount() > ans[3].getPlaycount()) {
                ans[4] = ans[3];
                ans[3] = songs.get(i);
            } else if (songs.get(i).getPlaycount() > ans[4].getPlaycount()) {
                ans[4] = songs.get(i);
            }
        }

        return ans;
    }

    // testing
    public static void main(String[] args) throws FileNotFoundException {
        MusicManager ms = new MusicManager();

        ms.readPlaylistFile("songs.txt");

        System.out.println("\nChecking if Kendrick Lamar song exists: " + ms.hasSongsBy("Kendrick Lamar"));

        System.out.println("\nGetting all Kendrick Lamar songs\n");
        List<Song> l = ms.getSongsBy("Kendrick Lamar");

        for (Song song : l) {
            System.out.println(song);
        }
        System.out.println("Getting top 5 songs:\n");
        Song[] l2 = ms.getTop5Songs();

        for (int i = 0; i < 5; i++) {
            System.out.println(l2[i]);
        }
        System.out.println();
    }
}
