/*
 * This file is part of the Illarion Mapeditor.
 *
 * Copyright © 2011 - Illarion e.V.
 *
 * The Illarion Mapeditor is free software: you can redistribute i and/or modify
 * it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * The Illarion Mapeditor is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * the Illarion Mapeditor. If not, see <http://www.gnu.org/licenses/>.
 */
package illarion.mapedit.graphics;

/**
 * A item that is rendered by the graphic display.
 * 
 * @author Martin Karing
 * @since 0.99
 */
public interface DisplayItem {
    /**
     * Draw the object on the screen.
     * 
     * @return true in case the render operation was performed correctly
     */
    boolean draw();

    /**
     * Get the z order of the item. This order is used to sort the display items
     * in a proper order to be rendered.
     * 
     * @return the z layer coordinate of the display item
     */
    int getZOrder();

    /**
     * Remove object from display list.
     */
    void hide();

    /**
     * Show object by adding it to the display list.
     */
    void show();
}
