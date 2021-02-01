package view;

import model.Block;

public interface BlockDisplay {
    void display(int x, int y);
    void register(Moved moved);

    interface Moved {
        void to (int x, int y);
    }
}
