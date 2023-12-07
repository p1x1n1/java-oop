import java.util.Iterator;
import java.util.NoSuchElementException;

public class UndeadUterable<String> implements Iterator<String> {
    private String[] elements;
    private int position;
    public UndeadUterable(String[] elements) {
        this.elements = elements;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < elements.length;
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return elements[position++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
