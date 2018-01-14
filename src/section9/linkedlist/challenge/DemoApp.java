package section9.linkedlist.challenge;

import java.util.*;

public class DemoApp {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 3.13);
        album.addSong("The Gypsy", 4.20);
        album.addSong("High Ball Shooter", 4.27);
        album.addSong("You Can't Do It Right", 6.13);
        album.addSong("Lady Double Dealer", 3.23);
        album.addSong("Soldier of Fortune", 3.13);
        album.addSong("Hold On", 5.6);
        album.addSong("Holy Man", 4.3);
        album.addSong("Love Don't Mean a Thing", 4.22);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I Put the Finger On You", 3.25);
        album.addSong("Let's Go", 3.45);
        album.addSong("Inject The Venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil Walks", 3.45);
        album.addSong("C.O.D", 5.25);
        album.addSong("Breaking The Rules", 5.32);
        album.addSong("Night Of The Long Knives", 5.12);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlaylist("You Can't Do It Right", playlist);
        albums.get(0).addToPlaylist("Holy Man", playlist);
        albums.get(0).addToPlaylist("Speed King", playlist);
        albums.get(0).addToPlaylist(9, playlist);
        albums.get(1).addToPlaylist(8, playlist);
        albums.get(1).addToPlaylist(3, playlist);
        albums.get(1).addToPlaylist(2, playlist);
        albums.get(1).addToPlaylist(24, playlist);

        play(playlist);

    }

    private static void play(LinkedList<Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.isEmpty()) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
        }
        printMenu();
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if(listIterator.hasNext())
                            listIterator.next();
                        forward=true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward =false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious())
                            listIterator.previous();
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now Playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the playlist");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else
                            System.out.println("We have reached the end of the playlist");
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (!playlist.isEmpty()) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                        } else if(listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous().toString());
                        } else {
                            System.out.println("Playlist is empty");
                        }
                    } else {
                        System.out.println("Playlist is empty");
                    }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit");
        System.out.println("1 - to play next song");
        System.out.println("2 - to play previous song");
        System.out.println("3 - to replay the current song");
        System.out.println("4 - list songs in the play");
        System.out.println("5 - print available actions");
        System.out.println("6 - remove current song in the playlist");
    }

    private static void printList(LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("=======================================");
        System.out.println("Current Playlist:\n");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("=======================================");

    }
}
