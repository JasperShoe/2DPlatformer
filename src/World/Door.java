package World;
import Characters.*;
import Client.Images;

import java.awt.*;

public class Door extends Sprite {
    private boolean open, locked;
    private int orientation;
    public Door(Rectangle rect, Floor parent){
        super(rect.x, rect.y, rect.width, rect.height);
        open = false;
        orientation = (rect.width > rect.height)?Wall.HORIZONTAL:Wall.VERTICAL;

        if(orientation == Wall.HORIZONTAL) {
            setDimensions(rect.x + 3 * rect.width/7, rect.y, rect.width / 7, rect.height);
            parent.addWall(new Point(rect.x, rect.y + rect.height/4), new Point(0, rect.height /2), false,true);
            parent.addWall(new Point(rect.x + rect.width, rect.y + rect.height/4), new Point(0, rect.height / 2), false, true);
//            setDimensions(rect.x + 3 * rect.width/7, rect.y, rect.width / 7, rect.height);
        }
        else{
            setDimensions(rect.x, rect.y + 3 * rect.height/7, rect.width, rect.height /7);
            parent.addWall(new Point(rect.x + rect.width/4, rect.y), new Point(rect.width / 2, 0), false, true);
            parent.addWall(new Point(rect.x + rect.width/4, rect.y + rect.height), new Point(rect.width / 2, 0), false,true);

//            setDimensions(rect.x, rect.y + 3 * rect.height/7, rect.width, rect.height /7);
        }


    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        if(!locked){
            this.open = open;
        }
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void draw(Graphics2D g2){
        if(orientation == Wall.HORIZONTAL) {
            if(open) {
                g2.drawImage(Images.list.get("door_opened"), null, getX(), getY() - Images.list.get("door_opened").getHeight() + 10);
            } else {
                g2.drawImage(Images.list.get("door_closed"), null, getX(), getY() - Images.list.get("door_closed").getHeight() + 10);
            }
        }
    }
}
