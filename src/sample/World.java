package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class World {

    private final int size;
    private boolean[] state;

    public World(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Illegal size value!");
        }
        this.size = size;
        this.state = new boolean[size];
    }

    public boolean get(int n) {
        return state[n];
    }

    public void set(int n) {
        state[n] = true;
    }

    public void unset(int n) {
        state[n] = false;
    }

    public boolean toggle(int n) {
        state[n] = !state[n];
        return !state[n];
    }

    public int getSize() {
        return size;
    }

    public boolean[] getState() {
        return state;
    }

    @Override
    public String toString() {
        return Arrays.toString(state);
    }

    public List<Triple> getTriples() {
        List<Triple> result = new ArrayList<Triple>();

        for (int i = 0; i < state.length; i++) {
            boolean left;
            boolean middle = state[i];
            boolean right;

            if (i == 0) {
                left = false;
            } else {
                left = state[i - 1];
            }
            if (i == state.length - 1) {
                right = false;
            } else {
                right = state[i + 1];
            }
            Triple t = Triple.of(left, middle, right);
            result.add(t);
        }
        return result;
    }

    public boolean[] nextFrame(Rule ruleset) {
        boolean[] next = new boolean[size];
        List<Triple> triples = getTriples();

        for (int n = 0; n < size; n++) {
            Triple t = triples.get(n);
            next[n] = ruleset.map(t);
        }
        this.state = next;
        return next;
    }
}

