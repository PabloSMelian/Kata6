package kata6.apps.swing;

import control.*;
import model.Block;
import view.BlockDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Main extends JFrame {

    private BlockDisplay blockDisplay;
    private Map<String, Command> commands = new HashMap<>();

    public static void main(String[] args) {
        new Main().execute();
    }
    public Main(){
        this.setTitle("Block shifter");
        this.setSize(700,762);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(blockPanel());
        this.add(toolbar(), BorderLayout.SOUTH);

        Block block = new Block(4, 4);
        BlockPresenter blockPresenter = new BlockPresenter(block, blockDisplay);
        commands.put("left", new LeftCommand(block));
        commands.put("right", new RightCommand(block));
        commands.put("up", new UpCommand(block));
        commands.put("down", new DownCommand(block));
    }

    private JMenuBar toolbar() {
        JMenuBar toolbar = new JMenuBar();
        toolbar.add(button("left"));
        toolbar.add(button("up"));
        toolbar.add(button("down"));
        toolbar.add(button("right"));
        return toolbar;
    }

    private JButton button(String name) {
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(name).execute();
            }
        });
        return button;
    }

    private JPanel blockPanel() {
        BlockPanel blockPanel = new BlockPanel(Block.MAX);
        this.blockDisplay = blockPanel;
        return blockPanel;
    }

    private void execute() {
        this.setVisible(true);
    }
}
