import java.util.Iterator;
import java.util.NoSuchElementException;
//the important part here is the implements<Playable>
  // Adding this will allow us to actually make this playlist iterable
public class Playlist implements Iterable<Playable> { 
    private String name;
    private PlaylistNode head;
    private PlaylistNode tail;
    private int size;

    public Playlist(String name) {
        this.name = name;
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    //normal getters and setters and isEmpty() for doubly linked list
    public String getName(){ 
      return name; 
    }
    public int getSize(){ 
      return size; 
    }
    public boolean isEmpty(){ 
      return size == 0; 
    }
    //because we are keeping track of the head and the tail this is O(1) 
    //handle two cases
    //1: playlist is empty, item becomes both head and tail
    //2: playlist is not empty, change tail to point to newNode, set newNode prev to tail, then make tail the new node
    //add to size.
    public void addSong(Playable item) {
        PlaylistNode newNode = new PlaylistNode(item);
        //TODO: read above
    }

    // ---------------------------------------------------------------
    // removeSong -- removes the FIRST item whose title matches.
    // Returns true if something was removed, false otherwise.
    //
    // TODO:
    //   1. Walk the list with a PlaylistNode "current" until you find a
    //      matching title (use equalsIgnoreCase) or run off the end.
    //   2. Not found? return false.
    //   3. Found it -- figure out which case you're in:
    //        a) it's the ONLY node      -> head and tail both become null
    //        b) it's the HEAD           -> head moves forward; new head's prev = null
    //        c) it's the TAIL           -> tail moves back; new tail's next = null
    //        d) it's in the MIDDLE      -> connect current.prev and current.next
    //                                      to each other (both directions!)
    //   4. Don't forget size--.
    //   Draw it on paper first. Every broken linked list is a missing arrow.
    // ---------------------------------------------------------------
    public boolean removeSong(String title) {
        // TODO
        return false;
    }

    // ---------------------------------------------------------------
    // reorder -- moves the item at fromIndex so it ends up at toIndex.
    //   Example: [A, B, C, D], reorder(0, 2) -> [B, C, A, D]
    //
    // TODO (students):
    //   1. Validate both indexes (0 to size-1). Bad index? Throw
    //      IndexOutOfBoundsException, or just return. Decide and be consistent.
    //   2. If fromIndex == toIndex, there's nothing to do.
    //   3. Find the node at fromIndex and UNLINK it (the same four cases as
    //      removeSong -- could a private helper method save you work?).
    //   4. Walk to the spot for toIndex and LINK it back in. Watch for
    //      inserting at the new head or the new tail.
    //   Hint: writing private helpers like getNodeAt(int index),
    //   unlink(PlaylistNode n), and insertBefore(PlaylistNode target,
    //   PlaylistNode n) makes this method just a few lines long.
    // ---------------------------------------------------------------
    public void reorder(int fromIndex, int toIndex) {
        // TODO
    }

    // Iterable requirement -- hands back a fresh iterator each time it is asked for
    @Override
    public Iterator<Playable> iterator() {
        return new PlaylistIterator();
    }
    // PlaylistIterator -- private inner class.
    // Being an inner class means it can see head, but no one OUTSIDE
    // Playlist ever touches a PlaylistNode. That's encapsulation.
    private class PlaylistIterator implements Iterator<Playable> {
        private PlaylistNode current = head;   // starts at the front

        @Override
        public boolean hasNext() {
            //if we are at any node that points to null we know we don't have a next
            //we could write an if(current!=null){return true;} but that is redundant
            return current != null;
        }

        @Override
        public Playable next() {
            //if we can't go on we need to throw an exception
            if (!hasNext()) {
                throw new NoSuchElementException("End of playlist reached.");
            }
            //if we can go on then we get the item and remember it, then move to next, then return the item we got
            Playable item = current.getItem();
            current = current.getNext();
            return item;
        }
    }

    // toString-note that it uses our OWN iterator via for-each. that is what "this" refers to...this current object is the one to loop through
    @Override
    public String toString() {
        if (isEmpty()) {
            return name + " (empty)";
        }

        //Needed to use a StringBuilder due to concation making my head hurt
        StringBuilder playlistString = new StringBuilder(name + " (" + size + " items)\n");
        int position = 1;
        for (Playable p : this) {
            playlistString.append("  ").append(position++).append(". ")
              .append(p.getTitle()).append(" - ").append(p.getCreator())
              .append("\n");
        }
        return playlistString.toString();
    }
}
