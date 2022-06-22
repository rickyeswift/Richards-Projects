/*
* CMSC256-Project04
* Songs.java
* This code sets up how the data in the songs.txt will be displayed by assigning them to objects
* that will be implemented in MusicManager.java
* Richard Elliott Jr
* 06/17/2022
 */
package cmsc256;

// songs class need to implement comparable for compare to function
public class Song implements Comparable {
    private String title, artist, album;
    private int playcount;

    // constructors
    public Song() {
        setTitle("");
        setArtist("");
        setAlbum("");
        setPlaycount(0);
    }

    public Song(String title, String artist, String album, int playcount) {
        setTitle(title);
        setArtist(artist);
        setAlbum(album);
        setPlaycount(playcount);
    }


    // getters and setters
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setTitle(String t) {
        try {
            title = t.trim();
        }
        catch (NullPointerException nullArg) {
            title = "";
        }
    }

    public void setArtist(String a) {
        try{
            artist = a.trim();
        }
        catch (NullPointerException nullArg) {
            artist = "";
        }
    }

    public void setAlbum(String al) {
        try {
            album = al.trim();
        }
        catch (NullPointerException nullArg) {
            album = "";
        }
    }

    public int getPlaycount() {
        return playcount;
    }

    public void setPlaycount(int p) {
        try {
            playcount = p;
        }
        catch (NullPointerException nullArg) {
            playcount = 0;
        }
    }

    // check if two songs are the same
    public boolean equals(Object o) {
        if (o instanceof Song) {
            Song other = (Song) o;

            return artist.equals(other.getArtist()) && album.equals(other.getAlbum())
                    && title.equals(other.getTitle()) && playcount == other.getPlaycount();
        }
        return false;
    }

    // returns song in string format
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: " + title + "\nArtist: " + artist + "\nAlbum: "
                + album + "\nPlay count: " + playcount + "\n");

        return sb.toString();
    }

    // compare to function
    // since grouping has to be done by album so first check for album and if album
    // are equal the check for title
    @Override
    public int compareTo(Object o) throws NullPointerException {
        if (o == null) {
            throw new NullPointerException();
        }
        Song s = (Song) o;
        if (album.compareTo(s.getAlbum()) < 0) return 1;
        else if (album.compareTo(s.getAlbum()) == 0) return title.compareTo(s.getTitle());
        return -1;
    }
}
