public class PlaylistNode {
    private Playable item;
    private PlaylistNode prev;
    private PlaylistNode next;

    public PlaylistNode(Playable item) {
        this.item = item;
        this.prev = null;
        this.next = null;
    }

    public Playable getItem() { 
      return item; 
    }
    public PlaylistNode getPrev() { 
      return prev; 
    }
    public PlaylistNode getNext(){ 
      return next; 
    }

    public void setPrev(PlaylistNode prev){ 
      this.prev = prev; 
    }
    public void setNext(PlaylistNode next) { 
      this.next = next; 
    }
}
