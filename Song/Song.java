// Student: Theodore Kim
// 10.07.2020
// CSE 142 Section BO
// TA: Sandy Cheng
// Song
// Prints the song "There Was an Old Woman Who Swallowed a Fly."

public class Song {
    public static void main(String[] args) {
        printFirstVerse();
        printSecondVerse();
        printThirdVerse();
        printFourthVerse();
        printFifthVerse();
        printSixthVerse();
        printSeventhVerse();
    }

    //Prints first verse of the song.
    public static void printFirstVerse() {
        System.out.println("There was an old woman who swallowed a fly.");
        printLastTwoLines();
    }

    //Prints second verse of the song.
    public static void printSecondVerse() {
        System.out.println("There was an old woman who swallowed a spider,");
        System.out.println("That wriggled and iggled and jiggled inside her.");
        printLastThreeLines();
    }

    //Prints third verse of the song.
    public static void printThirdVerse() {
        System.out.println("There was an old woman who swallowed a bird,");
        System.out.println("How absurd to swallow a bird.");
        printLastFourLines();
    }

    //Prints fourth verse of the song.
    public static void printFourthVerse() {
        System.out.println("There was an old woman who swallowed a cat,");
        System.out.println("Imagine that to swallow a cat.");
        printLastFiveLines();
    }

    //Prints fifth verse of the song.
    public static void printFifthVerse() {
        System.out.println("There was an old woman who swallowed a dog,");
        System.out.println("What a hog to swallow a dog.");
        printLastSixLines();
    }

    //Prints sixth verse of the song.
    public static void printSixthVerse() {
        System.out.println("There was an old woman who swallowed a snake,");
        System.out.println("It made her tummy ache to swallow a snake.");
        printLastSevenLines();
    }

    //Prints seventh verse of the song.
    public static void printSeventhVerse() {
        System.out.println("There was an old woman who swallowed a horse,");
        System.out.println("She died of course.");
    }

    //Prints last two lines of a verse.
    public static void printLastTwoLines() {
        System.out.println("I don't know why she swallowed that fly,");
        System.out.println("Perhaps she'll die.");
        System.out.println();
    }

    //Prints last three lines of a verse.
    public static void printLastThreeLines() {
        System.out.println("She swallowed the spider to catch the fly,");
        printLastTwoLines();
    }

    //Prints last four lines of a verse.
    public static void printLastFourLines() {
        System.out.println("She swallowed the bird to catch the spider,");
        printLastThreeLines();
    }

    //Prints last five lines of a verse.      
    public static void printLastFiveLines() {
        System.out.println("She swallowed the cat to catch the bird,");
        printLastFourLines();
    }

    //Prints last six lines of a verse.      
    public static void printLastSixLines() {
        System.out.println("She swallowed the dog to catch the cat,");
        printLastFiveLines();
    }

    //Prints last seven lines of a verse.
    public static void printLastSevenLines() {
        System.out.println("She swallowed the snake to catch the dog,");
        printLastSixLines();
    }
}