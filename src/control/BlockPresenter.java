package control;

import model.Block;
import view.BlockDisplay;

public class BlockPresenter implements Block.Observer {

    private final Block block;
    private final BlockDisplay blockDisplay;

    public BlockPresenter(Block block, BlockDisplay blockDisplay) {
        this.block = block;
        this.blockDisplay = blockDisplay;
        this.blockDisplay.register(moved());
        this.block.register(this);
        this.paint();
    }

    private BlockDisplay.Moved moved() {
        return new BlockDisplay.Moved(){
            @Override
            public void to(int x, int y){
                block.pos(x+1,block.MAX-y);
            }
        };
    }


    @Override
    public void changed() {
        paint();
    }

    private void paint() {
        blockDisplay.display(block.x()-1,Block.MAX - block.y());
    }
}
