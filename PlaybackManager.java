import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * VelociTrack -- PlaybackManager
 *
 * Tracks what's playing now, what played before (a STACK), and what
 * plays next (a QUEUE).
 *
 * Before you code, answer this: why is "recently played" a stack and
 * "up next" a queue, and not the other way around?
 */
public class PlaybackManager {
    private Playable nowPlaying;
    private Stack<Playable> recentlyPlayed;   // LIFO: last played is on top
    private Queue<Playable> upNext;           // FIFO: first added plays first

    public PlaybackManager() {
        nowPlaying = null;
        recentlyPlayed = new Stack<>();
        upNext = new LinkedList<>();   // java.util.LinkedList used AS a Queue
    }

    public Playable getNowPlaying() { 
        return nowPlaying; 
    }

    // ---------------------------------------------------------------
    // addToQueue -- puts an item at the BACK of the Up Next line.
    // TODO: one line. Which Queue method adds to the back?
    // ---------------------------------------------------------------
    public void addToQueue(Playable item) {
        upNext.offer(item);
    }

    // ---------------------------------------------------------------
    // addPlaylistToQueue -- queues every item in a playlist, in order.
    // TODO: your Playlist is Iterable, so a for-each loop works here.
    // ---------------------------------------------------------------
    public void addPlaylistToQueue(Playlist playlist) {
        for(Playable p : playlist){
            upNext.offer(p);
        }
    }

    // ---------------------------------------------------------------
    // playNext -- plays whatever is at the FRONT of Up Next.
    // TODO:
    //   1. If upNext is empty, print a friendly message and return null.
    //   2. If something is currently playing, it's about to become
    //      history. Where does it go?
    //   3. Take the next item off the front of the queue, make it
    //      nowPlaying, call play() on it, and return it.
    //   Hint: look up the difference between poll() and remove().
    // ---------------------------------------------------------------
    public Playable playNext() {
        if(upNext.isEmpty()){
            System.out.println("Up next is empty. Have you tried adding a song?");
            return null;
        }
        if (nowPlaying != null){
            recentlyPlayed.push(nowPlaying);
        }
        nowPlaying = upNext.poll();
        nowPlaying.play();
        return nowPlaying;
    }

    // ---------------------------------------------------------------
    // goBack -- returns to the most recently played item.
    // TODO:
    //   1. If recentlyPlayed is empty, print a message and return null.
    //   2. Take the top item off the stack, make it nowPlaying, play it,
    //      and return it.
    //   Think about it: what should happen to the item that WAS playing?
    //   (There's more than one reasonable answer. Pick one and comment why.)
    // ---------------------------------------------------------------
    public Playable goBack() {
        if(recentlyPlayed.isEmpty()){
            System.out.println("Nothing to go back to yet. Try listening to at least one thing, please");
            return null;
        }
        nowPlaying = recentlyPlayed.pop();
        nowPlaying.play();
        return nowPlaying;
    }

    // ---------------------------------------------------------------
    // Display helpers -- optional but handy for Main's menu.
    // TODO: print upNext front-to-back and recentlyPlayed most-recent-first.
    //   Careful: printing a Stack with a for-each goes bottom-to-top!
    // ---------------------------------------------------------------
    public void showUpNext() {
        // TODO
    }

    public void showRecentlyPlayed() {
        // TODO
    }
}
